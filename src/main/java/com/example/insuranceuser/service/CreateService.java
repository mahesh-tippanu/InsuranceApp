package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.CreateDTO;
import com.example.insuranceuser.exception.CategoryException;
import com.example.insuranceuser.exception.CreateException;
import com.example.insuranceuser.model.Category;
import com.example.insuranceuser.model.Create;
import com.example.insuranceuser.model.User;
import com.example.insuranceuser.repository.CategoryRepo;
import com.example.insuranceuser.repository.CreateRepo;
import com.example.insuranceuser.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToOne;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CreateService implements ICreateService{
    @Autowired
    CreateRepo createRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Create createInsurance(CreateDTO createDTO){
        Optional<User> user=userRepo.findById(createDTO.getUserId());
        Optional<Category> category=categoryRepo.findById(createDTO.getCategoryId());
        if(user.isPresent() && category.isPresent()) {
            Create create = new Create(category.get(),user.get(),user.get(),category.get(),createDTO.getStatus(),createDTO.getMonthPeriod(),createDTO.getRegisteredDate(),createDTO.getUpdatedDate(),createDTO.getClaimed(),createDTO.getUpdate());
            createRepo.save(create);
            return create;
        }else {
            throw new CreateException("Sorry! User Id or Category Id is not matched! please check and try again!");
        }
    }
    @Override
    public List<Create> getAllCreatedInsurance(){
        List<Create> createList=createRepo.findAll();
        return createList;
    }
    @Override
    public Create updateCreatedInsuranceByInsurance(CreateDTO createDTO, long id){
        Optional<User> user=userRepo.findById(createDTO.getUserId());
        Optional<Category> category=categoryRepo.findById(createDTO.getCategoryId());
        Create create=createRepo.findById(id).get();
        if (createRepo.findById(id).isPresent() && user.isPresent() && category.isPresent()){
            create.setCategoryId(category.get());
            create.setUserId(user.get());
            create.setFullName(user.get());
            create.setInsuranceName(category.get());
            create.setStatus(createDTO.getStatus());
            create.setMonthPeriod(createDTO.getMonthPeriod());
            create.setRegisteredDate(createDTO.getRegisteredDate());
            create.setUpdatedDate(createDTO.getUpdatedDate());
            create.setClaimed(createDTO.getClaimed());
            create.setUpdate(createDTO.getUpdate());
            createRepo.save(create);
            return create;
        }else {
            throw new CategoryException("Sorry! category id, user id or insurance id is incorrect! Please check and try again!");
        }
    }
    @Override
    public void deleteCreatedInsuranceById(long id){
        if(createRepo.findById(id).isPresent()){
            createRepo.deleteById(id);
        }else {
            throw new CreateException("Sorry! We can not find Insurance id: "+id);
        }
    }
    @Override
    public List<Create> getAllByStatus(String status){
        List<Create> createList=createRepo.findByStatus(status);
        return createList;
    }
    @Override
    public  List<Create> getAllByMonthPeriod(long monthPeriod){
        List<Create> createList=createRepo.findByMonthPeriod(monthPeriod);
        return createList;
    }

}
