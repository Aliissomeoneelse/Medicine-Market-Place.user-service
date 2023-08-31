package com.example.userservice.controller;

import com.example.userservice.dto.ResponseDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseDto<UserDto> create(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseDto<UserDto> get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("/get-with-files/{id}")
    public ResponseDto<UserDto> getWithFiles(@PathVariable("id") Integer id) {
        return userService.getWithFiles(id);
    }

    @GetMapping("/get-with-credit/{id}")
    public ResponseDto<UserDto> getWithCredit(@PathVariable(value = "id") Integer id) {
        return userService.getWithCredit(id);
    }

    @GetMapping(value = "/get-user-by-orders/{id}")
    public ResponseDto<Set<UserDto>> getUserByOrdersId(@PathVariable("id") Integer id) {
        return userService.getUserByOrdersId(id);
    }

    @PutMapping("/update/{id}")
    public ResponseDto<UserDto> update(@PathVariable("id") Integer id, @RequestBody UserDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto<UserDto> delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }
    @GetMapping(value = "/get-user-by-rating/{id}")
    ResponseDto<Set<UserDto>> getUserByRatingId(@PathVariable("id") Integer id){
        return this.userService.getUserByRatingId(id);
    }

}