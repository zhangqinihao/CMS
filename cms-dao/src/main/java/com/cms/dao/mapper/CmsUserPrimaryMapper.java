package com.cms.dao.mapper;

import com.cms.dao.entity.CmsUserPrimaryEntity;

public interface CmsUserPrimaryMapper {


    /**根据名称查询
     * @param username
     * @return
     */
    CmsUserPrimaryEntity getByUsername(String username);




}
