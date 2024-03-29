package com.project.projectDemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlterUserDto {

    private String firstName;

    private String lastName;

    private String maidenName;

    private Integer age;

    private String gender;

    private String email;

    private String phone;

    private String username;

    private String password;

    private String birthDate;

    private String image;

    private String bloodGroup;

    private Integer height;

    private Double weight;

    private String eyeColor;

    private HairDto hair;

    private String domain;

    private String ip;

    private AddressDto address;

    private String macAddress;

    private String university;

    private BankDto bank;

    private CompanyDto company;

    private String ein;

    private String ssn;

    private String userAgent;


}
