//package com.wx.assigntask.common.security;
//
///**
// * @Author: wx
// * @Date: 2018/12/4 21:35
// * @Version 1.0
// */
///**
// * spring-security登陆的密码进行MD5加密传到数据库
// */
//public class CustomPasswordEncoder implements PasswordEncoder {
//    @Override
//    public String encode(CharSequence rawPassword) {
//        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//        return encoder.encodePassword(rawPassword.toString(), "hyll");
//    }
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//        return encoder.isPasswordValid(encodedPassword, rawPassword.toString(), "hyll");
//    }
//
//}
//
