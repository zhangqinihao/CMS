package com.cms.dao.entity;

import com.cms.core.foundation.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CmsUserPrimaryEntity extends BaseDto<Integer> {


    private LocalDate createTime;
    private LocalDate updateTime;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Integer loginCount;





}
