package com.blog.demo.util;

public class ServiceException extends Exception  {
    private String module;
    public ServiceException() {
    }
    public ServiceException(String message,String module) {
        super(module + "|"+message);
    }
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
