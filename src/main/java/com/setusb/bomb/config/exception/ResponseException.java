package com.setusb.bomb.config.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseException extends RuntimeException {

    public ResponseException(String message) {
        super(message);
    }
}
