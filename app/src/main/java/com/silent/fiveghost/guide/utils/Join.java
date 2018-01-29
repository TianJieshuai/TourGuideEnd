package com.silent.fiveghost.guide.utils;

import android.text.TextUtils;

/**
 * Created by lenovo on 2017/8/27.
 */

public class Join {
    public static boolean isPass(String password){
        String num="[a-zA-Z][a-zA-Z0-9]{5,19}";
        if (TextUtils.isEmpty(password)){
            return false;
        }else{
            return password.matches(num);
        }


    }
    public static boolean isMobile(String number) {
        String num = "[1][358]\\d{9}";
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            return number.matches(num);
        }
    }

    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        if (TextUtils.isEmpty(strPattern)) {
            return false;
        } else {
            return strEmail.matches(strPattern);
        }
    }
    public static int getCode(){
        int  code = (int) (Math.random() * 10000);
        return code;

    }
}
