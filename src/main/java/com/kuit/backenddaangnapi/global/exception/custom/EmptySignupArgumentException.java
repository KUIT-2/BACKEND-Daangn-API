package com.kuit.backenddaangnapi.global.exception.custom;

import com.kuit.backenddaangnapi.global.exception.DaangnException;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;

public class EmptySignupArgumentException extends DaangnException {
    private SignUpReq signUpReq;
    public EmptySignupArgumentException(SignUpReq signUpReq){
        this.signUpReq = signUpReq;
    }

    public SignUpReq getSignUpReq() {
        return signUpReq;
    }
}
