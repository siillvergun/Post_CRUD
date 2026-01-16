package com.siillvergun.PostBoardTest.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user); // 유저 저장

    Optional<User> findById(Long id); // ID로 유저 찾기

    Optional<User> findByEmail(String email);

    Optional<User> findByNickname(String nickname);

    List<User> findAll(); // 모든 유저 목록 보기
}
