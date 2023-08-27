package com.example.userservice.dto;


import com.example.userservice.client.dto.FileDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
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

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
