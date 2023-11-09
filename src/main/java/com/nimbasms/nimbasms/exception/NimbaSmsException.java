package com.nimbasms.nimbasms.exception;

import lombok.Getter;

@Getter
public class NimbaSmsException extends RuntimeException {
    public NimbaSmsException(String message) {
        super(message);
    }
}
