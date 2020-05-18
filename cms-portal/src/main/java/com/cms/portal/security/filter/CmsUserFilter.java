package com.cms.portal.security.filter;

import lombok.Data;
import org.apache.shiro.web.filter.authc.UserFilter;
@Data
public class CmsUserFilter extends UserFilter {

    private  String adminLoginUrl;
    private  String adminPrefix;





}
