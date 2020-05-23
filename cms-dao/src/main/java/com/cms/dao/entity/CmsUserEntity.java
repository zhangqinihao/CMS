package com.cms.dao.entity;


import com.cms.core.foundation.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CmsUserEntity extends BaseEntity<Integer> {


    private String username;
    private Boolean status;
    private Boolean admin;

    /*
     * 超级管理员
     * */
    private Boolean administrator;



}
