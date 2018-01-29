package com.silent.fiveghost.guide.ui.register;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.ui.login.LoginActivity;
import com.silent.fiveghost.guide.utils.Join;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText mInsert_name;
    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private EditText mYqm;
    private CheckBox register_agree;
    private TextView mRegister_xieyi;
    private TextView find_getyzm;
    private Button btn_register;
    private String name;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_register);
        setClearStack(false);
    }

    @Override
    protected void run() {


    }

    @Override
    protected void initView() {
        mInsert_name = (EditText) findViewById(R.id.mInsert_name);
        mInsert_phone = (EditText) findViewById(R.id.mInsert_phone);
        mInsert_yzm = (EditText) findViewById(R.id.mInsert_yzm);
        mInsert_pwd = (EditText) findViewById(R.id.mInsert_pwd);
        find_getyzm = (TextView) findViewById(R.id.find_getyzm);
        mYqm = (EditText)findViewById(R.id.mYqm);
        find_getyzm.setOnClickListener(this);
        register_agree = (CheckBox) findViewById(R.id.register_agree);
        mRegister_xieyi = (TextView) findViewById(R.id.mRegister_xieyi);
        mRegister_xieyi.setOnClickListener(this);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                submit();
                break;
            case R.id.find_getyzm:

                break;
            case R.id.mRegister_xieyi:

                break;
        }
    }

    private void submit() {
        // validate
        name = mInsert_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "name不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String phone = mInsert_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "phone不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String yzm = mInsert_yzm.getText().toString().trim();
        if (TextUtils.isEmpty(yzm)) {
            Toast.makeText(this, "yzm不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = mInsert_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "pwd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String mYqmString = mYqm.getText().toString().trim();
        if (TextUtils.isEmpty(mYqmString)) {
            Toast.makeText(this, "mYqmString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        if (Join.isMobile(phone) || Join.isPass(pwd)) {
            Toast.makeText(this, "正确", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,LoginActivity.class));
        } else {

            Toast.makeText(this, "手机号或密码不正确", Toast.LENGTH_SHORT).show();
        }



    }

}