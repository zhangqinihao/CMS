package com.cms.service.impl;

import com.cms.context.utils.UtilsHttp;
import com.cms.context.utils.UtilsShiro;
import com.cms.service.api.CommonService;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {


    private static  final  String IMAGE_CAPTCHA_SUFFIX = "image_captcha";

    @Autowired
    private Producer captchaProducer;
    //引入Redis
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public void imageCapcha() {


        String text = captchaProducer.createText();


        redisTemplate.opsForValue().set(UtilsShiro.getsession().getId() + IMAGE_CAPTCHA_SUFFIX, text, 60, TimeUnit.SECONDS);

        HttpServletResponse response = UtilsHttp.getResponse();

        //设置响应类型格式为图片
        response.setContentType("image/jpeg");


        //禁止图片缓存
        response.setHeader("Pragma", "no-cache");

        response.setHeader("Cache-Control", "no-cache");

        response.setDateHeader("Expires", 0);

        //自己关闭流
        try(ServletOutputStream outputStream = response.getOutputStream()) {
            ImageIO.write(captchaProducer.createImage(text),
                    "jpg",
                    outputStream
            );
        } catch (IOException e) {
            log.error("验证码生成失败");
        }


    }

    @Override
    public String verifyimageCapcha(String captcha) {

        String rediscaptcha= redisTemplate.opsForValue().get(UtilsShiro.getsession().getId() + IMAGE_CAPTCHA_SUFFIX);
        if(Objects.isNull(rediscaptcha)){


            return "验证码已失效,请重新输入!";
        }

        if(!StringUtils.equals(captcha,rediscaptcha)){

            return "验证码错误!";

        }


        return null;
    }


}
