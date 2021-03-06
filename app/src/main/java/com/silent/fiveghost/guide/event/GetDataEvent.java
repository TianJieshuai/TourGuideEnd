package com.silent.fiveghost.guide.event;

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

public abstract class GetDataEvent<T> extends DataEvent<T> {

    public GetDataEvent(String url, Map<String, String> map) {
        this(url, map, false);
    }

    public GetDataEvent(String url) {
        this(url, null, false);
    }

    public GetDataEvent(String url, Map<String, String> map, boolean isPreserve) {
        super(url, map, isPreserve);
    }
}
