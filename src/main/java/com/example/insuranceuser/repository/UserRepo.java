package com.example.insuranceuser.repository;

import com.example.insuranceuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    @Query(value = "select * from insurance.user where user.health_condition=:condition",nativeQuery = true)
    List<User> findByHealthCondition(String condition);
    @Query(value = "select * from insurance.user where user.registered_date between :date1 and :date2",nativeQuery = true)
    List<User> findAllUsersBetweenRegisteredDate(String date1,String date2);
    @Query(value = "select * from insurance.user where user.vehicle_data=:vehicle",nativeQuery = true)
    List<User> findUserWithVehicleData(String vehicle);
    @Query(value = "select * from insurance.user where user.email=:email",nativeQuery = true)
    User findByEmail(String email);

}
