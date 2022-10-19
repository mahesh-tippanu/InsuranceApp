package com.example.insuranceuser.dto;
import com.example.insuranceuser.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class ResponseCategoryDTO {
    private String message;
    private Object object;
    public ResponseCategoryDTO(String exception_while_processing_rest_request, String message) {
        this.message=exception_while_processing_rest_request;
        this.object=message;
    }
    public ResponseCategoryDTO(String message, Category category) {
        this.message=message;
        this.object=category;
    }
    public ResponseCategoryDTO(String message, List<Category> categories) {
        this.message=message;
        this.object=categories;
    }
}
