package com.cms.context.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class UtilsShiro {



    /*
    *
    * 通过shiro获取session
    *
    * */

    public static Session getsession(){

        return SecurityUtils.getSubject().getSession();

    }

    /**
     * 获取shiro的Subject
     * @return
     */
    public static Subject getSubject(){

        return  SecurityUtils.getSubject();
    }





}
