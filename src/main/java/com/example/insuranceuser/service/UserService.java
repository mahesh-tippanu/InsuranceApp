package com.example.insuranceuser.service;
import com.example.insuranceuser.dto.UserDTO;
import com.example.insuranceuser.exception.UserException;
import com.example.insuranceuser.model.ResponseObj;
import com.example.insuranceuser.model.User;
import com.example.insuranceuser.repository.UserRepo;
import com.example.insuranceuser.util.EmailSenderService;
import com.example.insuranceuser.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepo userRepo;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    EmailSenderService emailSenderService;
    @Autowired
    OtpController otpController;
    @Override
    public User register(UserDTO userDTO){
        User user=new User(userDTO);
        userRepo.save(user);
        String token=tokenUtil.createToken(user.getUserId());
        emailSenderService.sendOtpMessage(user.getEmail(),"Registered in Insurance User!", "http://localhost:8100/user/verify/"+token);
      //  emailSenderService.sendOtpMessage(user.getEmail(),"Registered in Insurance User", "Hii...."+user.getFullName()+"\n You have been successfully registered!\n\n Your registered details are:\n\n User Id:  "+user.getUserId()+"\n First Name:  "+user.getFullName()+"\n Email:  "+user.getEmail()+"\n Permanent Address:  "+user.getPermanentAddress()+"\n Temporary Address:  "+user.getTemporaryAddress()+"\n Mobile number:  "+user.getMobileNumber()+"\n Age:  "+user.getAge()+"\n Occupation:  "+user.getOccupation()+"\n Family Background:  "+user.getFamilyBackground()+"\n KYC:  "+user.getKyc()+"\n Health Condition:  "+user.getHealthCondition()+"\n Vehicle data:  "+user.getVehicleData()+"\n Registered date:  "+user.getRegisteredDate()+"\n Updated Date:  "+user.getUpdatedDate()+"\n Token:  "+token);
        return user;
    }
    @Override
    public List<User> getAll(){
        List<User> list=userRepo.findAll();
        return list;
    }
    @Override
    public  List<User> getUserWithHealthCondition(String condition){
        List<User> userList=userRepo.findByHealthCondition(condition);
        return userList;
    }
    @Override
    public User getDetailsById(long id){
        User user=userRepo.findById(id).get();
        if (userRepo.findById(id).isPresent()){
            return user;
        }else {
            throw new UserException("Searched user id is not present! please check user id: "+id);
        }
    }
    @Override
    public String loginCheck(String email, String password){
        User user=userRepo.findByEmail(email);
        if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
            emailSenderService.sendOtpMessage(user.getEmail(),"Logged in Successfully!", "Hii...."+user.getFullName()+"\n\n You have successfully logged in into Book Store App!");
            return "Congratulations!! You have logged in successfully!";

        }else {
            throw new UserException("Sorry! Email or Password is incorrect!");
        }
    }
    @Override
    public User updateUserById(UserDTO userDTO, long id) {
        User user = userRepo.findById(id).get();
        if (userRepo.findById(id).isPresent()) {
            user.setFullName(userDTO.getFullName());
            user.setPermanentAddress(userDTO.getPermanentAddress());
            user.setTemporaryAddress(userDTO.getTemporaryAddress());
            user.setMobileNumber(userDTO.getMobileNumber());
            user.setAge(userDTO.getAge());
            user.setUserType(userDTO.getUserType());
            user.setOccupation(userDTO.getOccupation());
            user.setFamilyBackground(userDTO.getFamilyBackground());
            user.setKyc(userDTO.getKyc());
            user.setHealthCondition(userDTO.getHealthCondition());
            user.setVehicleData(userDTO.getVehicleData());
            user.setRegisteredDate(userDTO.getRegisteredDate());
            user.setUpdatedDate(userDTO.getUpdatedDate());
            userRepo.save(user);
            return user;
        } else {
            throw new UserException("Sorry! We can not find the user id: " + id);
        }
    }
    @Override
    public void deleteById(long id){
        if(userRepo.findById(id).isPresent()){
            userRepo.deleteById(id);
        }else {
            throw new UserException("Sorry! We can not find the user id: "+id);
        }
    }
    @Override
    public List<User> getAllUserBetweenRegisteredDate(String date1,String date2){
        List<User> userList=userRepo.findAllUsersBetweenRegisteredDate(date1,date2);
        return userList;
    }
    @Override
    public List<User> getUserWithVehicleData(String vehicle){
        List<User> userList=userRepo.findUserWithVehicleData(vehicle);
        return userList;
    }
    @Override
    public User verifyUser(String token){
        long id = tokenUtil.decodeToken(token);
        User user = userRepo.findById(id).get();
        if (userRepo.findById(id).isPresent()) {
            user.setVerified(true);
            userRepo.save(user);
            return user;
        }else {
            throw new UserException("Sorry! We can not fin user id: "+id);
        }
    }

    public ResponseObj userLogin(UserDTO userDTO) throws MessagingException {
        User user = userRepo.findByUsername(userDTO.getUsername());
        if(user != null){
            if(user.getPassword().equals(userDTO.getPassword())){
                return new ResponseObj(otpController.generateOTP(userDTO.getUsername()),"Otp sent successfully");
            }else{
                return new ResponseObj(null,"Invalid password");
            }
        }else{
            return new ResponseObj(null,"User doesn't exist");
        }
    }
    public String verifyOtp(Integer otp, String username){
        return otpController.validateOtp(otp,username);
    }
    public  User insert(UserDTO userDTO){
        User user = new User(userDTO);
        userRepo.save(user);
        return user;
    }

}
