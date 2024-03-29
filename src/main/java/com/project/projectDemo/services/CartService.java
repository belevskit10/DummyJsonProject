package com.project.projectDemo.services;

import com.project.projectDemo.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CartService {

    private final WebClient dummyJsonWebClient;

    public List<CartDto> getAll() {
        return dummyJsonWebClient.get()
            .uri("carts")
            .retrieve()
            .bodyToMono(CartDtoWrapper.class)
            .block()
            .getCarts();
    }

    public CartDto get(Integer id) {
        return dummyJsonWebClient.get()
            .uri(String.format("carts/%d", id))
            .retrieve()
            .bodyToMono(CartDto.class)
            .block();
    }

    public CartDto create() {
        return dummyJsonWebClient.post()
                .uri("carts/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(buildFakeDto()), CartDto.class)
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public CartDto update(Integer id) {
        return dummyJsonWebClient.put()
                .uri(String.format("carts/%d", id))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(buildFakeUpdateDto()), UpdateCartDto.class)
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public CartDto delete(Integer id) {
        return dummyJsonWebClient.delete()
            .uri(String.format("carts/%d", id))
            .retrieve()
            .bodyToMono(CartDto.class)
            .block();
    }

    private CartDto buildFakeDto() {
        return buildFakeDto(new Random().nextInt());
    }

    private CartDto buildFakeDto(Integer id) {
        return CartDto.builder()
                .id(id)
                .total(20)
                .products(Collections.singletonList(
                        CartProductDto.builder()
                                .id(59)
                                .title("Spring and summershoes")
                                .price(BigDecimal.valueOf(20))
                                .discountPercentage(8.71)
                                .quantity(3)
                                .thumbnail("https://cdn.dummyjson.com/product-images/59/thumbnail.jpg")
                                .build()
                ))
                .discountedTotal(1941)
                .userId(97)
                .totalProducts(5)
                .totalQuantity(10)
                .build();
    }


    private UpdateCartDto buildFakeUpdateDto() {
        return UpdateCartDto.builder()
            .merge(true)
            .products(
                Collections.singletonList(
                    UpdateCartProductDto.builder()
                        .id(1)
                        .quantity(3)
                        .build()
                )
            )
            .build();
    }
}
