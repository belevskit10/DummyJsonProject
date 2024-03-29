package com.project.projectDemo.domain.dto;

import com.google.gson.GsonBuilder;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Integer id;

    private String title;

    private String description;

    private BigDecimal price;

    private Double discountPercentage;

    private Double rating;

    private Integer stock;

    private String brand;

    private String category;

    private String thumbnail;

    private List<String> images;

    @Override
    public String toString() {
        return new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this);
    }
}
