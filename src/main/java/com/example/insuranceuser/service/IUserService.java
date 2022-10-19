package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.UserDTO;
import com.example.insuranceuser.model.ResponseObj;
import com.example.insuranceuser.model.User;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    User register(UserDTO userDTO);

    List<User> getAll();

    List<User> getUserWithHealthCondition(String condition);

    User getDetailsById(long id);

    User updateUserById(UserDTO userDTO, long id);

    void deleteById(long id);

    List<User> getAllUserBetweenRegisteredDate(String date1,String date2);

    List<User> getUserWithVehicleData(String vehicle);

    String loginCheck(String email, String password);

    ResponseObj userLogin(UserDTO userDto) throws MessagingException;

    User insert(UserDTO userDto);

    String verifyOtp(Integer otp, String username);

    User verifyUser(String token);
}
