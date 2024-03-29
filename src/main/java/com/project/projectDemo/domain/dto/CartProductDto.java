package com.project.projectDemo.domain.dto;

import com.google.gson.GsonBuilder;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDto {

    private Integer id;

    private String title;

    private BigDecimal price;

    private Integer quantity;

    private Integer total;

    private Double discountPercentage;

    private Double discountedPrice;

    private String thumbnail;


    @Override
    public String toString() {
        return new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this);
    }
}
