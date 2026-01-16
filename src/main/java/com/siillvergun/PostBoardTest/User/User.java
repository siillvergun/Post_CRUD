package com.siillvergun.PostBoardTest.User;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class User {
    private Long userId;
    private String email;
    private String nickname;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    // 1. 새로운 유저를 "처음" 만들 때 쓰는 생성자
    public User(Long user_id, String email, String nickname, String password) {
        this.userId = user_id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 2. 이미 존재하는 데이터(DB 등)를 "불러올" 때 쓰는 생성자
    public User(Long user_id, String email, String nickname, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.userId = user_id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void assignUserId(Long id) {
        this.userId = id;
    }
}