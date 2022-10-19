package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.CategoryDTO;
import com.example.insuranceuser.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addInsurance(CategoryDTO categoryDTO);

    Category updateCategory(CategoryDTO categoryDTO,long id);

    void deleteCategory(long id);

    List<Category> getAllInsuranceCategory();
}
