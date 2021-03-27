package com.lam.tms.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;


/**
 *
 * @author lamlados
 * @date 2021/2/20 15:26
 */


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements java.io.Serializable {

    private Integer id;

    private String username;

    private String currentItem;


}
