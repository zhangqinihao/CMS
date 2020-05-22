package com.cms.service.converter;

import com.cms.dao.entity.CmsUserPrimaryEntity;
import com.cms.service.dto.CmsUserPrimaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
//倒mapstruct包
@Mapper
public interface CmsUserPrimaryConverter {



    //手动转换  静态实例
    CmsUserPrimaryConverter CONVERTER=Mappers.getMapper(CmsUserPrimaryConverter.class);

    CmsUserPrimaryDto entityToDto(CmsUserPrimaryEntity entity);


    
}
