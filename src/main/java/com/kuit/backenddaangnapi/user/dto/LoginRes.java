package com.kuit.backenddaangnapi.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRes {
    private String nickname;
    private String token;

    @Builder
    public LoginRes(String nickname, String token) {
        this.nickname = nickname;
        this.token = token;
    }
}
