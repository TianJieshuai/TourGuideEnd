package com.silent.fiveghost.guide.ui.message;

import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class MessageActivity extends BaseActivity {

    private ImageView message_return;
    private TextView message_xitong;
    private TextView message_Grab_a_single;
    private TextView message_Book_an_order;
    @Override
    protected void init() {
        message_return = (ImageView) findViewById(R.id.message_return);
        message_xitong = (TextView) findViewById(R.id.message_xitong);
        message_Grab_a_single = (TextView) findViewById(R.id.message_Grab_a_single);
        message_Book_an_order = (TextView) findViewById(R.id.message_Book_an_order);
    }

    @Override
    protected void run() {

    }
}
