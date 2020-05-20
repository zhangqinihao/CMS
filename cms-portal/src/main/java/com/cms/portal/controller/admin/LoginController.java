package com.cms.portal.controller.admin;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.cms.service.api.CommonService;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 个人微信: 15254124776
 * 个人qq:  2301887641
 * @date: 2020/02/16/15:17
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private Producer captchaProducer;

    @Autowired
    private CommonService commonService;




    @GetMapping("login.do")
    public String toLogin() {
        return "/admin/login";
    }

    @GetMapping("captcha.do")
    public void doCaptcha() {
        commonService.imageCapcha();
    }

        /*Hutool方式*/
//    @GetMapping("captcha.do")
//    public  void doCaptcha(HttpServletResponse httpServletResponse) throws IOException {
//        //hutool
//        //定义图形验证码的长和宽
//        //干扰验证码
//        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(116, 36, 5, 5);
//        //获取验证码
//        //String code = captcha.getCode();
//        //  System.out.println(code);
//        //放进session
//        //  session.setAttribute("code",code);
//
//
//        //用流把验证码写出去
//        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
//        captcha.write(outputStream);
//        //写完关流
//        outputStream.close();
//    }


}
