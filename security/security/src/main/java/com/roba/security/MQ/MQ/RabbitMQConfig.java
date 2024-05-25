package com.roba.security.MQ.MQ;


//import com.hubstaffmicroservices.tracktime.MQ.dto.CommandSender;
import com.roba.security.MQ.MQ.dto.CommandSender;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(CachingConnectionFactory cachingConnectionFactory) {
        return new RabbitAdmin(cachingConnectionFactory);
    }

    @Bean
    //the commandqueue is the queue i listen to
    public Queue commandQueueUser() {
        return new Queue("commandQueueUser", false);
    }
    //add bean annotation before every new queue
    @Bean
    public Queue U_R_Queue() {
        return new Queue("U_R_Queue", false);
    }
    @Bean
    public Queue U_F_Queue() {
        return new Queue("U_F_Queue", false);
    }
    @Bean
    public Queue webserverQueue() {
        return new Queue("webserverQueue", false);
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("commandSender", CommandSender.class);
        typeMapper.setIdClassMapping(idClassMapping);
        converter.setJavaTypeMapper(typeMapper);
        return converter;
    }
}
