package com.example.insuranceuser.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseObj {
    private Object data;
    private String message;

    public ResponseObj(String user_details_is_submitted, User user) {
        this.data = user;
        this.message = user_details_is_submitted;
    }
}
