package com.silent.fiveghost.guide.event;

import java.util.List;

import okhttp3.MultipartBody;

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
    private List<MultipartBody.Part> files;

    public UpDataEvent(String url, String access_token, List<MultipartBody.Part> files) {
        this(url, access_token, files, false);
    }

    public UpDataEvent(String url, String access_token, List<MultipartBody.Part> files, boolean isPreserve) {
        super(url, null, isPreserve);
        super.url += access_token;
        this.files = files;
    }

    public void setFiles(List<MultipartBody.Part> files) {
        this.files = files;
    }

    public List<MultipartBody.Part> getFiles() {
        return files;
    }
}
