package com.example.demo;

import cn.hutool.captcha.LineCaptcha;

public class test {
    public static void main(String[] args) {
        LineCaptcha lineCaptcha=new LineCaptcha(200,100);
        lineCaptcha.write("D:\\codeC\\java-int\\JDK18\\bit_courseJAVA\\JavaEE\\Captcha\\line.png");
    }
}
