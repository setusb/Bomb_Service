package com.setusb.bomb.common;

import java.util.HashMap;

public class Response extends HashMap<String, Object> {

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    public static final String SUCCESS_TAG = "success";

    public static final String ERROR_TAG = "error";

    public Response() {}

    public Response(String msg, Object data) {
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    public static Response success() {
        return new Response(SUCCESS_TAG, true);
    }

    public static Response success(Object data) {
        return new Response(SUCCESS_TAG, data);
    }

    public static Response error(){
        return new Response(ERROR_TAG, null);
    }

    public static Response error(String msg){
        return new Response(msg, null);
    }
}
