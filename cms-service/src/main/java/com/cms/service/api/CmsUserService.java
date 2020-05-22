package com.cms.service.api;

import com.cms.service.dto.CmsUserPrimaryDto;
import org.springframework.stereotype.Service;


public interface CmsUserService {

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    CmsUserPrimaryDto selectByUsername(String username);

}
