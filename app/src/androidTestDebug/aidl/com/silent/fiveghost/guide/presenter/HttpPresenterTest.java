package com.silent.fiveghost.guide.presenter;

import android.util.Log;

import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.login.LoginBean;
import com.silent.fiveghost.guide.config.Concat;
import com.silent.fiveghost.guide.event.PostDataEvent;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by shuaiJie on 2018/1/30.
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
 * 创建时间：2018/1/30 17:05
 * 电子邮箱：510889082@qq.com
 */
public class HttpPresenterTest {
    HttpPresenter presenter = new HttpPresenter();

    @Test
    public void postData() throws Exception {
        presenter.postData(new PostDataEvent<BaseBean<LoginBean>>(Concat.LOGIN_URL, new HashMap<String, String>()) {
            @Override
            public void onSuccess(BaseBean<LoginBean> loginBeanBaseBean) {
                Log.d("HttpPresenterTest", "loginBeanBaseBean:" + loginBeanBaseBean);
            }

            @Override
            public void onSuccessOk(BaseBean<LoginBean> loginBeanBaseBean) {
                Log.d("HttpPresenterTest", "loginBeanBaseBean:" + loginBeanBaseBean);
            }

            @Override
            public void onFailure(Throwable e) {
                Log.d("HttpPresenterTest", "e:" + e);
            }
        });
    }

    @Test
    public void getData() throws Exception {
    }

}