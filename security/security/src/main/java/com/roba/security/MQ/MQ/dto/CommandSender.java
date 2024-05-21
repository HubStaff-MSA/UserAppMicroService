package com.roba.security.MQ.MQ.dto;

import java.io.Serializable;

public class CommandSender implements Serializable {

    private String command;
    private Object payload;

    // Default constructor
    public CommandSender() {}

    // Parameterized constructor
    public CommandSender(String command, Object payload) {
        this.command = command;
        this.payload = payload;
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
}
