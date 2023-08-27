package com.example.userservice.mapper;

import com.example.userservice.client.service.FileClient;
import com.example.userservice.dto.UserDto;
import com.example.userservice.module.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected FileClient fileClient;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract User toEntity(UserDto dto);

    @Mapping(target = "files", ignore = true)
    public abstract UserDto toDto(User user);

//    public void data(User user){
//        fileClient.getFilesByUsersId(user.getId()).getData();
//    }

    @Mapping(target = "files", expression = ("java(fileClient.getFilesByUsersId(user.getId()).getData())"))
    public abstract UserDto toDtoWithFile(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract User updateUsersFromDto(UserDto dto, @MappingTarget User user);

}