package com.shuaijie.tourguideend.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.beans.BaseBean;
import com.shuaijie.tourguideend.beans.login.LoginBean;
import com.shuaijie.tourguideend.config.Concat;
import com.shuaijie.tourguideend.event.DataEvent;
import com.shuaijie.tourguideend.http.httpapis.CallBack;
import com.shuaijie.tourguideend.ui.home.HomeActivity;
import com.shuaijie.tourguideend.ui.register.RegisterActivity;
import com.umeng.message.lib.BuildConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

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
        mCb_remember = (CheckBox) findViewById(R.id.mCb_remember);
        mCb_automatic_logon = (CheckBox) findViewById(R.id.mCb_automatic_logon);

        mBt_Login.setOnClickListener(this);
        mBt_register.setOnClickListener(this);
        mCb_remember.setOnClickListener(this);
        mCb_automatic_logon.setOnClickListener(this);
        sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

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
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
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
        String name = et_name.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, String> pamares = new HashMap<>();
        pamares.put("tel", name);
        pamares.put("password", password);
        EventBus.getDefault().post(new DataEvent(Concat.LOGIN_URL, pamares, new CallBack<BaseBean<LoginBean>>() {
            @Override
            public void onSuccess(BaseBean<LoginBean> loginBeanBaseBean) {
                if (BuildConfig.DEBUG) Log.d("LoginActivity", loginBeanBaseBean.toString());
                switch (loginBeanBaseBean.getErrcode()) {
                    case "1":
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                        break;
                    case "422":
                        Toast.makeText(LoginActivity.this, loginBeanBaseBean.getErrmsg(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onFailure(Throwable e) {
                if (BuildConfig.DEBUG) Log.d("LoginActivity", e.toString());
            }
        }));

    }
}
