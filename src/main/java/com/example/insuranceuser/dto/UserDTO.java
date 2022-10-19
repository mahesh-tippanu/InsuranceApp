package com.example.insuranceuser.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserDTO {
    private String fullName;
    private String username;
    private String permanentAddress;
    private String temporaryAddress;
    private String mobileNumber;
    private String email;
    private String password;
    private int age;
    private String userType;
    private String occupation;
    private String familyBackground;
    private String kyc;
    private String healthCondition;
    private String vehicleData;
    private String registeredDate;
    private String updatedDate;
}

