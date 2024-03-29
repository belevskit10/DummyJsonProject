package com.project.projectDemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsDto {

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
}
