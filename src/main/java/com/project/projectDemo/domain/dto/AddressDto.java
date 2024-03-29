package com.project.projectDemo.domain.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private String address;

    private String city;

    private CoordinatesDto coordinates;

    private String postalCode;

    private String state;

}
