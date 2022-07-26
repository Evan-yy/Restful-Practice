package com.example.demo2.Exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("CompanyNotFound");
    }
}
