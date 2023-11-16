package com.kuit.backenddaangnapi.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LogoutRes {
    private String userId;
    private String nickname;

    @Builder
    public LogoutRes(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }
}
