package com.cms.service.dto;

import com.cms.core.foundation.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CmsUserDto extends BaseDto<Integer> {


    private String username;
    private Boolean status;
    private Boolean admin;

    /*
    * 超级管理员
    * */
    private Boolean administrator;


}
