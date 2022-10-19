package com.example.insuranceuser.repository;

import com.example.insuranceuser.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepo extends JpaRepository<Claim,Long> {
}
