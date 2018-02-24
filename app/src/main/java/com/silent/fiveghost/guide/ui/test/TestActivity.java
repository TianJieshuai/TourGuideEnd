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

import static com.silent.fiveghost.guide.config.Concat.UPIMAGE_URL;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private static final String access_token = "c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk";
    private EditText access_token_up_test;
    private Button up_test;
    private TextView show;
    private EditText clean_mobile_test;
    private Button clean_test;
    private EditText send_mobile_test;
    private EditText send_module_test;
    private EditText send_imei_test;
    private Button send_test;
    private EditText verify_mobile_test;
    private EditText verify_module_test;
    private EditText verify_code_test;
    private Button verify_test;
    private EditText access_token_test;
    private Button info_test;
    private EditText tel_signup_test;
    private EditText password_signup_test;
    private EditText category_signup_test;
    private EditText code_signup_test;
    private Button signup_test;
    private EditText tel_login_test;
    private EditText password_login_test;
    private Button login_test;
    private EditText tel_reset_password_test;
    private EditText password_reset_password_test;
    private EditText code_reset_password_test;
    private Button reset_password_test;
    private EditText access_token_favourite_test;
    private Button favourite_test;
    private EditText access_token_favourite_del_test;
    private EditText ids_favourite_del_test;
    private Button favourite_del_test;
    private EditText access_token_favourite_add_test;
    private EditText route_id_favourite_add_test;
    private Button favourite_add_test;

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
        /* *************************************************************************************
         * 上传图片
         */
        access_token_up_test = findViewById(R.id.access_token_up_test);
        up_test = findViewById(R.id.up_test);
        up_test.setOnClickListener(this);

        /* *************************************************************************************
         * 通用验证码验证清除接口
         */
        clean_mobile_test = (EditText) findViewById(R.id.clean_mobile_test);
        clean_test = (Button) findViewById(R.id.clean_test);
        clean_test.setOnClickListener(this);

        /* *************************************************************************************
         * 通用验证码接口
         */
        send_mobile_test = (EditText) findViewById(R.id.send_mobile_test);
        send_module_test = (EditText) findViewById(R.id.send_module_test);
        send_imei_test = (EditText) findViewById(R.id.send_imei_test);
        send_test = (Button) findViewById(R.id.send_test);
        send_test.setOnClickListener(this);

        /* *************************************************************************************
         * 通用验证码验证接口
         */
        verify_mobile_test = (EditText) findViewById(R.id.verify_mobile_test);
        verify_module_test = (EditText) findViewById(R.id.verify_module_test);
        verify_code_test = (EditText) findViewById(R.id.verify_code_test);
        verify_test = (Button) findViewById(R.id.verify_test);
        verify_test.setOnClickListener(this);

        /* *************************************************************************************
         * 用户基本信息接口
         */
        access_token_test = (EditText) findViewById(R.id.access_token_test);
        info_test = (Button) findViewById(R.id.info_test);
        info_test.setOnClickListener(this);

        /* *************************************************************************************
         * 注册接口
         */
        tel_signup_test = (EditText) findViewById(R.id.tel_signup_test);
        password_signup_test = (EditText) findViewById(R.id.password_signup_test);
        category_signup_test = (EditText) findViewById(R.id.category_signup_test);
        code_signup_test = (EditText) findViewById(R.id.code_signup_test);
        signup_test = (Button) findViewById(R.id.signup_test);
        signup_test.setOnClickListener(this);

        /* *************************************************************************************
         * 登录接口
         */
        tel_login_test = (EditText) findViewById(R.id.tel_login_test);
        password_login_test = (EditText) findViewById(R.id.password_login_test);
        login_test = (Button) findViewById(R.id.login_test);
        login_test.setOnClickListener(this);

        /* *************************************************************************************
         * 忘记密码接口
         */
        tel_reset_password_test = (EditText) findViewById(R.id.tel_reset_password_test);
        password_reset_password_test = (EditText) findViewById(R.id.password_reset_password_test);
        code_reset_password_test = (EditText) findViewById(R.id.code_reset_password_test);
        reset_password_test = (Button) findViewById(R.id.reset_password_test);
        reset_password_test.setOnClickListener(this);

        /* *************************************************************************************
         * 旅游线路收藏列表
         */
        access_token_favourite_test = (EditText) findViewById(R.id.access_token_favourite_test);
        favourite_test = (Button) findViewById(R.id.favourite_test);
        favourite_test.setOnClickListener(this);

        /* *************************************************************************************
         * 旅游线路取消收藏
         */
        access_token_favourite_del_test = (EditText) findViewById(R.id.access_token_favourite_del_test);
        ids_favourite_del_test = (EditText) findViewById(R.id.ids_favourite_del_test);
        favourite_del_test = (Button) findViewById(R.id.favourite_del_test);
        favourite_del_test.setOnClickListener(this);

        /* *************************************************************************************
         * 旅游线路添加收藏
         */
        access_token_favourite_add_test = (EditText) findViewById(R.id.access_token_favourite_add_test);
        route_id_favourite_add_test = (EditText) findViewById(R.id.route_id_favourite_add_test);
        favourite_add_test = (Button) findViewById(R.id.favourite_add_test);
        favourite_add_test.setOnClickListener(this);
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
            case R.id.clean_test:
                通用验证码验证清除接口();
                break;
            case R.id.send_test:
                通用验证码接口();
                break;
            case R.id.verify_test:
                通用验证码验证接口();
                break;
            case R.id.info_test:
                用户基本信息接口();
                break;
            case R.id.signup_test:
                注册接口();
                break;
            case R.id.login_test:
                登录接口();
                break;
            case R.id.reset_password_test:
                找回密码();
                break;
            case R.id.favourite_test:
                旅游线路收藏列表();
                break;
            case R.id.favourite_del_test:
                旅游线路取消收藏();
                break;
            case R.id.favourite_add_test:
                旅游线路添加收藏();
                break;
        }
    }

    private void 旅游线路添加收藏() {

    }

    private void 旅游线路取消收藏() {

    }

    private void 旅游线路收藏列表() {

    }

    private void 找回密码() {

    }

    private void 登录接口() {

    }

    private void 注册接口() {

    }

    private void 用户基本信息接口() {

    }

    private void 通用验证码验证接口() {

    }

    private void 通用验证码接口() {

    }

    private void 通用验证码验证清除接口() {

    }

    private void 上传图片() {
        Map<String, RequestBody> files = new HashMap<>();
        boolean equals = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        File file = null;
        if (equals) {
            String s = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shareimg.png";
            file = new File(s);
        }
        files.put("access_token", RequestBody.create(MediaType.parse("text"), access_token));
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
