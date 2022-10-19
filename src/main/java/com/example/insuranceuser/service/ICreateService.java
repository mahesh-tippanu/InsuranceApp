package com.example.insuranceuser.service;

import com.example.insuranceuser.dto.CreateDTO;
import com.example.insuranceuser.model.Create;

import java.util.List;

public interface ICreateService {
    Create createInsurance(CreateDTO createDTO);

    List<Create> getAllCreatedInsurance();

    Create updateCreatedInsuranceByInsurance(CreateDTO createDTO, long id);

    void deleteCreatedInsuranceById(long id);

    List<Create> getAllByStatus(String status);

    List<Create> getAllByMonthPeriod(long monthPeriod);
}
