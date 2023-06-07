package com.example.newproject.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String type, long id) {
        this(type, "id", String.valueOf(id));
    }
    public EntityNotFoundException(String type, String username) {
        super(String.format("%s with username %s not found.", type, username));
    }
    public EntityNotFoundException(String type, String attribute, String value) {
        super(String.format("%s with %s %s not found.", type, attribute, value));
    }


}
