package com.kuit.backenddaangnapi.user.dto;

import com.kuit.backenddaangnapi.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoRes {
    private String userId;
    private String nickname;


    public static UserInfoRes of(User user) {
        return UserInfoRes.builder()
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .build();

    }

    @Builder
    public UserInfoRes(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }
}
