package com.silent.fiveghost.guide.ui.register;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.register.RegisterSuccessBean;
import com.silent.fiveghost.guide.config.Concat;
import com.silent.fiveghost.guide.event.PostDataEvent;
import com.silent.fiveghost.guide.ui.login.LoginActivity;
import com.silent.fiveghost.guide.utils.Join;

import java.util.HashMap;

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
        mYqm = (EditText) findViewById(R.id.mYqm);
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
                String phone = mInsert_phone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                        find_getyzm.setText( millisUntilFinished / 1000 + "秒后重新发送");
                        find_getyzm.setTextColor(Color.BLUE);
                        find_getyzm.setEnabled(false);
                    }

                    @Override
                    public void onFinish() {
                        find_getyzm.setText("获取验证码");
                        find_getyzm.setEnabled(true);
                        find_getyzm.setTextColor(0xfffacf20);
                    }
                }.start();
                HashMap<String, String> pamares = new HashMap<>();
                pamares.put("mobile", phone);
                pamares.put("module", "1");
                pamares.put("imei", getPhoneIMEI(RegisterActivity.this));

                sendPost(new PostDataEvent<BaseBean<Boolean>>(Concat.YZM_URL, pamares) {

                    @Override
                    public void onSuccessOk(BaseBean<Boolean> booleanBaseBean) {
                        Toast.makeText(RegisterActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
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
        // TODO validate success, do something
        if (Join.isMobile(phone) || Join.isPass(pwd)) {
            Toast.makeText(this, "正确", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        } else {

            Toast.makeText(this, "手机号或密码不正确", Toast.LENGTH_SHORT).show();
        }
        HashMap<String, String> pamares = new HashMap<>();
        pamares.put("tel", mInsert_phone.getText().toString());
        pamares.put("password", mInsert_pwd.getText().toString());
        pamares.put("category", "1");
        pamares.put("code", mInsert_phone.getText().toString());
        sendPost(new PostDataEvent<BaseBean<RegisterSuccessBean>>(Concat.REGISTER_URL, pamares) {

            @Override
            public void onSuccessOk(BaseBean<RegisterSuccessBean> registerSuccessBeanBaseBean) {
//                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onFailure(Throwable e) {
                Toast.makeText(RegisterActivity.this, "网络故障", Toast.LENGTH_SHORT).show();
            }
        });

        


    }

    //获取IMEI
    public static String getPhoneIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonyManager != null) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "cuo";
            }
            return telephonyManager.getDeviceId();
        } else {
            return "cuo";
        }
    }

}