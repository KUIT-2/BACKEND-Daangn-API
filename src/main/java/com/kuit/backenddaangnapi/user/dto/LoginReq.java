package com.kuit.backenddaangnapi.user.dto;

import com.kuit.backenddaangnapi.global.exception.EmptyArgumentException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {
    private String userId;
    private String password;

    public void isValid() {
        if(userId.isEmpty() || password.isEmpty()){
            throw new EmptyArgumentException();
        }
    }
}
