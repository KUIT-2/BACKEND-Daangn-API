package com.kuit.backenddaangnapi.user.dto;

import com.kuit.backenddaangnapi.global.exception.EmptyArgumentException;
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
        if (this.userId.isEmpty()|| this.password.isEmpty() || this.nickname.isEmpty()) {
            throw new EmptyArgumentException();
        }

    }
}
