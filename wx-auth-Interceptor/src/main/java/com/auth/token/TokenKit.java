package com.auth.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DCZhang
 * @title TokenGenerate
 * @date 2023/5/19 13:24
 * @description TODO
 */
public class TokenKit {
    /**
     * 生成token
     */
    public static String getToken(String username) {
        // 创建令牌
        String token = JWT.create()
                .withHeader(header()) //设置jwt令牌的头部
                .withIssuer("auth0") //设置jwt令牌的签发者
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))  //设置jwt令牌过期时间
                .withNotBefore(new Date(System.currentTimeMillis() + 10)) // JWT的生效时间，在这个时间之前，该JWT不会被接受。
                .withAudience("audience") //设置jwt令牌的接收者
                .withSubject("user") //设置jwt令牌的主题，通常是该JWT代表的实体。
                .withClaim("username", username)
                .withClaim("role", "admin")
                .sign(algorithm("123"));
        System.out.println(token);
        return token;
    }

    private static Map<String, Object> header() {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        return header;
    }

    private static Algorithm algorithm(String secret) {
        return Algorithm.HMAC256(secret);
    }
}
