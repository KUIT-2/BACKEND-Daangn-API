package com.kuit.backenddaangnapi.user.service;

import com.kuit.backenddaangnapi.global.exception.custom.DuplicateUserException;
import com.kuit.backenddaangnapi.user.domain.User;
import com.kuit.backenddaangnapi.user.dto.LoginReq;
import com.kuit.backenddaangnapi.user.dto.LoginRes;
import com.kuit.backenddaangnapi.user.dto.LogoutReq;
import com.kuit.backenddaangnapi.user.dto.LogoutRes;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;
import com.kuit.backenddaangnapi.user.dto.SignUpRes;
import com.kuit.backenddaangnapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SignUpRes signUp(SignUpReq signUpReq) {
        signupValidation(signUpReq);

        User saveUser = User.builder()
                .userId(signUpReq.getUserId())
                .password(signUpReq.getPassword())
                .nickname(signUpReq.getNickname())
                .build();

        User savedUser = userRepository.save(saveUser);
        return new SignUpRes(savedUser.getUserId());
    }

    public LoginRes login(LoginReq loginReq) {
        return new LoginRes();
    }

    public LogoutRes logout(LogoutReq logoutReq) {
        return new LogoutRes();
    }
    private void signupValidation(SignUpReq signUpReq) {
        signUpReq.isValid();
        Optional<User> byId = userRepository.findById(signUpReq.getUserId());
        if(byId.isPresent()){
            throw new DuplicateUserException(signUpReq);
        }

    }
}
