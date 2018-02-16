package com.silent.fiveghost.guide.utils;

import android.content.Context;
import android.content.SharedPreferences;

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
     */
    public static Object get(String key, Object defaultObj) {
        if (sp != null) {
            if (defaultObj instanceof Boolean) {
                return sp.getBoolean(key, (Boolean) defaultObj);
            } else if (defaultObj instanceof Float) {
                return sp.getFloat(key, (Float) defaultObj);
            } else if (defaultObj instanceof Integer) {
                return sp.getInt(key, (Integer) defaultObj);
            } else if (defaultObj instanceof Long) {
                return sp.getLong(key, (Long) defaultObj);
            } else if (defaultObj instanceof String) {
                return sp.getString(key, (String) defaultObj);
            }
        } else {
            if (defaultObj instanceof Boolean) {
                return spDefault.getBoolean(key, (Boolean) defaultObj);
            } else if (defaultObj instanceof Float) {
                return spDefault.getFloat(key, (Float) defaultObj);
            } else if (defaultObj instanceof Integer) {
                return spDefault.getInt(key, (Integer) defaultObj);
            } else if (defaultObj instanceof Long) {
                return spDefault.getLong(key, (Long) defaultObj);
            } else if (defaultObj instanceof String) {
                return spDefault.getString(key, (String) defaultObj);
            }
        }
        return null;
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
