package com.silent.fiveghost.guide.config;

/**
 * Created by shuaiJie on 2018/1/1.
 */
// TODO 主要存放常量字段
public interface Concat {
    /*登录*/
    String LOGIN_URL = "http://120.79.137.110:80/api/v1/auth/login";
    /*•通用验证码接口(短信)*/
    String YZM_URL = "http://120.79.137.110:81/api/v1/sms/send";
    /*注册*/
    String REGISTER_URL = "http://120.79.137.110:80/api/v1/auth/signup";
    /*找回密码*/
    String REPASSWORD_URL = "http://120.79.137.110:80/api/v1/auth/reset-password";
    /*•通用验证码验证接口*/
    String VERIFY_URL = "http://120.79.137.110/api/v1/sms/verify";
    /*•通用验证码验证清除接口*/
    String CLEAN_URL = "http://120.79.137.110/api/v1/sms/clean";
    /*用户基本信息接口*/
    String INFO_URL = "http://120.79.137.110:81/api/v1/user/info";
    /*导游/游客信息提交更新接口*/
    String UPDATA_URL = "http://120.79.137.110/api/v1/user/update";
    /*注册接口-s*/
    String SIGNUP_URL = "http://120.79.137.110:80/api/v1/auth/signup";
    /*上传图片*/
    String UPIMAGE_URL = "http://120.79.137.110/api/v1/user/image-upload";


    String FILE_NAME = "";

    String SPDefault = "default";
}
