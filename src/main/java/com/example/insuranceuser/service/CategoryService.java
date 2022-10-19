package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.CategoryDTO;
import com.example.insuranceuser.exception.CategoryException;
import com.example.insuranceuser.model.Category;
import com.example.insuranceuser.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Category addInsurance(CategoryDTO categoryDTO){
        Category category=new Category(categoryDTO);
        categoryRepo.save(category);
        return category;
    }
    @Override
    public List<Category> getAllInsuranceCategory(){
        List<Category> categories=categoryRepo.findAll();
        return categories;
    }
    @Override
    public Category updateCategory(CategoryDTO categoryDTO,long id){
        Category category=categoryRepo.findById(id).get();
        if(categoryRepo.findById(id).isPresent()){
            category.setInsuranceName(categoryDTO.getInsuranceName());
            category.setInsuranceStatus(categoryDTO.getInsuranceStatus());
            category.setInsuranceScheme(categoryDTO.getInsuranceScheme());
            category.setRegisteredDate(categoryDTO.getRegisteredDate());
            category.setUpdatedDate(categoryDTO.getUpdatedDate());
            category.setInsuranceCode(categoryDTO.getInsuranceCode());
            categoryRepo.save(category);
            return category;
        }else {
            throw new CategoryException("Sorry! We can not find category id: "+id);
        }
    }
    @Override
    public void deleteCategory(long id) {
        if (categoryRepo.findById(id).isPresent()) {
            categoryRepo.deleteById(id);
        } else {
            throw new CategoryException("Sorry! We can not find category id: " + id);
        }
    }
}
