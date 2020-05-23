package com.cms.dao.mapper;


import com.cms.dao.entity.CmsUserEntity;

public interface CmsUserMapper {


    /**通过用户名查找
     * @param username
     * @return
     */
    CmsUserEntity getByUsername(String username);


}
