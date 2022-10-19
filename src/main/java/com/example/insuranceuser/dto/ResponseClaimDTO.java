package com.example.insuranceuser.dto;
import com.example.insuranceuser.model.Claim;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ResponseClaimDTO {
    private String message;
    private Object object;
    public ResponseClaimDTO(String message, Claim claim) {
        this.message=message;
        this.object=claim;
    }
}
