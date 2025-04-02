package com.example.SCMS.response;

public class LoginResponse {
    private String token;
    private long expiresIn;

    // Getter for token
    public String getToken() {
        return token;
    }

    // Setter for token (returns this for method chaining)
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    // Getter for expiresIn
    public long getExpiresIn() {
        return expiresIn;
    }

    // Setter for expiresIn (returns this for method chaining)
    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}
