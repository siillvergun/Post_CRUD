package com.siillvergun.PostBoardTest.comment;

import java.util.*;

@org.springframework.stereotype.Repository
public class MemoryCommentRepository implements CommentRepository {

    private static Long seq = 0L;
    private static Map<Long, CommentEntity> store = new HashMap<>();

    @Override
    public CommentEntity save(CommentEntity commentEntity) {
        commentEntity.assignCommentId(++seq);
        store.put(commentEntity.getCommentId(), commentEntity);
        return commentEntity;
    }

    @Override
    public List<CommentEntity> findByAuthorId(Long userId) {
        return store.values().stream().filter(commentEntity -> commentEntity.getAuthor().getUserId().equals(userId)).toList();
    }

    @Override
    public List<CommentEntity> findByPostId(Long postId) {
        return store.values().stream().filter(commentEntity -> commentEntity.getAuthor().getUserId().equals(postId)).toList();
    }


    @Override
    public Optional<CommentEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<CommentEntity> findAll() {
        return new ArrayList<>(store.values());
    }
}
