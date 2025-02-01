package com.blog.demo.util;

public class GenericResponse<T> extends ResponseServices{
    private T data;

    public GenericResponse() {
    }

    public GenericResponse(T t) {
        this.data = t;
    }

    public T getData() {
        return data;
    }

    public void setData(T t) {
        this.data = t;
    }
}
