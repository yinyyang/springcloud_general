package com.springcloud.zuul.utils;

import org.springframework.security.jwt.JwtHelper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@Component
public class JwtTokenUtil implements Serializable {
//
//    /**
//     * 密钥
//     */
//    private final String secret = "aaaaaaaa";
//
//
//
//    /**
//     * 从令牌中获取数据声明
//     *
//     * @param token 令牌
//     * @return 数据声明
//     */
//    private String getClaimsFromToken(String token) {
//        String claims = "";
//        try {
//            claims = JwtHelper.decode(token).getClaims();
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//        return claims;
//    }
//
//
//
//    /**
//     * 从令牌中获取用户名
//     *
//     * @param token 令牌
//     * @return 用户名
//     */
//    public String getUsernameFromToken(String token) {
//        String username;
//        try {
//            Claims claims = getClaimsFromToken(token);
//            username = claims.getSubject();
//        } catch (Exception e) {
//            username = null;
//        }
//        return username;
//    }
//
//    /**
//     * 判断令牌是否过期
//     *
//     * @param token 令牌
//     * @return 是否过期
//     */
//    public Boolean isTokenExpired(String token) {
//        try {
//            Claims claims = getClaimsFromToken(token);
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    /**
//     * 验证令牌
//     *
//     * @param token       令牌
//     * @param userDetails 用户
//     * @return 是否有效
//     */
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUser user = (JwtUser) userDetails;
//        String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername()) && !isTokenExpired(token));
//    }

}