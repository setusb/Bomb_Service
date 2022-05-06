package com.setusb.bomb.config.exception;

import com.setusb.bomb.common.Response;
import com.setusb.bomb.common.Translation;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandlerConfig {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response error(Exception e){
        e.printStackTrace();
        return Response.error();
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Response error(NullPointerException e){
        e.printStackTrace();
        return Response.error(Translation.NULL_POINTER_EXCEPTION);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Response error(RuntimeException e){
        e.printStackTrace();
        return Response.error(e.getMessage());
    }
}
