package com.cms.service.converter;

import com.cms.dao.entity.CmsUserEntity;
import com.cms.service.dto.CmsUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CmsUserConverter {


    CmsUserConverter CONVERTER= Mappers.getMapper(CmsUserConverter.class);

    CmsUserEntity dtoToEntity(CmsUserDto dto);


    CmsUserDto entityToDto(CmsUserEntity entity);



}
