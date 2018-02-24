package com.silent.fiveghost.guide.ui.test;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.upload.Upload;
import com.silent.fiveghost.guide.event.PostDataEvent;
import com.silent.fiveghost.guide.event.UpDataEvent;
import com.silent.fiveghost.guide.utils.GsonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.silent.fiveghost.guide.config.Concat.CLEAN_URL;
import static com.silent.fiveghost.guide.config.Concat.UPIMAGE_URL;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private static final String access_token = "c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk";
    private static final String UPIMAGE_URLs = UPIMAGE_URL;
    private EditText access_token_up_test;
    private Button up_test;
    private EditText show;
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
    private View button_show;
    private PopupWindow window;

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
        button_show = findViewById(R.id.button_show);
        button_show.setOnClickListener(this);
        initPopup();
        show.setOnClickListener(this);
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

    public void initPopup() {
        window = new PopupWindow(LayoutInflater.from(this).inflate(R.layout.test_popup, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        show = window.getContentView().findViewById(R.id.show);
        window.setBackgroundDrawable(new ColorDrawable(0x00000000));
        window.setFocusable(true);
    }

    private void show(Object obj) {
        Log.e("TestActivity: ", obj.toString());
        if (obj instanceof BaseBean) {
            show.setText("j s o n : " + GsonUtils.toJson(obj) +
                    "\n\n toString: " + obj.toString() +
                    "\n\n c o d e : " + ((BaseBean) obj).getErrcode() +
                    "\n\n m  s  g : " + ((BaseBean) obj).getErrmsg());
        } else {
            show.setText(GsonUtils.toJson(obj) + "\n\n" + obj.toString());
        }
        onClick(show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show:
            case R.id.button_show:
                if (!window.isShowing()) {
                    window.showAtLocation(base, Gravity.CENTER, 0, 0);
                } else {
                    window.dismiss();
                }
                break;
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
        String mobile = clean_mobile_test.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            Toast.makeText(this, "mobile不能为空", Toast.LENGTH_SHORT).show();
            show("mobile不能为空");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        sendPost(new PostDataEvent<BaseBean>(CLEAN_URL, map) {
            @Override
            public void onSuccess(BaseBean booleanBaseBean) {
                show(booleanBaseBean);
            }

            @Override
            public void onSuccessOk(BaseBean booleanBaseBean) {

            }

            @Override
            public void onFailure(Throwable e) {
                show(e);
            }
        });
    }

    private void 上传图片() {
        List<MultipartBody.Part> files = new ArrayList<>();
        boolean equals = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        File file = null;
        if (equals) {
            String s = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shareimg.png";
            file = new File(s);
        }
        files.add(MultipartBody.Part.createFormData("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file)));

        up(new UpDataEvent<BaseBean<Upload>>(UPIMAGE_URL, access_token, files) {

            @Override
            public void onSuccess(BaseBean<Upload> uploadBaseBean) {
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
