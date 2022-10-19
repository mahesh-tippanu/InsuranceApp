package com.example.insuranceuser.model;

import com.example.insuranceuser.dto.CreateDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "insure")
public class Create {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long insuranceId;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Category categoryId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private User userId;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private User fullName;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Category insuranceName;
    private String status;
    private long monthPeriod;
    private String registeredDate;
    private String updatedDate;
    private boolean claimed;
    private boolean update;

    public Create(Category categoryId,User userId,User fullName,Category insuranceName,String status,long monthPeriod,String registeredDate,String updatedDate,boolean claimed,boolean update) {
        this.categoryId=categoryId;
        this.userId=userId;
        this.fullName=fullName;
        this.insuranceName=insuranceName;
        this.status=status;
        this.monthPeriod=monthPeriod;
        this.registeredDate=registeredDate;
        this.updatedDate=updatedDate;
        this.claimed=claimed;
        this.update=update;
    }
}
