package com.passbook.merchants.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//商户对象模型
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {
    //商户id
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;

    @Basic
    @Column(name = "id",unique = true, nullable = false)
    private String name;

    @Basic
    @Column(name = "id",nullable = false)
    private String logoUrl;

    @Basic
    @Column(name = "business_License_Url",nullable = false)
    private String businessLicenseUrl;

    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    @Basic
    @Column(name = "address",nullable = false)
    private String address;

    @Basic
    @Column(name = "is_audit",nullable = false)
    private boolean isAudit = false;
}
