package com.example.insuranceuser.dto;
import com.example.insuranceuser.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class ResponseUserDTO {
    private String message;
    private Object object;
    public ResponseUserDTO(String exception_while_processing_rest_request, String message) {
        this.message=exception_while_processing_rest_request;
        this.object=message;
    }
    public ResponseUserDTO(String message, User user) {
        this.message=message;
        this.object=user;
    }
    public ResponseUserDTO(String message, List<User> user) {
        this.message=message;
        this.object=user;
    }
}
