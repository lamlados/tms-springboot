package com.lam.tms.mapper;

import com.lam.tms.entity.DictQueryItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lamlados
 * @date 2021/3/24 12:45
 */
@Mapper
@Repository
public interface DictQueryMapper {

    List<DictQueryItem> getNoMarkList(String queryType);

    List<DictQueryItem> getMarkList(String queryType);

    List<DictQueryItem> getAbilityList(String queryType);

}
