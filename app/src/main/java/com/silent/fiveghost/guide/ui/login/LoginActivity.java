package com.silent.fiveghost.guide.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.login.LoginBean;
import com.silent.fiveghost.guide.config.Concat;
import com.silent.fiveghost.guide.event.PostDataEvent;
import com.silent.fiveghost.guide.ui.home.HomeActivity;
import com.silent.fiveghost.guide.ui.re_password.RePasswordActivity;
import com.silent.fiveghost.guide.ui.register.RegisterActivity;

import java.util.HashMap;

/**
 * 登录ds
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText mLogin_user;
    private EditText mLogin_pwd;
    private Button mLogin;
    private Button mRegister;
    private TextView find_pdw;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_login);
    }

    @Override
    protected void run() {
        mLogin_user = findViewById(R.id.mLogin_user);
        mLogin_pwd = findViewById(R.id.mLogin_pwd);
        mLogin = findViewById(R.id.mLogin);
        mRegister = findViewById(R.id.mRegister);
        find_pdw = findViewById(R.id.find_pdw);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        find_pdw.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mLogin:
                submit();
                break;
            case R.id.mRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.find_pdw:
                startActivity(new Intent(this, RePasswordActivity.class));

                break;
        }
    }
    private void submit() {
        String name = mLogin_user.getText().toString().trim();
        String password = mLogin_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        HashMap<String, String> pamares = new HashMap<>();
        pamares.put("tel", name);
        pamares.put("password", password);
        sendPost(new PostDataEvent<BaseBean<LoginBean>>(Concat.LOGIN_URL, pamares) {
            @Override
            public void onSuccess(BaseBean<LoginBean> loginBeanBaseBean) {
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
            }
        });

    }
}
