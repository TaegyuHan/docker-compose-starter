package com.han.app.user.service;

import com.han.app.user.dto.UserDTO;
import com.han.app.user.entity.User;
import com.han.app.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 생성 로직
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user = userRepository.save(user);

        return convertToDTO(user);
    }

    // 사용자 조회 로직
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return convertToDTO(user);
        } else {
            // 사용자가 존재하지 않을 경우 예외 처리 또는 null을 리턴할 수 있습니다.
            return null;
        }
    }

    // User 엔티티를 UserDTO로 변환하는 메서드
    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}