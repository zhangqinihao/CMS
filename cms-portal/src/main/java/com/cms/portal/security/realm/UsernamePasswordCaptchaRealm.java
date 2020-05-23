package com.cms.portal.security.realm;

import com.cms.service.api.CmsUserService;
import com.cms.service.dto.CmsUserDto;
import com.cms.service.dto.CmsUserPrimaryDto;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class UsernamePasswordCaptchaRealm extends AuthorizingRealm {

    @Autowired
    private CmsUserService cmsUserService;




    //登录
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {





        return null;
    }

    //建权
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //先在父表中查找用户是否存在
        CmsUserDto cmsUserDto = cmsUserService.selectByUsername(username);


        if(Objects.isNull(cmsUserDto)){
           throw new UnknownAccountException();

        }

        //校验用户状态 禁用

        return null;
    }
}
