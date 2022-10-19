package com.example.insuranceuser.model;
import com.example.insuranceuser.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
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

    boolean verified = false;

    public User(UserDTO userDTO) {
        this.fullName=userDTO.getFullName();
        this.username=userDTO.getUsername();
        this.permanentAddress=userDTO.getPermanentAddress();
        this.temporaryAddress=userDTO.getTemporaryAddress();
        this.mobileNumber=userDTO.getMobileNumber();
        this.email=userDTO.getEmail();
        this.password=userDTO.getPassword();
        this.age=userDTO.getAge();
        this.userType=userDTO.getUserType();
        this.occupation=userDTO.getOccupation();
        this.familyBackground=userDTO.getFamilyBackground();
        this.kyc=userDTO.getKyc();
        this.healthCondition=userDTO.getHealthCondition();
        this.vehicleData=userDTO.getVehicleData();
        this.registeredDate=userDTO.getRegisteredDate();
        this.updatedDate=userDTO.getUpdatedDate();
    }
}
