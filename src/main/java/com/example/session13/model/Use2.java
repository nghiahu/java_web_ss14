package com.example.session13.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Use2 {
    private int id;

    @NotBlank(message = "{username.required}")
    private String username;

    @NotBlank(message = "{password.required}")
    private String password;

    @NotBlank(message = "{confirmPassword.required}")
    private String confirmPassword;

    @NotBlank(message = "{email.required}")
    @Email(message = "{email.invalid}")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
