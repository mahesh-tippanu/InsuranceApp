package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.CategoryDTO;
import com.example.insuranceuser.dto.ClaimDTO;
import com.example.insuranceuser.exception.ClaimException;
import com.example.insuranceuser.exception.CreateException;
import com.example.insuranceuser.model.Category;
import com.example.insuranceuser.model.Claim;
import com.example.insuranceuser.repository.CategoryRepo;
import com.example.insuranceuser.repository.ClaimRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClaimService implements IClaimService{
    @Autowired
    ClaimRepo claimRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Claim register(ClaimDTO claimDTO) throws Exception {
        Optional<Category> category = categoryRepo.findById(claimDTO.getCategoryId());
        if (category.isPresent()) {
            Claim claim = new Claim(claimDTO.getFullName(), category.get(),category.get(), claimDTO.getStatusClaimed());
            claimRepo.save(claim);
            return claim;
        } else {
            throw new ClaimException("Sorry! category id is not present! Please check and try again!");
        }

    }
}
