package com.auth.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Value("${auth.jwt.secret}")
    private String secret;

    private static final String AUTHORIZATION_STR = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        String token = request.getHeader(AUTHORIZATION_STR);
        if (StringUtils.isEmpty(token)) {
            // 如果token为空，鉴权失败，返回401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        try {
            // 解码token，验证其有效性
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret))
                    .build();
            DecodedJWT verify = jwtVerifier.verify(token);
            String username = verify.getClaim("username").asString();
            CurrentUserHolder.setUser(new User(1L, username));
        } catch (Exception e) {
            // 如果token无效，鉴权失败，返回401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // token验证通过，放行请求
        return true;
    }

}