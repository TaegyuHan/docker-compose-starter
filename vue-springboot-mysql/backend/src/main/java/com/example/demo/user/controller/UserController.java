package com.example.demo.user.controller;

import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.user.dto.AuthenticationDTO;
import com.example.demo.user.dto.LoginRequestDTO;
import com.example.demo.user.dto.LoginResponseDTO;
import com.example.demo.user.dto.SignUpRequestDTO;
import com.example.demo.user.service.UserService;
import com.example.demo.util.ResponseUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signUp(
            @Valid @RequestBody SignUpRequestDTO signUpRequest
    ) {
        // 이메일 중복 확인
        if (userService.checkExistingUser(signUpRequest.getEmail())) {
            return ResponseUtil.error("이미 존재하는 회원입니다.");
        }
        // 회원가입 로직을 수행합니다.
        userService.registerUser(signUpRequest);
        return ResponseUtil.success("회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequestDTO user
    ) {
        Optional<AuthenticationDTO> optAuth = userService.findByEmail(user.getEmail());
        if (optAuth.isEmpty()) {
            return ResponseUtil.error("존재하지 않는 회원입니다.");
        }
        AuthenticationDTO auth = optAuth.get();

        if (!passwordEncoder.matches(user.getPassword(), auth.getPassword())) {
            return ResponseUtil.error("잘못된 비밀번호입니다.");
        }

        // 여기부터 시작 토큰을 만들어야 함!!!!
        LoginResponseDTO responseDTO = LoginResponseDTO.builder()
                .message("로그인에 성공하였습니다.")
                .accessToken(jwtTokenProvider.createToken(auth.getEmail(), auth.getRole()))
                .build();

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/admin") // 어드민 확인
    public String admin() {
        return "admin hello";
    }

    @GetMapping("/user") // 회원 확인
    public String user() {
        return "user hello";
    }
}