package com.yordan.pizzeria.service.exception;

public class EmailApiException extends RuntimeException{
    public EmailApiException(){
        super("ERROR: email not sent...");
    }
}
