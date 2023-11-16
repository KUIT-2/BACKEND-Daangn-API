package com.kuit.backenddaangnapi.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRes {
    private String nickname;
    private String token;

}
