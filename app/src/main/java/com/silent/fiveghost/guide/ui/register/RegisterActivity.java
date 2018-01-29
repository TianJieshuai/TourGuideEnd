package com.silent.fiveghost.guide.ui.register;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private ImageView m_insert_name_icon;
    private ImageView m_insert_phone_icon;
    private ImageView m_insert_yzm_icon;
    private ImageView m_insert_pwd_icon;
    private EditText mInsert_name;
    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private EditText mYqm;
    private CheckBox register_agree;
    private TextView mRegister_xieyi;
    private LinearLayout mLinear_xieyi;
    private Button btn_register;

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
        m_insert_name_icon = (ImageView) findViewById(R.id.m_insert_name_icon);
        m_insert_name_icon.setOnClickListener(this);
        m_insert_phone_icon = (ImageView) findViewById(R.id.m_insert_phone_icon);
        m_insert_phone_icon.setOnClickListener(this);
        m_insert_yzm_icon = (ImageView) findViewById(R.id.m_insert_yzm_icon);
        m_insert_yzm_icon.setOnClickListener(this);
        m_insert_pwd_icon = (ImageView) findViewById(R.id.m_insert_pwd_icon);
        m_insert_pwd_icon.setOnClickListener(this);
        mInsert_name = (EditText) findViewById(R.id.mInsert_name);
        mInsert_name.setOnClickListener(this);
        mInsert_phone = (EditText) findViewById(R.id.mInsert_phone);
        mInsert_phone.setOnClickListener(this);
        mInsert_yzm = (EditText) findViewById(R.id.mInsert_yzm);
        mInsert_yzm.setOnClickListener(this);
        mInsert_pwd = (EditText) findViewById(R.id.mInsert_pwd);
        mInsert_pwd.setOnClickListener(this);
        mYqm = (EditText) findViewById(R.id.mYqm);
        mYqm.setOnClickListener(this);
        register_agree = (CheckBox) findViewById(R.id.register_agree);
        register_agree.setOnClickListener(this);
        mRegister_xieyi = (TextView) findViewById(R.id.mRegister_xieyi);
        mRegister_xieyi.setOnClickListener(this);
        mLinear_xieyi = (LinearLayout) findViewById(R.id.mLinear_xieyi);
        mLinear_xieyi.setOnClickListener(this);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:

                break;
        }
    }

    private void submit() {
        // validate
        String name = mInsert_name.getText().toString().trim();
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


    }
}