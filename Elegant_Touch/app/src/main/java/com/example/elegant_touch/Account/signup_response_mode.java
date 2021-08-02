package com.example.elegant_touch.Account;

public class signup_response_mode {
    String message;
    
    public signup_response_mode(String message) {
        this.message = message;
    }

    public signup_response_mode() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
