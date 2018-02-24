package com.silent.fiveghost.guide.ui.test;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.upload.Upload;
import com.silent.fiveghost.guide.event.UpDataEvent;
import com.silent.fiveghost.guide.utils.GsonUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.silent.fiveghost.guide.config.Concat.*;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private EditText access_token_up_test;
    private Button up_test;
    private TextView show;

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

    @Override
    protected void initView() {
        show = findViewById(R.id.show);
        /**************************************************************************************
         * 上传图片
         */
        access_token_up_test = findViewById(R.id.access_token_up_test);
        up_test = findViewById(R.id.up_test);
        up_test.setOnClickListener(this);


    }

    private void show(Object obj) {
        Log.e("TestActivity: ", obj.toString());
        show.setText(GsonUtils.toJson(obj) + "\n\n" + obj.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.up_test:
                上传图片();
                break;
        }
    }

    private void 上传图片() {
        Map<String, RequestBody> files = new HashMap<>();
        boolean equals = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        File file = null;
        if (equals) {
            String s = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shareimg.png";
            file = new File(s);
        }
        files.put("access_token", RequestBody.create(MediaType.parse("text"), "c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk"));
        files.put("file" + 1 + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/png"), file));

        up(new UpDataEvent<BaseBean<Upload>>(UPIMAGE_URL, null, files) {

            @Override
            public void onSuccess(BaseBean<Upload> uploadBaseBean) {
                super.onSuccess(uploadBaseBean);
                show(uploadBaseBean);
            }

            @Override
            public void onSuccessOk(BaseBean<Upload> uploadBaseBean) {
            }

            @Override
            public void onFailure(Throwable e) {
                show(e);
            }
        });
    }
}
