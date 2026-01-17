package com.siillvergun.PostBoardTest.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserEntity save(UserEntity userEntity); // 유저 저장

    Optional<UserEntity> findById(Long id); // ID로 유저 찾기

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByNickname(String nickname);

    List<UserEntity> findAll(); // 모든 유저 목록 보기
}
