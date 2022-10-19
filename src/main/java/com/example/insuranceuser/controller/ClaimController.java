package com.example.insuranceuser.controller;

import com.example.insuranceuser.dto.ClaimDTO;
import com.example.insuranceuser.dto.ResponseClaimDTO;
import com.example.insuranceuser.model.Claim;
import com.example.insuranceuser.service.IClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/claim")
public class ClaimController {
    @Autowired
    IClaimService claimService;
    //Create Api for Insert Claim details in the database
    @PostMapping("/insert")
    public ResponseEntity<ResponseClaimDTO> register ( @RequestBody ClaimDTO claimDTO) throws Exception{
        Claim claim=claimService.register(claimDTO);
        ResponseClaimDTO responseClaimDTO =new ResponseClaimDTO("Claim details is submitted!",claim);
        return new ResponseEntity<>(responseClaimDTO, HttpStatus.CREATED);
    }
    @PutMapping("/updateById/{id}")
    public ResponseEntity<ResponseClaimDTO> updateById(@PathVariable long id,@RequestBody ClaimDTO claimDTO){
        Claim claim=claimService.updateById(id,claimDTO);
        ResponseClaimDTO responseClaimDTO =new ResponseClaimDTO("Searched claim details has been updated successfully!",claim);
        return new ResponseEntity<>(responseClaimDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseClaimDTO> deleteById(@PathVariable long id){
        claimService.deleteById(id);
        ResponseClaimDTO responseClaimDTO=new ResponseClaimDTO("User details has been deleted!","Deleted claim id is: "+id);
        return new ResponseEntity<>(responseClaimDTO,HttpStatus.GONE);
    }
    @GetMapping("/getAllInsuranceByClaimed/{status}")
    public ResponseEntity<ResponseClaimDTO> getAllInsuranceByClaimed(@PathVariable boolean status){
        List<Claim> claimList = claimService.getAllInsuranceByClaimed(status);
        ResponseClaimDTO responseClaimDTO=new ResponseClaimDTO("All insurances are here which all are claimed!",claimList);
        return new ResponseEntity<>(responseClaimDTO,HttpStatus.OK);
    }
    @PutMapping("/changeClaimStatus/{id}")
    public ResponseEntity<ResponseClaimDTO> changeClaimStatus(@RequestBody ClaimDTO claimDTO,@PathVariable long id){
        Claim claim=claimService.changeClaimStatus(claimDTO,id);
        ResponseClaimDTO responseClaimDTO=new ResponseClaimDTO("Claimed status is changed!",claim);
        return new ResponseEntity<>(responseClaimDTO,HttpStatus.FOUND);
    }
    @GetMapping("/getAllClaimedInsurance")
    public ResponseEntity<ResponseClaimDTO> getAllClaimedInsurance(){
        List<Claim> claimList=claimService.getAllClaimedInsurance();
        ResponseClaimDTO responseClaimDTO=new ResponseClaimDTO("All claimed insurances are here!",claimList);
        return new ResponseEntity<>(responseClaimDTO,HttpStatus.OK);
    }
}
