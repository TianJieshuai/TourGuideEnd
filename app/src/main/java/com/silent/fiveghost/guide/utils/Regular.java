package com.silent.fiveghost.guide.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ----------------Dragon be here!------------------
 * 　   　　┏┓　　　┏┓
 * 　   　┏┛┻━━━┛┻┓
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　━　　　┃
 * 　   　┃　┳┛　┗┳　┃
 * 　   　┃　　　　　　　┃
 * 　   　┃　　　┻　　　┃
 * 　   　┃　　　　　　　┃
 * 　   　┗━┓　　　┏━┛
 * 　   　　　┃　　　┃神兽保佑
 * 　   　　　┃　　　┃代码无BUG！
 * 　   　　　┃　　　┗━━━┓
 * 　   　┃　        　 ┣┓
 * 　   　　　┃          　 ┏┛
 * 　   　　　┗┓┓┏━┳┓┏┛
 * 　   　　　　┃┫┫　┃┫┫
 * 　   　　　　┗┻┛　┗┻┛
 * ━━━━━━━━神兽出没━━━━━━━━
 * <p>
 * Created by 习爸爸 on 2017/12/25 .
 */

public class Regular {
    private static Regular regular;

    private Regular() {

    }

    public static synchronized Regular getInstance() {
        if (regular == null)
            regular = new Regular();
        return regular;
    }

    //判断手机格式是否正确
    public boolean isMobileNO(String mobiles) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    //判断email格式是否正确
    public boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    public boolean isPass(String pass) {
        String str = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(pass);

        return m.matches();
    }
}
