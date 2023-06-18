package com.example.internetwork.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.example.internetwork.entity.User;
import com.example.internetwork.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
//import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Date;

//import static com.example.internetwork.controller.UserController.token_tmp;

@Slf4j
@Component
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class TokenUtils {

    @Autowired
    private UserMapper userMapper;

    private static UserMapper staticUserMapper;

    @PostConstruct
    public void init() {
        staticUserMapper = userMapper;
    }

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String genToken(User user) {
        return JWT.create().withExpiresAt(DateUtil.offsetDay(new Date(), 1)).withAudience(user.getUid().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }

    /**
     * 获取token中的用户信息
     * @return
     */
//    public static User getUser(String token) {
//        try {
//
//            String aud = JWT.decode(token).getAudience().get(0);
//            System.out.println(aud);
//            Integer userId = Integer.valueOf(aud);
//            System.out.println(userId);
//            return staticUserMapper.selectById(userId);
//        } catch (Exception e) {
//            log.error("解析token失败", e);
//            return null;
//        }
//    }

    public static User getUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            System.out.println(token);
            String aud = JWT.decode(token).getAudience().get(0);
            System.out.println(aud);
            Integer userId = Integer.valueOf(aud);
            System.out.println(userId);
            return staticUserMapper.selectById(userId);
        } catch (Exception e) {
            log.error("解析token失败", e);
            return null;
        }
    }
}
