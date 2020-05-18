package com.cms.portal.freemarker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/*配置全局路径*/
@Slf4j
public class CmsViewResolver extends FreeMarkerView {

    private static final String admin_path="/admin/cms";


    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        super.exposeHelpers(model, request);
        /*
        *
        * getContextPath():获取项目的根路径
          getServletPath():获取能够与web.xml中的<servlet-mapping>标签中“url-pattern”中匹配的路径，注意是完全匹配的部分，*的部分不包括
          getRequestURI() 返回除去host（域名或者ip）部分的路径
        *
        * */
        final String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();
        final String servletPath = request.getServletPath();

        //判断是包含后台路径
        if (requestURI.contains(admin_path)) {

            model.put("basePath",contextPath);

        }


        model.put("adminPath",contextPath+servletPath);



    }
}
