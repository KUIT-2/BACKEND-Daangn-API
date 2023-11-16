package com.kuit.backenddaangnapi.global.exception.custom;

import com.kuit.backenddaangnapi.global.exception.DaangnException;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;

public class DuplicateUserException extends DaangnException {
    private SignUpReq signUpReq;

    public DuplicateUserException(SignUpReq signUpReq) {
        this.signUpReq = signUpReq;
    }

    public SignUpReq getSignUpReq() {
        return signUpReq;
    }
}
