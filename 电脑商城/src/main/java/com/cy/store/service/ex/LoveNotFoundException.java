package com.cy.store.service.ex;

public class LoveNotFoundException extends ServiceException{
    public LoveNotFoundException() {
        super();
    }

    public LoveNotFoundException(String message) {
        super(message);
    }

    public LoveNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoveNotFoundException(Throwable cause) {
        super(cause);
    }

    protected LoveNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
