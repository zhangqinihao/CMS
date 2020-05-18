package com.cms.portal.controller.admin;

import com.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("test")
    public void test(){
        redisTemplate.opsForValue().set("abc","asdfsadf");
    }

}
