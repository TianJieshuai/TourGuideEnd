package com.silent.fiveghost.guide.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.event.MessageEvent;

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

public class MessageView extends RelativeLayout {

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
//        addView(inflate);
        messageCount = inflate.findViewById(R.id.messageCount);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sendMessage(MessageEvent event) {
        messageCount.setText(event.messageCount + "");
    }
}
