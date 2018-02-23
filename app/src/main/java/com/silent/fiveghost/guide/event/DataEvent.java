package com.silent.fiveghost.guide.event;

import android.util.Log;
import android.widget.Toast;

import com.silent.fiveghost.guide.application.App;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.http.httpapis.CallBack;
import com.silent.fiveghost.guide.utils.SPTools;

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
    protected boolean isPreserve;

    DataEvent(String url, Map<String, String> map, boolean isPreserve) {
        this.url = url;
        this.map = map;
        this.isPreserve = isPreserve;
    }

    DataEvent(String url, Map<String, String> map) {
        this(url, map, false);
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
                    // 请求成功是否保存数据
                    if (isPreserve)
                        SPTools.put(((BaseBean) t).getData().getClass().getName(), t);
                    onSuccessOk(t);
                    break;
                default:
                    Toast.makeText(App.getContext(), ((BaseBean) t).getErrmsg(), Toast.LENGTH_SHORT).show();
                    Log.e("请求失败", t.toString());
                    break;
            }
        }
    }

    public abstract void onSuccessOk(T t);
}

