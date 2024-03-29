package com.project.projectDemo.domain.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDto {

    private AddressDto address;

    private String department;

    private String name;

    private String title;

}
