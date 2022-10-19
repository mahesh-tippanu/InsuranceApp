package com.example.insuranceuser.model;

import com.example.insuranceuser.dto.ClaimDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "claim")
public class Claim {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long claimID;
    private String fullName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "claim_category_id")
    private Category categoryId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "claim_insurance_name")
    private Category insuranceName;
    private boolean statusClaimed;
    public Claim(String fullName, Category categoryId,Category insuranceName, boolean statusClaimed) {
        this.fullName = fullName;
        this.categoryId=categoryId;
        this.insuranceName = insuranceName;
        this.statusClaimed = statusClaimed;
    }

}
