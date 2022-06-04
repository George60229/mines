package com.example.pashnev.util;

import java.util.Date;

public class ErrorDetails {
    Date callTime;
    String message;
    String details;

    public ErrorDetails(Date callTime, String message, String details) {
        super();
        this.callTime = callTime;
        this.message = message;
        this.details = details;
    }

    public Date getCallTime() {
        return callTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
