package com.kuit.backenddaangnapi.user.dto;

import com.kuit.backenddaangnapi.global.exception.custom.EmptySignupArgumentException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpReq {
    private String userId;
    private String password;
    private String nickname;

    @Builder
    public SignUpReq(String userId, String password, String nickname) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
    }

    public void isValid(){
        if (this.userId == null || this.password == null || this.nickname == null) {
            throw new EmptySignupArgumentException(this);
        }

    }
}
