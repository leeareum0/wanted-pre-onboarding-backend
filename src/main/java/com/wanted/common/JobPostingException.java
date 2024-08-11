package com.wanted.common;

public class JobPostingException extends RuntimeException {

    private String message;

    public JobPostingException(String message) {
        super(message);
        this.message = message;
    }
}
