package com.project.projectDemo.domain.dto;

import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductDto {

    private List<ProductDto> products;

    private Integer total;

    private Integer skip;

    private Integer limit;

    @Override
    public String toString() {
        return new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create()
            .toJson(this);
    }
}
