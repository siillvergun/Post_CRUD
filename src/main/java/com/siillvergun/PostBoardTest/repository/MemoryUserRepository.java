package com.siillvergun.PostBoardTest.repository;

import com.siillvergun.PostBoardTest.entity.User;

import java.util.*;

// 진짜 데이터베이스를 연결하기 전, 컴퓨터의 메모리(RAM)를 임시 저장소로 사용하는 클래스. 데이터베이스의 테이블을 자바의 자료구조로 흉내 낸 것
public class MemoryUserRepository implements UserRepository {
    // 키: 유저의 ID, 값: 유저 객체
    // HashMap<>은 데이터를 넣고 빼는 속도가 매우 빠른 자료구조
    // 객체가 여러 개 생성되어도 이 저장소는 딱 1개만 만들어져서 공유되어야함 -> static
    private static Map<Long, User> store = new HashMap<>();
    private static Long seq = 0L;

    @Override
    public User save(User user) {
        // 레포지토리가 관리해야 할 대상은 자기 자신이 아니라, Map에 담긴 다른 User 객체들.
        // 내가 User를 상속받았다고 해서, 내가 들고 있는 남(다른 User 인스턴스)의 protected 메서드까지 호출할 수 있는 권한이 생기는 것은 아님.
        // IS-A (상속): "A는 B이다." (예: 사과는 과일이다.)
        // HAS-A (조합/포함): "A는 B를 가지고 있다." (예: 창고는 사과를 가지고 있다.)
        // MemoryUserRepository는 유저들을 담는 창고(HAS-A)이지, 그 자체가 유저(IS-A)는 아님.
        // 만약 상속을 받게 되면 레포지토리 객체가 유저의 이메일, 비밀번호 필드까지 갖게 되는 어색한 구조가 된다.
        user.assignUserId(++seq);
        // 저장하려는 유저를 put 메서드를 사용해 저장 후 저장된 유저 반환
        store.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        // null을 그대로 반환하면 프로그램이 종료될 위험 존재
        // 따라서 Optional에 담아서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        // 전체 유저를 리스트로 객체 생성해 반환
        return new ArrayList<>(store.values());
    }
}
