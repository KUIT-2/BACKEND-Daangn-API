package com.kuit.backenddaangnapi.user.controller;

import com.kuit.backenddaangnapi.global.dto.BaseResponse;
import com.kuit.backenddaangnapi.global.dto.BaseResponseStatus;
import com.kuit.backenddaangnapi.user.dto.LoginReq;
import com.kuit.backenddaangnapi.user.dto.LoginRes;
import com.kuit.backenddaangnapi.user.dto.LogoutReq;
import com.kuit.backenddaangnapi.user.dto.LogoutRes;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;
import com.kuit.backenddaangnapi.user.dto.SignUpRes;
import com.kuit.backenddaangnapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public BaseResponse<SignUpRes> singUp(@RequestBody SignUpReq signUpReq){
        SignUpRes signUpRes = userService.signUp(signUpReq);
        return new BaseResponse<>(signUpRes);

    }

    @PostMapping("/login")
    public BaseResponse<LoginRes> login(@RequestBody LoginReq loginReq){
        LoginRes loginRes = userService.login(loginReq);
        return new BaseResponse<>(loginRes);

    }

    @GetMapping("/logout")
    public BaseResponse<LogoutRes> logout(@ModelAttribute LogoutReq logoutReq){
        LogoutRes logoutRes = userService.logout(logoutReq);
        return new BaseResponse<>(logoutRes);
    }
}
