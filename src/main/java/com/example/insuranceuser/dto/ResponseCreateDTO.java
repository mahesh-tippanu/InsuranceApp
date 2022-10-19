package com.example.insuranceuser.dto;
import com.example.insuranceuser.model.Create;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class ResponseCreateDTO {
    private String message;
    private Object object;
    public ResponseCreateDTO(String exception_while_processing_rest_request, String message) {
        this.message=exception_while_processing_rest_request;
        this.object=message;
    }
    public ResponseCreateDTO(String message, Create create) {
        this.message=message;
        this.object=create;
    }
    public ResponseCreateDTO(String message, List<Create> createList) {
        this.message=message;
        this.object=createList;
    }
}
