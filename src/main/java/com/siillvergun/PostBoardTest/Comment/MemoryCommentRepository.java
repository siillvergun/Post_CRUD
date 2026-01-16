package com.siillvergun.PostBoardTest.Comment;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCommentRepository implements CommentRepository {

    private static Long seq = 0L;
    private static Map<Long, Comment> store = new HashMap<>();

    @Override
    public Comment save(Comment comment) {
        comment.assignCommentId(++seq);
        store.put(comment.getCommentId(), comment);
        return comment;
    }

    @Override
    public List<Comment> findByAuthorId(Long userId) {
        return store.values().stream().filter(comment -> comment.getAuthor().getUserId().equals(userId)).toList();
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return store.values().stream().filter(comment -> comment.getAuthor().getUserId().equals(postId)).toList();
    }


    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(store.values());
    }
}
