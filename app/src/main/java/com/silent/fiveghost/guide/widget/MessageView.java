package com.silent.fiveghost.guide.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.guide.BuildConfig;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.event.MessageEvent;
import com.silent.fiveghost.guide.ui.message.MessageActivity;
import com.zhy.autolayout.utils.AutoUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
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
 * 创建时间：2018/2/23 13:53
 * 电子邮箱：510889082@qq.com
 */

public class MessageView extends RelativeLayout implements View.OnClickListener {

    private TextView messageCount;

    public MessageView(Context context) {
        this(context, null, 0);
    }

    public MessageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = inflate(getContext(), R.layout.message_view, this);
        AutoUtils.auto(inflate);
        messageCount = inflate.findViewById(R.id.messageCount);
        EventBus.getDefault().register(this);
        setOnClickListener(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void sendMessage(MessageEvent event) {
        if (BuildConfig.DEBUG) Log.d("接收到消息数量", event.toString());
        if (event.messageCount < 100) {
            messageCount.setText(event.messageCount + "");
        } else {
            messageCount.setText("99+");
        }
    }

    @Override
    public void onClick(View v) {
        getContext().startActivity(new Intent(getContext(), MessageActivity.class));
    }
}
