package com.shuaijie.tourguideend.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.ui.main.MainActivity;
import com.shuaijie.tourguideend.ui.register.RegisterActivity;

/**
 * 登录ds
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private SharedPreferences sp;
    private EditText et_name;
    private EditText et_password;
    private Button mBt_register;
    private Button mBt_Login;
    private CheckBox mCb_remember;
    private CheckBox mCb_automatic_logon;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_login);
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_password = (EditText) findViewById(R.id.et_password);
        mBt_register = (Button) findViewById(R.id.mBt_register);
        mBt_Login = (Button) findViewById(R.id.mBt_Login);

        mBt_register.setOnClickListener(this);
        mBt_Login.setOnClickListener(this);
        mCb_remember = (CheckBox) findViewById(R.id.mCb_remember);
        mCb_remember.setOnClickListener(this);
        mCb_automatic_logon = (CheckBox) findViewById(R.id.mCb_automatic_logon);
        mCb_automatic_logon.setOnClickListener(this);
        sp = this.getSharedPreferences("userInfo",
                Context.MODE_PRIVATE);
        if (sp.getBoolean("ISCHECK", false)) {
            //设置默认是记录密码状态
            mCb_remember.setChecked(true);
            et_name.setText(sp.getString("USER_NAME", ""));
            et_password.setText(sp.getString("PASSWORD", ""));
            //判断自动登陆多选框状态
            if (sp.getBoolean("AUTO_ISCHECK", false)) {
                //设置默认是自动登录状态
                mCb_automatic_logon.setChecked(true);
                //跳转界面
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBt_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.mBt_Login:
                submit();
                break;
            case R.id.mCb_remember:
                sp.edit().putBoolean("ISCHECK", mCb_remember.isSelected()).commit();
                break;
            case R.id.mCb_automatic_logon:
                sp.edit().putBoolean("AUTO_ISCHECK", mCb_automatic_logon.isSelected()).commit();
                break;
        }
    }

    private void submit() {
        // validate
        String name = et_name.getText().toString().trim();
        String password = et_password.getText().toString().trim();
/*        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        //   SPUtils.get(LoginActivity.this, "name",1)
        String name1 = String.valueOf(SPTools.get(LoginActivity.this, "name", "1"));
        String pass1 = String.valueOf(SPTools.get(LoginActivity.this, "pass", "1"));
        if (name.equals(name1) && password.equals(pass1)) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else if (!name.equals(name1)) {
            Toast.makeText(this, "未注册账号", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "账号或密码不正确", Toast.LENGTH_SHORT).show();
        }*/
        if (mCb_remember.isChecked()) {
            //记住用户名、密码、
/*            SharedPreferences.Editor editor = sp.edit();
            editor.putString("USER_NAME", name1);
            editor.putString("PASSWORD", pass1);
            editor.commit();*/
            //跳转界面
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}
