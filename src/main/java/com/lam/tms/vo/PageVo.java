package com.lam.tms.vo;

import lombok.*;

/**
 * @author lamlados
 * @date 2021/2/26 0:22
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageVo implements java.io.Serializable {
    private Integer pageNum;
    private Integer pageSize;
}

