package com.example.insuranceuser.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CategoryDTO {
    private String insuranceName;
    private String insuranceStatus;
    private String insuranceScheme;
    private String registeredDate;
    private String updatedDate;
    private long insuranceCode;
}
