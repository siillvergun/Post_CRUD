package com.siillvergun.PostBoardTest.post;

import java.util.*;

@org.springframework.stereotype.Repository
public class Repository implements PostRepository {
    private static Long seq = 0L;
    private static Map<Long, Entity> store = new HashMap<>();

    @Override
    public Entity save(Entity entity) {
        entity.assignPostId(++seq);
        store.put(entity.getPostId(), entity);
        return entity;
    }

    @Override
    public List<Entity> findByAuthorId(Long userId) {
        return store.values().stream().filter(entity -> entity.getAuthor().getUserId().equals(userId)).toList();
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Entity> findAll() {
        return new ArrayList<>(store.values());
    }
}
