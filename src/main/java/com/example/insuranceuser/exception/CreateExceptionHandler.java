package com.example.insuranceuser.exception;

import com.example.insuranceuser.dto.ResponseCategoryDTO;
import com.example.insuranceuser.dto.ResponseCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CreateExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseCreateDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg=errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseCreateDTO responseCreateDTO =new ResponseCreateDTO("Exception while processing REST request", errMsg.toString());
        return new ResponseEntity<>(responseCreateDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CreateException.class)
    public ResponseEntity<ResponseCreateDTO> handlePayrollException(CreateException exception){
        ResponseCreateDTO responseCreateDTO =new ResponseCreateDTO("Exception while processing REST request",exception.getMessage());
        return new ResponseEntity<>(responseCreateDTO,HttpStatus.BAD_GATEWAY);
    }
}
