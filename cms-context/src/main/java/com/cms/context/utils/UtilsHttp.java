package com.cms.context.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilsHttp {


    /**获取Request对象
     * @return
     */
    public static HttpServletRequest getRequest(){


        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return requestAttributes.getRequest();

    }
    /**获取Response对象
     * @return
     */
    public static HttpServletResponse getResponse(){


        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return requestAttributes.getResponse();

    }





}
