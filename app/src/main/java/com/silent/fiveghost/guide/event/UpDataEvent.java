package com.silent.fiveghost.guide.event;

import java.util.Map;

import okhttp3.RequestBody;

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

public abstract class UpDataEvent<T> extends DataEvent<T> {
    private Map<String, RequestBody> files;

    public UpDataEvent(String url, Map<String, String> map, Map<String, RequestBody> files) {
        this(url, map, files, false);
    }

    public UpDataEvent(String url, Map<String, String> map, Map<String, RequestBody> files, boolean isPreserve) {
        super(url, map, isPreserve);
        this.files = files;
    }

    public void setFiles(Map<String, RequestBody> files) {
        this.files = files;
    }

    public Map<String, RequestBody> getFiles() {
        return files;
    }
}
