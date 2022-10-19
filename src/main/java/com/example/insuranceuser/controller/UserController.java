package com.example.insuranceuser.controller;

import com.example.insuranceuser.dto.OtpDTO;
import com.example.insuranceuser.dto.ResponseUserDTO;
import com.example.insuranceuser.dto.UserDTO;
import com.example.insuranceuser.model.User;
import com.example.insuranceuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    //Create Api for Insert user details in the database
    @PostMapping("/register")
    public ResponseEntity<ResponseUserDTO> register(@Valid @RequestBody UserDTO userDTO) {
        User user=userService.register(userDTO);
        ResponseUserDTO responseUserDTO =new ResponseUserDTO("User details is submitted!",user);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }
    @PostMapping("/sendOTP/{email}")
    public ResponseEntity<ResponseUserDTO> sendOTP(@PathVariable String email) {
        String response = userService.sendOTP(email);
        ResponseUserDTO responseDTO = new ResponseUserDTO("OTP has sent while login", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @PostMapping("/loginWithOTP")
    public ResponseEntity<ResponseUserDTO> loginWithOTP(@RequestBody OtpDTO otpDTO) {
        String response = userService.loginWithOTP(otpDTO);
        ResponseUserDTO responseDTO = new ResponseUserDTO("Login Status", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseUserDTO> verifyUser(@PathVariable String token){
        User user = userService.verifyUser(token);
        ResponseUserDTO responseUserDTO = new ResponseUserDTO("User verified successfully!", user );
        return new ResponseEntity<>(responseUserDTO, HttpStatus.OK);
    }
    //Create Api for Getting all user details present in the database
    @GetMapping("/getAllUser")
    public ResponseEntity<ResponseUserDTO> getAll(){
        List<User> user=userService.getAll();
        ResponseUserDTO responseUserDTO =new ResponseUserDTO("All user details are found!",user);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.FOUND);
    }
    //Create Api for Getting particular user details which will be found by id
    @GetMapping("/getUserWithHealthCondition/{condition}")
    public ResponseEntity<ResponseUserDTO> getByUserId(@PathVariable String condition){
        List<User> user=userService.getUserWithHealthCondition(condition);
        ResponseUserDTO responseUserDTO =new ResponseUserDTO("Searched user details by id is found!",user);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.FOUND);
    }
    @GetMapping("/id/{id}")
    public User getDetailsById(@PathVariable long id){
        User user=userService.getDetailsById(id);
        return user;
    }
    @GetMapping("/loginCheck")
    public ResponseEntity<ResponseUserDTO> loginCheck(@RequestParam(value = "email",defaultValue = "")String email, @RequestParam(value = "password",defaultValue = "")String password){
        userService.loginCheck(email,password);
        ResponseUserDTO responseUserDTO =new ResponseUserDTO("Congratulations!! You have successfully logged in!","Welcome...!!");
        return new ResponseEntity<>(responseUserDTO,HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllUserBetweenRegisteredDate/{date1}/{date2}")
    public ResponseEntity<ResponseUserDTO> getAllUserBetweenRegisteredDate(@PathVariable String date1, @PathVariable String date2){
        List<User> userList=userService.getAllUserBetweenRegisteredDate(date1,date2);
        ResponseUserDTO responseUserDTO=new ResponseUserDTO("All the Users are here!",userList);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }
    @GetMapping("/getUserWithVehicleData/{vehicle}")
    public ResponseEntity<ResponseUserDTO> getUserWithVehicleData(@PathVariable String vehicle){
        List<User> userList=userService.getUserWithVehicleData(vehicle);
        ResponseUserDTO responseUserDTO=new ResponseUserDTO("Search user with vehicle data is found!",userList);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }

    //Create Api for Updating user details by email id
    @PutMapping("/updateUserById/{id}")
    public ResponseEntity<ResponseUserDTO> updateUserById(@Valid @RequestBody UserDTO userDTO, @PathVariable long id){
        User user=userService.updateUserById(userDTO,id);
        ResponseUserDTO responseUserDTO =new ResponseUserDTO("Searched user details has been updated successfully!",user);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseUserDTO> deleteById(@PathVariable long id){
        userService.deleteById(id);
        ResponseUserDTO responseUserDTO=new ResponseUserDTO("User details has been deleted!","Deleted user id is: "+id);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.GONE);
    }

}
