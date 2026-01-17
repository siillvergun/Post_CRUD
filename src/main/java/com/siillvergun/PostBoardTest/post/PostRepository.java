package com.siillvergun.PostBoardTest.post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Entity save(Entity entity); // 유저 저장

    Optional<Entity> findById(Long id); // ID로 유저 찾기

    List<Entity> findByAuthorId(Long userId);

    List<Entity> findAll(); // 모든 유저 목록 보기
}
