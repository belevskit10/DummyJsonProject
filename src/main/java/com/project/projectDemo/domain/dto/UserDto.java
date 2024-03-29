package com.project.projectDemo.domain.dto;

import com.google.gson.GsonBuilder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private int id;

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

    @Override
    public String toString() {
        return new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this);
    }
}
