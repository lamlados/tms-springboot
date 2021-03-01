package com.lam.tms.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * token 返回值>
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


@Getter
@Setter
@Builder
public class TokenValue implements java.io.Serializable {

    /**
     * @description: 请求头的值
     */
    private String header;

    /**
     * @description: token 值
     */
    private String value;

    /**
     * @description: token 前缀
     */
    private String prefix;

    /**
     * @description: 过期时间（毫秒，这里默认20分钟）
     */
    private Long expiration;

}
