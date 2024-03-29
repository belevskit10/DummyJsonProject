package com.project.projectDemo.domain.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankDto {

    private String cardExpire;

    private String cardNumber;

    private String cardType;

    private String currency;

    private String iban;

}
