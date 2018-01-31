package com.silent.fiveghost.guide.ui.re_password;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.BaseBean;
import com.silent.fiveghost.guide.beans.repassword.RePasswordBean;
import com.silent.fiveghost.guide.config.Concat;
import com.silent.fiveghost.guide.event.PostDataEvent;

import java.util.HashMap;

public class RePasswordActivity extends BaseActivity implements View.OnClickListener {

    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private Button find_commit;
    private TextView repwd_getyzm;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_re_password);
    }

    @Override
    protected void run() {
        mInsert_phone = (EditText) findViewById(R.id.mInsert_phone);
        mInsert_yzm = (EditText) findViewById(R.id.mInsert_yzm);
        mInsert_pwd = (EditText) findViewById(R.id.mInsert_pwd);
        find_commit = (Button) findViewById(R.id.find_commit);
        repwd_getyzm = findViewById(R.id.repwd_getyzm);

        find_commit.setOnClickListener(this);
        repwd_getyzm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_commit:
                submit();
                break;
            case R.id.repwd_getyzm:
                String phone = mInsert_phone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // TODO Auto-generated method stub
                        repwd_getyzm.setText(millisUntilFinished / 1000 + "秒后重新发送");
                        repwd_getyzm.setTextColor(Color.BLUE);
                        repwd_getyzm.setEnabled(false);
                    }

                    @Override
                    public void onFinish() {
                        repwd_getyzm.setText("获取验证码");
                        repwd_getyzm.setEnabled(true);
                        repwd_getyzm.setTextColor(0xfffacf20);
                    }
                }.start();
                HashMap<String, String> pamares = new HashMap<>();
                pamares.put("mobile", phone);
                pamares.put("module", "1");
                pamares.put("imei", getPhoneIMEI(RePasswordActivity.this));

                sendPost(new PostDataEvent<BaseBean<Boolean>>(Concat.YZM_URL, pamares) {

                    @Override
                    public void onSuccessOk(BaseBean<Boolean> booleanBaseBean) {
                        Toast.makeText(RePasswordActivity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
                break;
        }
    }

    private void submit() {
        // validate
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
        HashMap<String, String> pamares = new HashMap<>();
        pamares.put("tel", mInsert_phone.getText().toString());
        pamares.put("password", mInsert_pwd.getText().toString());
        pamares.put("code", mInsert_phone.getText().toString());

        sendPost(new PostDataEvent<BaseBean<RePasswordBean>>(Concat.REPASSWORD_URL, pamares) {

            @Override
            public void onSuccessOk(BaseBean<RePasswordBean> rePasswordBeanBaseBean) {
//                startActivity(new Intent(RePasswordActivity.this, LoginActivity.class));
                finish();
            }

            @Override
            public void onFailure(Throwable e) {

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
