package com.setusb.bomb.utils;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class EncryptUtil {

    private final static byte[] KEY = "337c4b1f09c94128b2d8bbbd1f0e9d04".getBytes();

    public static String encrypt(String str) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, KEY);
        return aes.encryptHex(str);
    }
}
