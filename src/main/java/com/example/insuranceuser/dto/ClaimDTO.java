package com.example.insuranceuser.dto;
import com.example.insuranceuser.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClaimDTO{
    private String fullName;
    private long categoryId;
    private long insuranceName;
    private boolean statusClaimed;
    public boolean getStatusClaimed() {
        return statusClaimed;
    }
}
