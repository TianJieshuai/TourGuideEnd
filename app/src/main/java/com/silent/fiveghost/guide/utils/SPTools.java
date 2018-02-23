package com.silent.fiveghost.guide.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.reflect.TypeToken;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.config.Concat;

import java.util.Map;

public class SPTools {

    private static SharedPreferences sp;
    private static SharedPreferences spDefault;

    /**
     * 初始化SharedPreferences
     */
    public static void init(Context context) {
        spDefault = context.getSharedPreferences(Concat.SPDefault, Context.MODE_PRIVATE);
    }

    /**
     * 使用指定名称的SharedPreferences
     *
     * @param context
     * @param spName
     */
    public static void initSp(Context context, String spName) {
        sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    /**
     * 取消使用指定名称的SharedPreferences
     */
    public static void camenlSp() {
        sp = null;
    }

    private static SharedPreferences.Editor getEdit() {
        if (sp != null) {
            return sp.edit();
        } else {
            return spDefault.edit();
        }
    }

    /**
     * 保存数据
     */
    public static void put(String key, Object obj) {
        SharedPreferences.Editor editor = getEdit();
        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj);
        } else if (obj instanceof Float) {
            editor.putFloat(key, (Float) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj);
        } else if (obj instanceof Long) {
            editor.putLong(key, (Long) obj);
        } else if (obj instanceof String) {
            editor.putString(key, (String) obj);
        } else {
            editor.putString(key, GsonUtils.toJson(obj));
        }
        editor.commit();
    }

    /**
     * 获取指定数据
     * 2018年2月17日 09:11:23 焦帅杰 修改返回值 和 默认值 添加json解析BaseBean对象
     * 布尔         默认false
     * float        默认0.0
     * int          默认0
     * long         默认0
     * String       默认null
     * BaseBean     默认null
     * 其它类型     默认 "未识别类型"
     */
    public static <T> Object get(String key, T type) {
        if (sp != null) {
            if (type instanceof Boolean) {
                return (Boolean) sp.getBoolean(key, false);
            } else if (type instanceof Float) {
                return (Float) sp.getFloat(key, 0.0F);
            } else if (type instanceof Integer) {
                return (Integer) sp.getInt(key, 0);
            } else if (type instanceof Long) {
                return (Long) sp.getLong(key, 0L);
            } else if (type instanceof String) {
                return sp.getString(key, null);
            } else {
                return GsonUtils.fromJson(sp.getString(key, null), new TypeToken<BaseBean<T>>() {
                }.getType());
            }
        } else {
            if (type instanceof Boolean) {
                return (Boolean) spDefault.getBoolean(key, false);
            } else if (type instanceof Float) {
                return (Float) spDefault.getFloat(key, 0.0F);
            } else if (type instanceof Integer) {
                return (Integer) spDefault.getInt(key, 0);
            } else if (type instanceof Long) {
                return (Long) spDefault.getLong(key, 0L);
            } else if (type instanceof String) {
                return spDefault.getString(key, null);
            } else {
                return GsonUtils.fromJson(spDefault.getString(key, null), new TypeToken<BaseBean<T>>() {
                }.getType());
            }
        }
    }

    /**
     * 删除指定数据
     */
    public static void remove(String key) {
        getEdit().remove(key);
    }

    /**
     * 返回所有键值对
     */
    public static Map<String, ?> getAll() {
        if (sp != null) {
            return sp.getAll();
        } else {
            return spDefault.getAll();
        }
    }

    /**
     * 删除所有数据
     */
    public static void clear() {
        getEdit().clear().commit();
    }

    /**
     * 检查key对应的数据是否存在
     */
    public static boolean contains(String key) {
        if (sp != null) {
            return sp.contains(key);
        } else {
            return spDefault.contains(key);
        }
    }
}
