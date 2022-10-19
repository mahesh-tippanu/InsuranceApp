package com.example.insuranceuser.model;

import com.example.insuranceuser.dto.CategoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String insuranceName;
    private String insuranceStatus;
    private String insuranceScheme;
    private String registeredDate;
    private String updatedDate;
    private long insuranceCode;

    public Category(CategoryDTO categoryDTO) {
        this.insuranceName = categoryDTO.getInsuranceName();
        this.insuranceStatus = categoryDTO.getInsuranceStatus();
        this.insuranceScheme = categoryDTO.getInsuranceScheme();
        this.registeredDate = categoryDTO.getRegisteredDate();
        this.updatedDate = categoryDTO.getUpdatedDate();
        this.insuranceCode = categoryDTO.getInsuranceCode();
    }
}
