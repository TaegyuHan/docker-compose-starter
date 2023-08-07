package com.example.demo.user.mapper;

import com.example.demo.user.dto.AuthenticationDTO;
import com.example.demo.user.dto.SignUpRequestDTO;
import com.example.demo.user.entity.Role;
import com.example.demo.user.entity.User;


public class UserMapper {
    public static User toEntity(SignUpRequestDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(Role.USER);
        return user;
    }

    public static AuthenticationDTO toAuthenticationDTO(User entity) {
        AuthenticationDTO dto = new AuthenticationDTO();
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        return dto;
    }
}