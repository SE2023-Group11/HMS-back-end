package com.se.hmsbackend.utils;


import com.se.hmsbackend.common.Const;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;

public class TokenUtil {
    private static Set<String> black = new HashSet<>();
    //generateKey()生成的密钥
//    TODO：修改token有效期
    private static String key="BRNdyltTMUZD0doOVsbfHSO8v27YS484BJZjXYNx1Qk=";
    //设置有效期                 （ 5小时）
    private static Long millData=100 * 60*5*60*1000L;//500h

    /**
     * 生成密钥
     * @return 返回生成的密钥
     */
    public static String generateKey(){
        // 按照指定的算法 生成符合该算法长度的秘钥 32字节
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // 把生成的秘钥转换成字符串形式
        String encode = Encoders.BASE64.encode(key.getEncoded());
        return encode;
    }

    /**
     * 使用密钥进行加密生成 Token
     * @param map 明文
     * @return token字符串
     */
    public static String getToken(Map map){
        //设置当前时间
        Date currentDate = new Date();
        //设置失效时间
        Date expirationDate=new Date(currentDate.getTime()+millData);
        //把字符串密钥 转换成 Key 类型
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));

        // 使用以下方法进行加密，返回值就是根据秘钥加密后的字符串
        String jwtStr = Jwts.builder().
                setClaims(map).// 设置自定义签名 eg:用户id
                        setIssuedAt(currentDate).// 标准签名   生效时间
                        setExpiration(expirationDate).// 失效时间
                        signWith(secretKey).// 设置秘钥
                        compact();
        return jwtStr;
    }
    public static String getToken(String type, String id){
        Map<String,String> map = new HashMap<>();
        map.put(Const.NOW_LOGGED_IN_TYPE, type);
        map.put(Const.NOW_LOGGED_IN_ID, id);
        return getToken(map);
    }
    /**
     * 检验token
     */
    public static Claims parse(String token){
        if(!isRight(token))return null;
        Jws<Claims> claimsJws=null;
        try {
            claimsJws= Jwts.parserBuilder().
                    setSigningKey(key).//指定秘钥
                            build().parseClaimsJws(token);//解析token字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimsJws.getBody();
    }

    public static void addTokenToBlack(String token){
        black.add(token);
    }
    public static boolean isRight(String token){
        try{
            parse(token);
        }catch (Exception e){
            return false;
        }
        return !black.contains(token);
    }
}
