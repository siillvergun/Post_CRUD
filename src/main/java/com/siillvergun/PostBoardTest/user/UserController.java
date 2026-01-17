package com.siillvergun.PostBoardTest.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // 이 클래스 안의 메서드들이 공통으로 가질 URL 주소를 정합니다.
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 모든 유저 조회 API
    @GetMapping // 브라우저에 주소를 쳤을 때(조회 요청) 실행되는 메서드임을 나타냅니다.
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // @PathVariable : URL 경로에 들어있는 값(예: /users/1에서 1)을 변수로 가져올 때 사용합니다.
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }

    @PostMapping("/join")
    public UserEntity join(@RequestBody UserEntity user) {
        // 1. 유효성 검사 로직 (직접 만든 메서드 활용)
        // if (isInvalidNicknameFormat(user.getNickname())) { ... }

        // 2. 중복 검사 로직
        // if (userRepository.findByEmail(user.getEmail()).isPresent()) { ... }

        // 3. 저장 및 결과 반환
        return userRepository.save(user);
    }
}
