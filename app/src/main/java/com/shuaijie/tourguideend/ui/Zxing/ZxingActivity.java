package com.shuaijie.tourguideend.ui.Zxing;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.shuaijie.tourguideend.R;
import com.shuaijie.tourguideend.base.activity.BaseActivity;
import com.shuaijie.tourguideend.ui.version.VersionActivity;
import com.shuaijie.tourguideend.utils.ZxingUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ZxingActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_test;
    private ImageView pic_test;
    private Button btn_test;
    private Button btn_test2;
    private Button btn_test3;
    private Button btn_test4;
    private Button btn_test5;
    private Button btn_test6;
    private Button btn_test7;
    private Button btn_test8;
    private Button btn_test9;
    private Button btn_test0;
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(ZxingActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(ZxingActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(ZxingActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void init() {
        addBodyView(R.layout.activity_zxing);
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
    }

    @Override
    protected void run() {

    }

    protected void initView() {
        tv_test = (TextView) findViewById(R.id.tv_test);
        pic_test = (ImageView) findViewById(R.id.pic_test);
        btn_test = (Button) findViewById(R.id.btn_test);
        btn_test2 = (Button) findViewById(R.id.btn_test2);

        btn_test.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
        btn_test3 = (Button) findViewById(R.id.btn_test3);
        btn_test3.setOnClickListener(this);
        btn_test4 = (Button) findViewById(R.id.btn_test4);
        btn_test4.setOnClickListener(this);
        btn_test5 = (Button) findViewById(R.id.btn_test5);
        btn_test5.setOnClickListener(this);
        btn_test6 = (Button) findViewById(R.id.btn_test6);
        btn_test6.setOnClickListener(this);
        btn_test7 = (Button) findViewById(R.id.btn_test7);
        btn_test7.setOnClickListener(this);
        btn_test8 = (Button) findViewById(R.id.btn_test8);
        btn_test8.setOnClickListener(this);
        btn_test9 = (Button) findViewById(R.id.btn_test9);
        btn_test9.setOnClickListener(this);
        btn_test0 = (Button) findViewById(R.id.btn_test0);
        btn_test0.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //生成二维码
            case R.id.btn_test:
                Bitmap bitmap = ZxingUtils.createBitmap("I like you,But just like you!!");
                pic_test.setImageBitmap(bitmap);
                break;
            //扫描二维码
            case R.id.btn_test2:
                new IntentIntegrator(this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
                        .initiateScan(); // 初始化扫描
                break;
            //获取缓存
            case R.id.btn_test3:

                break;
            //动态权限
            case R.id.btn_test4:
                onCallPermission();
                break;
            //加密
            case R.id.btn_test5:
                String qweewq = passwordMD5("qweewq");
                Toast.makeText(this, qweewq, Toast.LENGTH_LONG).show();
                break;
            //登陆分享
            case R.id.btn_test6:
                new ShareAction(ZxingActivity.this)
                        .withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .open();
                break;
            //推送
            case R.id.btn_test7:
                CrashReport.testJavaCrash();
                break;
            //数据统计
            case R.id.btn_test8:
                break;
            //热修复
            case R.id.btn_test9:
                break;
            //版本迭代
            case R.id.btn_test0:
                startActivity(new Intent(ZxingActivity.this, VersionActivity.class));
                break;
        }
    }

    public static String passwordMD5(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            //1.获取数据摘要器
            //arg0 : 加密的方式
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2.将一个byte数组进行加密,返回的是一个加密过的byte数组,二进制的哈希计算,md5加密的第一步
            byte[] digest = messageDigest.digest(password.getBytes());
            //3.遍历byte数组
            for (int i = 0; i < digest.length; i++) {
                //4.MD5加密
                //byte值    -128-127
                int result = digest[i] & 0xff;
                //将得到int类型转化成16进制字符串
                //String hexString = Integer.toHexString(result)+1;//不规则加密,加盐
                String hexString = Integer.toHexString(result);
                if (hexString.length() < 2) {
//                  System.out.print("0");
                    sb.append("0");
                }
                System.out.print(hexString);
                //e10adc3949ba59abbe56e057f20f883e
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //找不到加密方式的异常
            e.printStackTrace();
        }
        return null;
    }

    private void onCallPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//判断当前系统的SDK版本是否大于23
            //如果当前申请的权限没有授权
            if (!(checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                //第一次请求权限的时候返回false,第二次shouldShowRequestPermissionRationale返回true
                if (shouldShowRequestPermissionRationale(Manifest.permission.RECORD_AUDIO)) {
                    Toast.makeText(this, "Please grant the permission this time", Toast.LENGTH_LONG).show();
                }
                //请求权限
                requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, 1);
            } else {//已经授权了就走这条分支
                Log.i("wei", "onClick granted");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (permissions[0].equals(Manifest.permission.RECORD_AUDIO) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //  listernUi();//得到权限之后去做的业务
            } else {//没有获得到权限
                Toast.makeText(this, "你不给权限我就不好干事了啦", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
// 通过 onActivityResult的方法获取扫描回来的值
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(this, "内容为空", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "扫描成功", Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String ScanResult = intentResult.getContents();
                tv_test.setText(ScanResult);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
