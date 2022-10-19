package com.example.insuranceuser.controller;

import com.example.insuranceuser.dto.CreateDTO;
import com.example.insuranceuser.dto.ResponseCreateDTO;
import com.example.insuranceuser.model.Create;
import com.example.insuranceuser.service.ICreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/create")
public class InsuranceCreateController {
    @Autowired
    ICreateService createService;
    @PostMapping("/createInsurance")
    public ResponseEntity<ResponseCreateDTO> createInsurance(@RequestBody CreateDTO createDTO){
        Create create =createService.createInsurance(createDTO);
        ResponseCreateDTO responseCreateDTO=new ResponseCreateDTO("Insurance details is submitted!",create);
        return new ResponseEntity<>(responseCreateDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getAllCreatedInsurance")
    public ResponseEntity<ResponseCreateDTO> getAllCreatedInsurance(){
        List<Create> createList=createService.getAllCreatedInsurance();{
            ResponseCreateDTO responseDTO = new ResponseCreateDTO("Searched Insurance Categories are here!", createList);
            return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
        }
    }
    @GetMapping("/getAllByStatus/{status}")
    public ResponseEntity<ResponseCreateDTO> getAllByStatus(@PathVariable String status){
        List<Create> createList=createService.getAllByStatus(status);
        ResponseCreateDTO responseCreateDTO=new ResponseCreateDTO("Searched details by status are found!",createList);
        return new ResponseEntity<>(responseCreateDTO,HttpStatus.FOUND);
    }
    @GetMapping("/getAllByMonthPeriod/{monthPeriod}")
    public ResponseEntity<ResponseCreateDTO> getAllByMonthPeriod(@PathVariable long monthPeriod){
        List<Create> createList=createService.getAllByMonthPeriod(monthPeriod);
        ResponseCreateDTO responseCreateDTO=new ResponseCreateDTO("Searched details by month period are found!",createList);
        return new ResponseEntity<>(responseCreateDTO,HttpStatus.FOUND);
    }
    @PutMapping("/updateCreatedInsuranceById/{id}")
    public ResponseEntity<ResponseCreateDTO> updateCreatedInsuranceById(@RequestBody CreateDTO createDTO,@PathVariable long id){
        Create create=createService.updateCreatedInsuranceByInsurance(createDTO,id);
        ResponseCreateDTO responseDTO=new ResponseCreateDTO("Searched insurance category details has been updated successfully!",create);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseCreateDTO> deleteCreatedInsuranceById(@PathVariable long id){
        createService.deleteCreatedInsuranceById(id);
        ResponseCreateDTO responseDTO=new ResponseCreateDTO("Insurance category details has been deleted!","Deleted created Insurance id is: "+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.GONE);
    }
}
