package com.mapper;

import com.entity.BusinessUser;
import com.vo.BusinessUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author DCZhang
 * @title BusinessUserConvert
 * @date 2023/5/19 13:45
 * @description TODO
 */
@Mapper
public interface BusinessUserConvert {
    BusinessUserConvert INSTANCE = Mappers.getMapper(BusinessUserConvert.class);

    /**
     * 数据库实体对象转VO对象
     *
     * @param entity BusinessUser
     * @return BusinessUserVO
     */
    BusinessUserVO toConvertBusinessUserVO(BusinessUser entity);
}
