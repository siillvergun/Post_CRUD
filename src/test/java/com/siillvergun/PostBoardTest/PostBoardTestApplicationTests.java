package com.siillvergun.PostBoardTest;

import com.siillvergun.PostBoardTest.entity.Comment;
import com.siillvergun.PostBoardTest.entity.Post;
import com.siillvergun.PostBoardTest.entity.User;
import com.siillvergun.PostBoardTest.repository.MemoryUserRepository;
import com.siillvergun.PostBoardTest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostBoardTestApplicationTests {

    @Test
    void Entity_Connect_Test() {
        User user = new User(1L, "test@naver.com", "실버건", "1234");
        Post post = new Post(10L, user, "테스트 제목", "테스트 내용", "test.png");
        Comment comment = new Comment(post, user, 100L, "반갑습니다");

        // 4. 결과 출력 및 확인
        System.out.println("========================================");
        System.out.println("댓글 내용: " + comment.getContent());
        System.out.println("댓글 작성자: " + comment.getAuthor().getNickname());
        System.out.println("댓글이 달린 게시글 제목: " + comment.getPost().getTitle());
        System.out.println("게시글 작성자 이메일: " + comment.getPost().getAuthor().getEmail());
        System.out.println("댓글 생성 시간: " + comment.getCreatedAt());
        System.out.println("========================================");
    }

    @Test
    void Repository_Save_Find_Test() {
        // 1. 준비
        UserRepository userRepository = new MemoryUserRepository();
        User user = new User(1L, "silver@test.com", "실버건", "1234");

        // 2. 실행 (저장)
        userRepository.save(user);

        // 3. 검증 (조회)
        User savedUser = userRepository.findById(1L).get();

        System.out.println("저장된 유저 닉네임: " + savedUser.getNickname());

        // 유저가 잘 저장되었는지 비교
        if (user.equals(savedUser)) {
            System.out.println("테스트 성공: 동일한 유저입니다.");
        }
    }
}