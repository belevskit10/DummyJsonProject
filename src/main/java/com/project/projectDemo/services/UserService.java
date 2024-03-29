package com.project.projectDemo.services;

import com.project.projectDemo.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WebClient dummyJsonWebClient;

    public List<UserDto> getAll() {
        return dummyJsonWebClient.get()
            .uri("users")
            .retrieve()
            .bodyToMono(UserDtoWrapper.class)
            .block()
            .getUsers();
    }

    public UserDto get(Integer id) {
        return dummyJsonWebClient.get()
            .uri(String.format("users/%d", id))
            .retrieve()
            .bodyToMono(UserDto.class)
            .block();
    }

    public SearchUserDto search(String str) {
        return dummyJsonWebClient.get()
            .uri(String.format("users/search?q=%s", str))
            .retrieve()
            .bodyToMono(SearchUserDto.class)
            .block();
    }

    public UserDto create() {
        return dummyJsonWebClient.post()
                .uri("users/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(buildFakeDto()), AlterUserDto.class)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }

    public UserDto update(Integer id) {
        return dummyJsonWebClient.put()
            .uri(String.format("users/%d", id))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(buildFakeDto()), AlterUserDto.class)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }

    public UserDto delete(Integer id) {
        return dummyJsonWebClient.delete()
            .uri(String.format("users/%d", id))
            .retrieve()
            .bodyToMono(UserDto.class)
            .block();
    }
    private AlterUserDto buildFakeDto() {
        return AlterUserDto.builder()
                .firstName("Trajche")
                .lastName("Belevski")
                .maidenName("Smitham")
                .age(50)
                .gender("male")
                .email("atuny0@sohu.com")
                .phone("+63 791 675 8914")
                .username("atuny0")
                .password("9uQFF1Lh")
                .birthDate("2000-12-25")
                .image("https://robohash.org/Terry.png?set=set4")
                .bloodGroup("A-")
                .height(189)
                .weight(75.4)
                .eyeColor("Green")
                .hair(HairDto.builder().color("Black").type("Strands").build())
                .domain("slashdot.org")
                .ip("117.29.86.254")
                .address(AddressDto.builder()
                        .address("1745 T Street Southeast")
                        .city("Washington")
                        .coordinates(new CoordinatesDto(38.867033, -76.979235))
                        .postalCode("20020")
                        .state("DC")
                        .build())
                .macAddress("13:69:BA:56:A3:74")
                .university("Capitol University")
                .bank(BankDto.builder()
                        .cardExpire("06/22")
                        .cardNumber("50380955204220685")
                        .cardType("maestro")
                        .currency("Peso")
                        .iban("NO17 0695 2754 967")
                        .build())
                .company(CompanyDto.builder()
                        .address(AddressDto.builder()
                                .address("629 Debbie Drive")
                                .city("Nashville")
                                .coordinates(new CoordinatesDto(36.208114, -86.58621199999999))
                                .postalCode("37076")
                                .state("TN")
                                .build())
                        .department("Marketing")
                        .name("Blanda-O'Keefe")
                        .title("Help Desk Operator")
                        .build())
                .ein("20-9487066")
                .ssn("661-64-2976")
                .userAgent("Mozilla/5.0 ...")
                .build();
    }
}
