package com.silent.fiveghost.guide.ui.register;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class RegisterActivity extends BaseActivity {


    private EditText mInsert_name;
    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private EditText mYqm;
    private TextView mRegister_xieyi;
    private CheckBox register_agree;
    private Button btn_register;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_register);
        setClearStack(false);
    }

    @Override
    protected void run() {
        mInsert_name = findViewById(R.id.mInsert_name);
        mInsert_phone = findViewById(R.id.mInsert_phone);
        mInsert_yzm = findViewById(R.id.mInsert_yzm);
        mInsert_pwd = findViewById(R.id.mInsert_pwd);
        mYqm = findViewById(R.id.mYqm);
        mRegister_xieyi = findViewById(R.id.mRegister_xieyi);
        register_agree = findViewById(R.id.register_agree);
        btn_register = findViewById(R.id.btn_register);

    }
}