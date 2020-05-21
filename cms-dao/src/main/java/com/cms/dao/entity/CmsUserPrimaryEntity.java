package com.cms.dao.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CmsUserPrimaryEntity {


    private LocalDate createTime;
    private LocalDate updateTime;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Integer loginCount;
    private Boolean status;
    private Boolean deleted;




}