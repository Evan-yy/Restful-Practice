package com.example.demo2.Advice;

public class ErrorResponse {
    private final int code;
    private final String errorMessage;

    public ErrorResponse(int code, String errorMessage){
        this.code=code;
        this.errorMessage=errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
