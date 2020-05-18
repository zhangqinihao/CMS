package com.cms.portal.security.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CmsAuthenticationFilter extends FormAuthenticationFilter {


    /*重写登录*/
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(),request) ||
               this.pathsMatch("/admin/cms/login.do",request);
    }




}
