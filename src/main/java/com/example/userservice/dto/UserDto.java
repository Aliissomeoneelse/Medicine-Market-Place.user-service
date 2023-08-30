package com.example.userservice.dto;


import com.example.userservice.client.dto.CreditDto;
import com.example.userservice.client.dto.FileDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    //ordersId
    private Integer ordersId;
    @NotBlank(message = "First name cannot be null or empty")
    private String firstname;
    private String lastname;
    private Integer age;
    private String phone;
    //we should do access to type of users(admin/ordinary users)
    private String userType;
    private String address;
    private String gender;
    private String username;
    private String email;

    private Set<FileDto> files;
    private Set<CreditDto> credit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
