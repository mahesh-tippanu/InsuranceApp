package com.example.insuranceuser.exception;

import com.example.insuranceuser.dto.ResponseCategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class CategoryExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseCategoryDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg=errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseCategoryDTO responseCategoryDTO =new ResponseCategoryDTO("Exception while processing REST request", errMsg.toString());
        return new ResponseEntity<>(responseCategoryDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CategoryException.class)
    public ResponseEntity<ResponseCategoryDTO> handlePayrollException(CategoryException exception){
        ResponseCategoryDTO responseCategoryDTO =new ResponseCategoryDTO("Exception while processing REST request",exception.getMessage());
        return new ResponseEntity<>(responseCategoryDTO,HttpStatus.BAD_GATEWAY);
    }
}
