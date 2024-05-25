package com.roba.security.MQ.MQ.dto;

import java.io.Serializable;

public class CommandSender implements Serializable {

    private String command;
    private Object payload;
   // private Object publishQueue;
    private String requestQueue;

    // Default constructor
    public CommandSender() {}

    // Parameterized constructor
    public CommandSender(String command, Object payload, String requestQueue) {
        this.command = command;
        this.payload = payload;
      //  this.publishQueue = publishQueue;
        this.requestQueue=requestQueue;

    }

    // Getters and setters
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getPayload() {
        return payload;
    }
//    public Object getPublishQueue() {
//        return publishQueue;
//    }
    public String getRequestingQueue() {
        return requestQueue;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
