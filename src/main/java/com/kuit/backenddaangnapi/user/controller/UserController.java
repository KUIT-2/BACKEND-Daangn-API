package com.kuit.backenddaangnapi.user.controller;

import com.kuit.backenddaangnapi.global.dto.BaseResponse;
import com.kuit.backenddaangnapi.global.dto.BaseResponseStatus;
import com.kuit.backenddaangnapi.global.exception.DuplicateUserException;
import com.kuit.backenddaangnapi.global.exception.EmptyArgumentException;
import com.kuit.backenddaangnapi.global.exception.NotFoundUserException;
import com.kuit.backenddaangnapi.security.CustomUserDetails;
import com.kuit.backenddaangnapi.user.domain.User;
import com.kuit.backenddaangnapi.user.dto.LoginReq;
import com.kuit.backenddaangnapi.user.dto.LoginRes;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;
import com.kuit.backenddaangnapi.user.dto.SignUpRes;
import com.kuit.backenddaangnapi.user.dto.UserInfoRes;
import com.kuit.backenddaangnapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public BaseResponse<SignUpRes> singUp(@RequestBody SignUpReq signUpReq) {
        try {
            SignUpRes signUpRes = userService.signUp(signUpReq);
            return new BaseResponse<>(signUpRes, BaseResponseStatus.CREATED);
        } catch (DuplicateUserException e) {
            return new BaseResponse<>(BaseResponseStatus.CONFLICT);
        } catch (EmptyArgumentException e) {
            return new BaseResponse<>(BaseResponseStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public BaseResponse<LoginRes> login(@RequestBody LoginReq loginReq) {
        try {
            LoginRes loginRes = userService.login(loginReq);
            return new BaseResponse<>(loginRes);
        } catch (NotFoundUserException e) {
            return new BaseResponse<>(BaseResponseStatus.NOT_FOUND);
        } catch (EmptyArgumentException e) {
            return new BaseResponse<>(BaseResponseStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public BaseResponse<UserInfoRes> getUser(Authentication authentication) {

        try {
            UserInfoRes userInfoRes = userService.getUser(authentication);
            return new BaseResponse<>(userInfoRes);
        } catch (Exception e) {
            return new BaseResponse<>(BaseResponseStatus.BAD_REQUEST);
        }
    }
}
