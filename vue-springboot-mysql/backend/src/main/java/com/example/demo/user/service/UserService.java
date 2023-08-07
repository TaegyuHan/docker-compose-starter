package com.example.demo.user.service;

import com.example.demo.user.dto.AuthenticationDTO;
import com.example.demo.user.dto.SignUpRequestDTO;
import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public boolean checkExistingUser(String email) {
        return userRepository.existsByEmail(email);
    }

    public void registerUser(SignUpRequestDTO signUpRequest) {
        signUpRequest.setPassword(passwordEncoder.encode(signUpRequest.getPassword())); // 비밀번호 암호화
        User user = UserMapper.toEntity(signUpRequest);
        userRepository.save(user);
    }

    public Optional<AuthenticationDTO> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(UserMapper::toAuthenticationDTO);
    }
}