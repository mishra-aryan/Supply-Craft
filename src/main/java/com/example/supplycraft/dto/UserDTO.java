package com.example.supplycraft.dto;

import javax.validation.constraints.NotBlank;

import com.example.supplycraft.models.UserRole;

public class UserDTO {
    
	@NotBlank(message = "Username is required")
    private String username;
	
	@NotBlank(message = "Password is required")
    private String password;
	
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private String phoneNumber;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstName, String lastName, String email, UserRole role, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
