package com.quentin.tpamqp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quentin.tpamqp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private static final Logger Log = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void registerUser(User user) {
        try {
            String userAsJson = objectMapper.writeValueAsString(user);
            rabbitTemplate.convertAndSend("RabbitExchange", "myRoutingKey", userAsJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Log.error("e");
        } }
}