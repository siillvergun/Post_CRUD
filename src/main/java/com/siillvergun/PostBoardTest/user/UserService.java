package com.siillvergun.PostBoardTest.user;

@org.springframework.stereotype.Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 닉네임 형식 검증
    public boolean isValidNicknameFormat(String nickname) {
        // 숫자,영어,한글 + 15자 이하 2자 이상
        if (nickname == null || nickname.length() > 15 || nickname.length() < 2)
            return false;

        String regex = "^[a-zA-Z0-9가-힣]$";
        return nickname.matches(regex);
    }

    // 비밀번호 형식 검
    public boolean isValidPasswordFormat(String password) {
        // 특수문자, 영어, 숫자 포함 + 100자 이하 8자 이상
        if (password == null || password.length() > 100 || password.length() < 8) {
            return false;
        }

        // 2. 정규표현식 정의 (최소 하나의 영문, 숫자, 특수문자 포함)
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]$";
        return password.matches(regex);
    }
}
