package com.project.projectDemo.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlterProductDto {

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
