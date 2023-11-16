package com.kuit.backenddaangnapi.global.exception.handler;

import com.kuit.backenddaangnapi.global.exception.DaangnException;
import com.kuit.backenddaangnapi.global.exception.custom.DuplicateUserException;
import com.kuit.backenddaangnapi.global.exception.custom.EmptySignupArgumentException;
import com.kuit.backenddaangnapi.user.dto.SignUpReq;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ControllerExceptionHandler {

    @ExceptionHandler({EmptySignupArgumentException.class, DuplicateUserException.class})
    public ResponseEntity<SignUpReq> signupExceptionHandle(DaangnException e) {

        if (e instanceof DuplicateUserException) {
            SignUpReq signUpReq = ((DuplicateUserException) e).getSignUpReq();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(signUpReq);
        }
        if (e instanceof EmptySignupArgumentException) {
            SignUpReq signUpReq = ((EmptySignupArgumentException) e).getSignUpReq();
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(signUpReq);
        }
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(DaangnException.class)
    public void daangnExceptionHandle() {

    }
}
