package com.siillvergun.PostBoardTest.comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    CommentEntity save(CommentEntity commentEntity); // 유저 저장

    Optional<CommentEntity> findById(Long id); // ID로 유저 찾기

    List<CommentEntity> findByAuthorId(Long userId);

    List<CommentEntity> findByPostId(Long postId);

    List<CommentEntity> findAll(); // 모든 유저 목록 보
}
