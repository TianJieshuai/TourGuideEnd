package com.silent.fiveghost.guide.ui.re_password;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class RePasswordActivity extends BaseActivity {

    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private Button find_commit;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_re_password);
    }

    @Override
    protected void run() {
        mInsert_phone = findViewById(R.id.mInsert_phone);
        mInsert_yzm = findViewById(R.id.mInsert_yzm);
        mInsert_pwd = findViewById(R.id.mInsert_pwd);
        find_commit = findViewById(R.id.find_commit);


    }

}
