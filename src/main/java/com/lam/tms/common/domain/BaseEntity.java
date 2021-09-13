package com.lam.tms.common.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 *
 * <p>
 * 父实体类
 * </p>
 *
 * @author lamlados
 * @version 2.0
 * @date 2021/3/18 11:45
 *
 */

@Getter
@Setter
public class BaseEntity implements java.io.Serializable {

    /**
     * @description: 创建时间
     * @date: 2019/12/11 21:12
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**
     * @description: 最后一次修改时间
     * @date: 2019/12/11 21:12
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

}
