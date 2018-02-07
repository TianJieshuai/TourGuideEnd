package com.silent.fiveghost.guide.ui.personalcenter;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;

public class MyRouteActivity extends BaseActivity implements View.OnClickListener {


    private RelativeLayout mRoute_RelativeLayout;
    private Button mBtn_Release;
    private TextView add_jia;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_my_route);
        setSteepStatusBar(true);
    }

    @Override
    protected void run() {

    }

    @Override
    protected void initView() {
         mRoute_RelativeLayout =(RelativeLayout) findViewById(R.id.mRoute_RelativeLayout);
        add_jia =(TextView) findViewById(R.id.add_jia);
        mBtn_Release =(Button) findViewById(R.id.mBtn_Release);
        mBtn_Release.setOnClickListener(this);
        add_jia.setOnClickListener(this);
        mRoute_RelativeLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mBtn_Release:
                startActivity(new Intent(this,MyRouteDetailsActivity.class));

                break;
            case R.id.mRoute_RelativeLayout:
                startActivity(new Intent(this,ReleaseRouteActivity.class));
                break;
            case R.id.add_jia:
                startActivity(new Intent(this,AddActivity.class));
                break;
        }
    }
}
