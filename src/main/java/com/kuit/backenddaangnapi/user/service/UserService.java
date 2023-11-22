package com.kuit.backenddaangnapi.user.service;

import com.kuit.backenddaangnapi.global.exception.DuplicateUserException;
import com.kuit.backenddaangnapi.global.exception.NotFoundUserException;
import com.kuit.backenddaangnapi.security.CustomUserDetails;
import com.kuit.backenddaangnapi.security.JwtProvider;
import com.kuit.backenddaangnapi.user.domain.User;
import com.kuit.backenddaangnapi.user.dto.LoginReq;
import com.kuit.backenddaangnapi.user.dto.LoginRes;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;
import com.kuit.backenddaangnapi.user.dto.SignUpRes;
import com.kuit.backenddaangnapi.user.dto.UserInfoRes;
import com.kuit.backenddaangnapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;


    public SignUpRes signUp(SignUpReq signUpReq) throws DuplicateUserException{
        signupValidation(signUpReq);

        User saveUser = User.builder()
                .userId(signUpReq.getUserId())
                .password(signUpReq.getPassword())
                .nickname(signUpReq.getNickname())
                .build();

        User savedUser = userRepository.save(saveUser);
        return new SignUpRes(savedUser.getUserId());
    }

    public LoginRes login(LoginReq loginReq) throws NotFoundUserException{
        loginReq.isValid();

        User user = userRepository.findById(loginReq.getUserId()).orElseThrow(() ->
                new NotFoundUserException());

        return LoginRes.builder()
                .nickname(user.getNickname())
                .token(jwtProvider.createToken(user.getUserId()))
                .build();
    }


    private void signupValidation(SignUpReq signUpReq) throws DuplicateUserException{
        signUpReq.isValid();
        Optional<User> byId = userRepository.findById(signUpReq.getUserId());
        if(byId.isPresent()){
            throw new DuplicateUserException();
        }

    }

    public UserInfoRes getUser(Authentication authentication) {
        String id = getId(authentication);
        User user = userRepository.findById(id).orElseThrow(

        );
        return UserInfoRes.of(user);
    }

    public String getId(Authentication authentication) {
        CustomUserDetails principal = (CustomUserDetails)authentication.getPrincipal();

        return principal.getId();
    }
}
