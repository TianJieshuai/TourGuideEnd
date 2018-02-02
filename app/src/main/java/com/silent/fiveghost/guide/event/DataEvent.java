package com.silent.fiveghost.guide.event;

import android.widget.Toast;

import com.silent.fiveghost.guide.application.App;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.http.httpapis.CallBack;

import java.util.Map;

/**
 * Created by shuaiJie on 2018/1/29.
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
 * 创建时间：2018/1/29 7:53
 * 电子邮箱：510889082@qq.com
 */

public abstract class DataEvent<T> implements CallBack<T> {
    protected String url;
    protected Map<String, String> map;

    DataEvent(String url, Map<String, String> map) {
        this.url = url;
        this.map = map;
    }

    DataEvent(String url) {
        this(url, null);
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public void onSuccess(T t) {
        if (t instanceof BaseBean) {
            switch (((BaseBean) t).getErrcode()) {
                case "1":
                    onSuccessOk(t);
                    break;
                default:
                    Toast.makeText(App.getContext(), ((BaseBean) t).getErrmsg(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    public abstract void onSuccessOk(T t);
}

