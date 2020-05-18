package com.cms.portal.security.filter;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CmsAuthenticationFilter extends FormAuthenticationFilter {

    //默认登录路径
    private static final String ADMIN_LOGIN = "/admin/cms/login.do";
    //默认编码格式
    private static final String ENCODED = "utf-8";
    //默认响应类型
    private static  final  String JSONENCODED="application/json;charset=UTF-8";


    /*重写登录*/
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(),request) ||
               this.pathsMatch(ADMIN_LOGIN,request);
    }

    /*重写验证*/
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding(ENCODED);
        response.setContentType(JSONENCODED);
        response.getWriter().write(JSON.toJSONString("验证码错误!"));
        /*因为登录是get请求,ajax是post*/
        return false;
    }
}
