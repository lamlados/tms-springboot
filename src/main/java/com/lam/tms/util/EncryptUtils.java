package com.lam.tms.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Base64;

/**
 * 加密解密工具类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */

@Slf4j
public class EncryptUtils {

    /**
     * base64 加密
     *
     * @param source
     * @return java.lang.String
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String base64Encoder(String source) {
        return Base64.getEncoder().encodeToString(source.getBytes());
    }

    /**
     * 生成一个模板的key
     *
     * @param parkId
     * @param templateName
     * @return java.lang.String
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String createTemplateKey(String parkId, String templateName) {
        String format = String.format("%s#%s", parkId, templateName);
        log.debug("format: {}", format);
        return base64Encoder(format);
    }

    /**
     * base64 加密
     *
     * @return java.lang.String
     * @param: source
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String base64Encoder(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }

    /**
     * base64 解密
     *
     * @param source
     * @return java.lang.String
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String base64Decoder(String source) {
        byte[] decode = Base64.getDecoder().decode(source);
        return new String(decode);
    }

}
