package com.cms.portal.security.filter;

import com.alibaba.fastjson.JSON;
import com.cms.context.foundation.Result;
import com.cms.context.utils.UtilsShiro;
import com.cms.service.api.CommonService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Objects;

public class CmsAuthenticationFilter extends FormAuthenticationFilter {

    //默认登录路径
    private static final String ADMIN_LOGIN = "/admin/cms/login.do";
    //默认编码格式
    private static final String ENCODED = "utf-8";
    //默认响应类型
    private static  final  String JSONENCODED="application/json;charset=UTF-8";


    @Autowired
    private CommonService commonService;


    /*重写登录*/
    @Override
    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.getLoginUrl(),request) ||
               this.pathsMatch(ADMIN_LOGIN,request);
    }

    /*重写验证*/
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {

//        //延迟请求
//        Thread.sleep(3000);
        response.setCharacterEncoding(ENCODED);
        response.setContentType(JSONENCODED);
        String captcha = commonService.verifyimageCapcha(WebUtils.getCleanParam(request, "captcha"));

//        if(Objects.nonNull(captcha)){
//
//            response.getWriter().write(JSON.toJSONString( Result.success(captcha)));
//            return false;
//        }

        //TODO 跳过校验验证码
        if(1>2 && Objects.nonNull(captcha)){
            response.getWriter().write(JSON.toJSONString(Result.failed(captcha)));
            return false;
        }

        //获取Subject
        Subject subject = UtilsShiro.getSubject();



        AuthenticationToken token=this.createToken(request,response);

        try {

            subject.login(token);
            response.getWriter().write(JSON.toJSONString( Result.success("登录成功!")));

        }catch (UnknownAccountException |IncorrectCredentialsException e){

            response.getWriter().write(JSON.toJSONString( Result.failed("用户名或者密码错误,请重新输入!")));
        }
        //类调用封装好的方法
        response.getWriter().write(JSON.toJSONString( Result.success("登录成功!")));

        /*因为登录是get请求,ajax是post*/
        return false;
    }
}
