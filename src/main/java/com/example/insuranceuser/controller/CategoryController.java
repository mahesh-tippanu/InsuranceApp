package com.example.insuranceuser.controller;

import com.example.insuranceuser.dto.CategoryDTO;
import com.example.insuranceuser.dto.ResponseCategoryDTO;
import com.example.insuranceuser.model.Category;
import com.example.insuranceuser.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @PostMapping("/addInsuranceCategory")
    public ResponseEntity<ResponseCategoryDTO> addInsurance(@RequestBody CategoryDTO categoryDTO){
        Category category=categoryService.addInsurance(categoryDTO);
        ResponseCategoryDTO responseCategoryDTO=new ResponseCategoryDTO("Insurance details is submitted!",category);
        return new ResponseEntity<>(responseCategoryDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getAllInsuranceCategory")
    public ResponseEntity<ResponseCategoryDTO> getAllInsuranceCategory(){
        List<Category> categories=categoryService.getAllInsuranceCategory();{
            ResponseCategoryDTO responseDTO = new ResponseCategoryDTO("Searched Insurance Categories are here!", categories);
            return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseCategoryDTO> getById(@PathVariable long id){
        Category category=categoryService.getById(id);
        ResponseCategoryDTO responseCategoryDTO=new ResponseCategoryDTO("Searched insurance category details are here!",category);
        return new ResponseEntity<>(responseCategoryDTO,HttpStatus.OK);
    }
    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<ResponseCategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable long id){
        Category category=categoryService.updateCategory(categoryDTO,id);
        ResponseCategoryDTO responseDTO=new ResponseCategoryDTO("Searched insurance category details has been updated successfully!",category);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<ResponseCategoryDTO> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        ResponseCategoryDTO responseDTO=new ResponseCategoryDTO("Insurance category details has been deleted!","Deleted category id is: "+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.GONE);
    }
}
