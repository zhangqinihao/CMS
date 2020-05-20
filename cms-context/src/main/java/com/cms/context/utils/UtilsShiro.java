package com.cms.context.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class UtilsShiro {



    /*
    *
    * 通过shiro获取session
    *
    * */

    public static Session getsession(){

        return SecurityUtils.getSubject().getSession();

    }






}
