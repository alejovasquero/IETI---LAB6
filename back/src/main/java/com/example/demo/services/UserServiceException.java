package com.example.demo.services;

public class UserServiceException extends Exception {

    public static String USER_NOT_DEFINED = "The user has not been properly defined";
    public static String USER_NOT_FOUND = "The user has not been found";

    public UserServiceException(String message){
        super(message);
    }
}
