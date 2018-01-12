package com.shuaijie.tourguideend.ui.register;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.utils.Regular;
import com.shuaijie.tourguideend.utils.SPTools;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private Button mBt_Register_Enter;
    private EditText mEt_Register_name;
    private EditText mEt_Register_password;
    private Button mBtn_Register_finish;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_register);
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        mBt_Register_Enter = (Button) findViewById(R.id.mBt_Register_Enter);
        mEt_Register_name = (EditText) findViewById(R.id.mEt_Register_name);
        mEt_Register_password = (EditText) findViewById(R.id.mEt_Register_password);
        mBtn_Register_finish = (Button) findViewById(R.id.mBtn_Register_finish);

        mBt_Register_Enter.setOnClickListener(this);
        mBtn_Register_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBt_Register_Enter:
                submit();
                break;
            case R.id.mBtn_Register_finish:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String name = mEt_Register_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请注册账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = mEt_Register_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if ((Regular.getInstance().isMobileNO(name)) && Regular.getInstance().isPass(password)) {
            SPTools.put(RegisterActivity.this, "name", name);
            SPTools.put(RegisterActivity.this, "pass", password);
            finish();
        } else if (!(Regular.getInstance().isMobileNO(name))) {
            Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
        } else if (!(Regular.getInstance().isPass(password))) {
            Toast.makeText(this, "请输入正确密码，密码长度为6-16位数字和字母的组合", Toast.LENGTH_SHORT).show();
        }

    }
}
