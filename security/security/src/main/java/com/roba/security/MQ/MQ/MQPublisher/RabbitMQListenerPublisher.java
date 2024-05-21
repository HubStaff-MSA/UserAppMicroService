package com.roba.security.MQ.MQ.MQPublisher;

//import com.hubstaffmicroservices.tracktime.MQ.dto.TrackTimeDTO;
//import com.hubstaffmicroservices.tracktime.TrackTime;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import com.roba.security.user.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListenerPublisher {


    @RabbitListener(queues = "reports")
    public void receiveMessage(User user) {
       // System.out.println("Received user message:");
        //System.out.println("ID: " + user.getId());
//        System.out.println("User ID: " + trackTime.getUserId());
//        System.out.println("Start Time: " + trackTime.getStartTime());
//        System.out.println("End Time: " + trackTime.getEndTime());
    }


}
