package com.spring.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 通用工具类
 * Created by admin on 2018/8/21.
 */
public class Md5Utils {

    /**
     * md5字符串
     *
     * @param content 内容
     * @return 加密字符串
     */
    public static String md5(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(content.getBytes("UTF-8"));
            return (bytesToHex(md.digest()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
        return null;
    }

    /**
     * md5 加密
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte bytes[]) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (int i = 0, len = bytes.length; i < len; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return sb.toString();
    }
}
