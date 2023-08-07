package com.example.demo.user.dto;

import com.example.demo.user.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticationDTO {
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private Role role;
}
