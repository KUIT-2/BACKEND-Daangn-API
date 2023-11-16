package com.kuit.backenddaangnapi.global.exception;

public class DaangnException extends RuntimeException {
    public DaangnException() {
        super("당근 API DEFAULT 에러 발생");
    }

    public DaangnException(String message) {
        super(message);
    }
}
