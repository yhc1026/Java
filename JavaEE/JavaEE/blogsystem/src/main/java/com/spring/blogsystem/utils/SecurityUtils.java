package com.spring.blogsystem.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Slf4j
public class SecurityUtils {

    /**
     * 加密
     * 将盐和密码拼接存储于数据库中
     * @return 盐值+md5(盐值+明文)
     */

    public static String encrypt(String password){
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        String encrypt = DigestUtils.md5DigestAsHex((salt+password).getBytes());
        return salt+encrypt;
    };


    /**
     * 解密
     * 获取数据库中存储的盐，对用户输入密码进行同样操作的加密，对比密文是否相同
     * @return 返回是否正确
     */

    public static boolean check(String encrypt, String password){
        if(!StringUtils.hasLength(password)){
            return false;
        }
        if(encrypt==null||encrypt.length()!=64){
            return false;
        }
        String salt = encrypt.substring(0,32);
        String checker = salt+DigestUtils.md5DigestAsHex((salt+password).getBytes());

        if(checker.equals(encrypt)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("123456"));
    }
}
