package com.example.userservice.client.service;

import com.example.userservice.client.dto.FileDto;
import com.example.userservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@FeignClient(name = "file-service", path = "/file")
public interface FileClient {

    @GetMapping(value = "/get/{id}")
    ResponseDto<FileDto> getFiles(@PathVariable(value = "id") Integer id);

    @GetMapping(value = "/get-files-by-user/{id}")
    ResponseDto<Set<FileDto>> getFilesByUsersId(@PathVariable("id") Integer id);

}