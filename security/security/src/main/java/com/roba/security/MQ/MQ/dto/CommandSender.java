package com.roba.security.MQ.MQ.dto;

import java.io.Serializable;

public class CommandSender implements Serializable {

    private String command;
    private Object payload;

    private String requestingQueue;
    // private Object publishQueue;
    // Default constructor
    public CommandSender() {}

    // Parameterized constructor
    public CommandSender(String command, Object payload, String requestingQueue) {
        this.command = command;
        this.payload = payload;
      //  this.publishQueue = publishQueue;
        this.requestingQueue = requestingQueue;

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



    public void setPayload(Object payload) {
        this.payload = payload;
    }


    public String getRequestingQueue() {
        return requestingQueue;
    }

    public void setRequestingQueue(String requestingQueue) {
        this.requestingQueue = requestingQueue;
    }
}

