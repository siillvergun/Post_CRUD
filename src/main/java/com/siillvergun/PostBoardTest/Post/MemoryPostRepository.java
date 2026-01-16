package com.siillvergun.PostBoardTest.Post;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryPostRepository implements PostRepository {
    private static Long seq = 0L;
    private static Map<Long, Post> store = new HashMap<>();

    @Override
    public Post save(Post post) {
        post.assignPostId(++seq);
        store.put(post.getPostId(), post);
        return post;
    }

    @Override
    public List<Post> findByAuthorId(Long userId) {
        return store.values().stream().filter(post -> post.getAuthor().getUserId().equals(userId)).toList();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }
}
