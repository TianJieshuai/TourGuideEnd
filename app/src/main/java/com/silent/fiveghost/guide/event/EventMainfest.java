package com.silent.fiveghost.guide.event;

import com.silent.fiveghost.guide.presenter.HttpPresenter;

import org.greenrobot.eventbus.EventBus;

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
 * 创建时间：2018/1/28 8:51
 * 电子邮箱：510889082@qq.com
 */

public class EventMainfest {
    // 事件清单
    public static void init() {
        // 注册网络桥梁
        EventBus.getDefault().register(new HttpPresenter());
        // 注册数据存储桥梁
        // EventBus.getDefault().register(null);
    }
}
