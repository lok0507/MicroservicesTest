package com.rating.service.exceptions;

public class DuplicateInsertion extends RuntimeException {

    public DuplicateInsertion(String message) {
        super(message);
    }
}
