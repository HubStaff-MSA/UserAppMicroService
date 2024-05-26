package com.roba.security.MQ.MQ.MQConsumer;

//import com.hubstaffmicroservices.tracktime.Commands.CommandsMap;
//import com.hubstaffmicroservices.tracktime.MQ.dto.CommandSender;
//import com.hubstaffmicroservices.tracktime.TrackTimeService;
import com.roba.security.MQ.MQ.dto.CommandSender;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.CommandsMap;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RabbitMQListenerConsumer {
    private final AuthenticationService authenticationService;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQListenerConsumer(AuthenticationService authenticationService, RabbitTemplate rabbitTemplate) {
        this.authenticationService = authenticationService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "commandQueueUser")
    public void receiveMessage(CommandSender commandSender) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println("Received command: " + commandSender.getCommand());
        System.out.println("Received payload: " + commandSender.getPayload());
        System.out.println("Requesting queue: " + commandSender.getRequestingQueue());
        Object returnedValue = callCmdMap(commandSender.getCommand() , commandSender.getPayload());

        System.out.println(returnedValue.toString());
        // Cast the returned value to TrackTime
        if (returnedValue != null) {
            //// was tracktime queue
           // rabbitTemplate.convertAndSend("reports", returnedValue);
           // rabbitTemplate.convertAndSend("reports", returnedValue);
            rabbitTemplate.convertAndSend(commandSender.getRequestingQueue(), returnedValue);
            System.out.println("Published returned value to "+ commandSender.getRequestingQueue()+" queue.");
        }
       // return returnedValue;
    }


///////////////////////////////////////////////
    @RabbitListener(queues = "WebServerUserQueue")
    public Object receiveMessagefromwebserver(CommandSender commandSender) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        System.out.println("Received command: " + commandSender.getCommand());
        System.out.println("Received payload: " + commandSender.getPayload());
        System.out.println("Requesting queue: " + commandSender.getRequestingQueue());
        Object returnedValue = callCmdMap(commandSender.getCommand() , commandSender.getPayload());

        System.out.println(returnedValue.toString());
        // Cast the returned value to TrackTime
        if (returnedValue != null) {

            //rabbitTemplate.convertAndSend(commandSender.getRequestingQueue(), returnedValue);
           // System.out.println("Published returned value to "+ commandSender.getRequestingQueue()+" queue.");
        }
         return returnedValue;
    }

    public Object callCmdMap(String Command , Object Payload) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, NoSuchFieldException {
        Field cmdMapField = CommandsMap.class.getDeclaredField("cmdMap");

        // Make the field accessible
        cmdMapField.setAccessible(true);
        // Get the cmdMap value
        Object cmdMapValue = cmdMapField.get(null);
        // Assuming cmdMapValue is a Map<String, Class<?>>
        ConcurrentHashMap<String, Class<?>> cmdMap = (ConcurrentHashMap<String, Class<?>>) cmdMapValue;

        Class<?> commandClass = (Class<?>) cmdMap.get(Command);

        // Object commandInstance = commandClass.newInstance();
        Object commandInstance = commandClass.getDeclaredConstructor(AuthenticationService.class).newInstance(authenticationService);

        // Get the build method of the command class
        Method buildMethod = commandClass.getDeclaredMethod("build", Object.class);

        // Invoke the build method
        buildMethod.invoke(commandInstance, Payload);

        // Get the execute method of the command class
        Method executeMethod = commandClass.getDeclaredMethod("execute", null);

        // Invoke the execute method
        executeMethod.invoke(commandInstance);

        // Get the returned field of the command class
        Field returnedField = commandClass.getDeclaredField("returned");

        // Make the field accessible
        returnedField.setAccessible(true);

        // Get the value of the returned field from the command instance
        Object returnedValue = (Object) returnedField.get(commandInstance);

        return returnedValue;
    }

}
