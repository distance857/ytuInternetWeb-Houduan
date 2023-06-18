//package com.example.internetwork.common;
//
//import cn.hutool.core.util.StrUtil;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//
//import com.example.internetwork.entity.User;
//import com.example.internetwork.exception.CustomException;
//import com.example.internetwork.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class AuthInterceptor implements HandlerInterceptor {
//    @Autowired
//    private UserService userService;
//
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        String token = request.getHeader("token");
//        if (StrUtil.isBlank(token)) {
//            throw new CustomException("401", "未获取到token, 请重新登录");
//        }
//        Integer userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
//        User user = userService.getUserById(userId);
//        if (user == null) {
//            throw new CustomException("401", "token不合法");
//        }
//        // 验证 token
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//        try {
//            jwtVerifier.verify(token);
//        } catch (Exception e) {
//            throw new CustomException("401", "token不合法");
//        }
//        return true;
//    }
//}
