package com.example.insuranceuser.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreateDTO {
    private long categoryId;
    private long userId;
    private String fullName;
    private String insuranceName;
    private String status;
    private long monthPeriod;
    private String registeredDate;
    private String updatedDate;
    private boolean claimed;
    private boolean update;
    public boolean getClaimed() {
        return claimed;
    }
    public boolean getUpdate(){return update;}
}
