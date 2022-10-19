package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.ClaimDTO;
import com.example.insuranceuser.model.Claim;

public interface IClaimService {
    Claim register(ClaimDTO claimDTO) throws Exception;
}
