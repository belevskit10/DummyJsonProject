package com.project.projectDemo.services;

import com.project.projectDemo.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient dummyJsonWebClient;

    public List<ProductDto> getAll() {
        return dummyJsonWebClient.get()
            .uri("products")
            .retrieve()
            .bodyToMono(ProductDtoWrapper.class)
            .block()
            .getProducts();
    }

    public ProductDto get(Integer id) {
        return dummyJsonWebClient.get()
            .uri(String.format("products/%d", id))
            .retrieve()
            .bodyToMono(ProductDto.class)
            .block();
    }

    public ProductDto create() {
        return dummyJsonWebClient.post()
            .uri("products/add")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(buildFakeDto()), AlterProductDto.class)
            .retrieve()
            .bodyToMono(ProductDto.class)
            .block();
    }

    public ProductDto update(Integer id) {
        return dummyJsonWebClient.put()
            .uri(String.format("products/%d", id))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .body(Mono.just(buildFakeDto()), AlterProductDto.class)
            .retrieve()
            .bodyToMono(ProductDto.class)
            .block();
    }

    public ProductDto delete(Integer id) {
        return dummyJsonWebClient.delete()
            .uri(String.format("products/%d", id))
            .retrieve()
            .bodyToMono(ProductDto.class)
            .block();
    }

    public SearchProductDto search(String str) {
        return dummyJsonWebClient.get()
                .uri(String.format("products/search?q=%s", str))
                .retrieve()
                .bodyToMono(SearchProductDto.class)
                .block();
    }

    private AlterProductDto buildFakeDto() {
        return AlterProductDto.builder()
            .title("Samsung 5")
            .price(BigDecimal.ZERO)
            .description("phone")
            .discountPercentage(14.4)
            .rating(9.2)
            .stock(2)
            .brand("Samsung")
            .category("phone")
            .thumbnail("....")
            .images(List.of("image1", "image2"))
            .build();
    }
}
