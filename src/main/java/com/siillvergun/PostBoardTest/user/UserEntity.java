package com.siillvergun.PostBoardTest.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 가지는 생성자
public class UserEntity {
    private Long userId;
    private String email;
    private String nickname;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 1. 새로운 유저를 "처음" 만들 때 쓰는 생성자
    public UserEntity(Long user_id, String email, String nickname, String password) {
        this.userId = user_id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void assignUserId(Long id) {
        this.userId = id;
    }
}