package com.example.userservice.controller;

import com.example.userservice.dto.ResponseDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseDto<UserDto> create(@ModelAttribute UserDto dto){
        return userService.create(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<UserDto> get(@PathVariable("id") Integer id){
        return userService.get(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<UserDto> update(@PathVariable("id") Integer id,@ModelAttribute UserDto dto){
        return  userService.update(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<UserDto> delete(@PathVariable("id") Integer id){
        return  userService.delete(id);
    }

}