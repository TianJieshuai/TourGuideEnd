package com.silent.fiveghost.guide.utils;

import com.silent.fiveghost.guide.http.httpapis.CallBack;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by shuaiJie on 2018/1/28.
 * .                       .::::.
 * .                    .::::::::.
 * .                   :::::::::::
 * .                ..:::::::::::'   女
 * .              '::::::::::::'      神
 * .                .:::::::::       保
 * .               '::::::::::..      佑
 * .               .::::::::::::::.  代
 * .              `:::::::::::::::::  码
 * .              ::::``::::::::::'  无   .:::.
 * .             ::::'   ':::::' debug .::::::::.
 * .            .:::'      ::::     .:::::::'.::::.
 * .          .:::'       :::::  .:::::::::'  ':::::.
 * .         .::'        :::::.:::::::::'       ':::::.
 * .        .::'         ::::::::::::::'          ``::::.
 * .    ...:::           ::::::::::::'                ``::.
 * .   ```` ':.          ':::::::::'                    ::::..
 * .                      '.:::::'                     ':'````..
 * .
 * 作    者：shuaiJie
 * 创建时间：2018/1/28 9:21
 * 电子邮箱：510889082@qq.com
 */

public class TypeUtils {
    //获取泛型
    public static Type getType(CallBack callBack) {
        //获取CallBack父类
        Type superType = callBack.getClass().getGenericSuperclass();
        //获取父类泛型
        return ((ParameterizedType) superType).getActualTypeArguments()[0];
    }
/*
    //获取泛型
    public static Type getType(CallBack callBack) {
        //获取CallBack实现的接口数组
        Type[] interfaces = callBack.getClass().getGenericInterfaces();
        //返回递归结果
        return forType(interfaces).getActualTypeArguments()[0];
    }
    //递归遍历 接口数组 所有接口  以及 接口继承 的所有接口
    private static ParameterizedType forType(Type[] types) {
        //循环外保留存储变量
        ParameterizedType retrunType = null;
        //遍历接口数组
        for (Type type : types) {
            //判断当前对象是否有泛型
            if (type instanceof ParameterizedType) {
                //是    向下转型
                retrunType = (ParameterizedType) type;
                //判断当前的Type是否是 CallBack
                if (retrunType.getRawType().toString().contains(CallBack.class.getName())) {
                    //是     返回当前type
                    retrunType = retrunType;
                } else {
                    //否     利用反射获取当前type的父接口数组经行递归
                    try {
                        //获取到当前type的包名去除interface 字样
                        String replace = retrunType.getRawType().toString().replace("interface ", "");
                        //使用类加载器获取当前type继承的所有接口     调用自身方法经行遍历
                        ParameterizedType forType = forType(Class.forName(replace).getGenericInterfaces());
                        //判断返回是否空   不为空返回保留变量   同时防止return关键字结束循环
                        if (forType != null) return retrunType;//return结束循环同时结束循环
                    } catch (ClassNotFoundException e) {
                        //捕捉到异常返回空
                        return null;
                    }
                }
            }
        }
        //循环走完未找到CallBack返回空
        return retrunType;
    }*/
}
