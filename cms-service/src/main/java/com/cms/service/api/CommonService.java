package com.cms.service.api;

public interface CommonService {


    /*
    * 生成图片验证码
    *
    * */
    void imageCapcha();


    /*
    *
    * 验证 验证码
    * */
    String verifyimageCapcha(String captcha);


}
