package com.setusb.bomb.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenData {

    private static final Map<String, Object> TOKEN_MAP = new ConcurrentHashMap<>();

    public static final long CACHE_HOLD_TIME = 60 * 60 * 1000L;


    public static void put(String cacheName, Object obj) {
        put(cacheName, obj, CACHE_HOLD_TIME);
    }

    public static void put(String cacheName, Object obj, long holdTime) {
        if (checkCacheName(cacheName)) {
            return;
        }
        TOKEN_MAP.put(cacheName, obj);
        TOKEN_MAP.put(cacheName + "_HoldTime", System.currentTimeMillis() + holdTime);
    }

    public static Object get(String cacheName) {
        if (checkCacheName(cacheName)) {
            return TOKEN_MAP.get(cacheName);
        }
        return null;
    }

    public static void remove(String cacheName) {
        TOKEN_MAP.remove(cacheName);
        TOKEN_MAP.remove(cacheName + "_HoldTime");
    }

    public static boolean checkCacheName(String cacheName) {
        Long cacheHoldTime = (Long) TOKEN_MAP.get(cacheName + "_HoldTime");
        if (cacheHoldTime == null || cacheHoldTime == 0L) {
            return false;
        }
        if (cacheHoldTime < System.currentTimeMillis()) {
            remove(cacheName);
            return false;
        }
        return true;
    }
}
