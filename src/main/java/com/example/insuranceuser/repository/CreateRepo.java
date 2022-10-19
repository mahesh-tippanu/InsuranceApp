package com.example.insuranceuser.repository;

import com.example.insuranceuser.model.Create;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreateRepo extends JpaRepository<Create,Long> {
    @Query(value = "select * from insurance.insure where insure.status=:status",nativeQuery = true)
    List<Create> findByStatus(String status);
    @Query(value = "select * from insurance.insure where insure.month_period=:monthPeriod",nativeQuery = true)
    List<Create> findByMonthPeriod(long monthPeriod);
}
