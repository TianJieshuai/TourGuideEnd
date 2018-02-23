package com.silent.fiveghost.guide.ui.test;

import android.os.Bundle;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
    }

    @Override
    protected void init() {
        setSteepStatusBar(false);
        addBodyView(R.layout.activity_test);
    }

    @Override
    protected void run() {

    }
}
