package com.lam.tms.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


public class LocalTimeUtils {

    /**
     * @description: 获取当前时间戳(秒)
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static long getCurrentTimeSecond() {
        return LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset());
    }

    /**
     * @description: 获取当前时间戳(毫秒)
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static long getCurrentTimeMilli() {
        return LocalDateTime.now().toInstant(OffsetDateTime.now().getOffset()).toEpochMilli();
    }

    /**
     * @description: 时间戳格式化
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String timestampSecondFormat(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(Long.valueOf(timestamp + "000")));
    }

    /**
     * @description: 时间戳(毫秒) 格式化 yyyy-MM-dd HH:mm:ss
     * @author lamlados
     * @date 2021/2/20 15:26
     */
    public static String timestampMilliFormat(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }


}
