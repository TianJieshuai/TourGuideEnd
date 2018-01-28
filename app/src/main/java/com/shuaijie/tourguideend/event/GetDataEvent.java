package com.shuaijie.tourguideend.event;

import com.shuaijie.tourguideend.http.httpapis.CallBack;

import java.util.Map;

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
 * 创建时间：2018/1/28 13:14
 * 电子邮箱：510889082@qq.com
 */

public class GetDataEvent {
    private String url;
    private Map<String, String> map;
    private CallBack callBack;

    public GetDataEvent(String url, CallBack callBack) {
        this.url = url;
        this.callBack = callBack;
    }

    public GetDataEvent(String url, Map<String, String> map, CallBack callBack) {
        this.url = url;
        this.map = map;
        this.callBack = callBack;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public CallBack getCallBack() {
        return callBack;
    }
}
