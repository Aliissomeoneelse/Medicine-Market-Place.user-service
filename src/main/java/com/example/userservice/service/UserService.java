package com.example.userservice.service;

import com.example.userservice.dto.ResponseDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.mapper.UserMapper;
import com.example.userservice.module.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public ResponseDto<UserDto> create(UserDto dto) {
        try {
            User user = userMapper.toEntity(dto);
            user.setCreatedAt(LocalDateTime.now());
            this.userRepository.save(user);
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("User successful created!")
                    .data(userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .message("User while saving error :: " + e.getMessage())
                    .code(-3)
                    .build();
        }
    }

    public ResponseDto<UserDto> get(Integer id) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("OK")
                .data(userMapper.toDto(optional.get()))
                .build();
    }

    public ResponseDto<UserDto> getWithFiles(Integer id) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .success(true)
                .message("OK")
                .data(userMapper.toDtoWithFile(optional.get()))
                .build();
    }

    public ResponseDto<Set<UserDto>> getUserByOrdersId(Integer id) {
        Set<User> users = userRepository.findAllByOrdersIdAndDeletedAtIsNull(id);
        if(users.isEmpty()){
            return ResponseDto.<Set<UserDto>>builder()
                    .message("Users are not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        return ResponseDto.<Set<UserDto>>builder()
                .success(true)
                .message("OK")
                //to transfer Set<User> to Set<UserDto>
                .data(users.stream().map(userMapper::toDto).collect(Collectors.toSet()))
                .build();
    }

    public ResponseDto<UserDto> update(Integer id, UserDto dto) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            User user =optional.get();
            userMapper.updateUsersFromDto(dto, optional.get());
            user.setId(optional.get().getId());
            user.setUpdatedAt(LocalDateTime.now());
            userRepository.save(user);
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("User successful updated!")
                    .data(userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .message("User while updating error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

    public ResponseDto<UserDto> delete(Integer id) {
        Optional<User> optional = userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .message("User is not found!")
                    .code(-3)
                    .data(null)
                    .build();
        }
        try {
            User user = optional.get();
            user.setDeletedAt(LocalDateTime.now());
            userRepository.save(user);
            return ResponseDto.<UserDto>builder()
                    .success(true)
                    .message("User successful deleted!")
                    .data(userMapper.toDto(user))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .message("User while deleting error :: " + e.getMessage())
                    .code(-1)
                    .build();
        }
    }

}