package com.project.projectDemo.domain.dto;

import com.google.gson.GsonBuilder;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

    private Integer id;

    private List<CartProductDto> products;

    private Integer total;

    private Integer discountedTotal;

    private Integer userId;

    private Integer totalProducts;

    private Integer totalQuantity;

    @Override
    public String toString() {
        return new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this);
    }
}
