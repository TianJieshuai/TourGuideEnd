package com.silent.fiveghost.guide.ui.order;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mapapi.map.MapView;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.DateRecAdapter;
import com.silent.fiveghost.guide.adapter.Lv_Item_TouristEvaluation_Adapter;
import com.silent.fiveghost.guide.base.activity.BaseActivity;
import com.silent.fiveghost.guide.beans.DateBeans;
import com.silent.fiveghost.guide.beans.TouristEvaluationBean;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;

public class OrderDetailsActivity extends BaseActivity {

    private ListView lv_pingjia_youke;
    private ImageView iv_back;
    private RelativeLayout rl;
    private ImageView iv_iamge_big;
    private TextView tv_content;
    private TextView tv_renminbi_chengren;
    private TextView tv_renminbi_ertong;
    private TextView tv_one_miaoshu;
    private TextView tv_two_mianshu;
    private TextView tv_three_mianshu;
    private TextView tv_four_mianshu;
    private TextView tv_five_mianshu;
    private TextView tv_tuanduichaoguoshiren;
    private TextView tv_lijianyiqianyuan;
    private ImageView iv_gengguoyouhui;
    private RecyclerView rv_riqi;
    private TextView tv_gengduoriqi;
    private RelativeLayout rl_gengduoriqi;
    private MapView mv_ditu;
    private ImageView iv_touxiang_one;
    private ImageView iv_touxiang_two;
    private ImageView iv_touxiang_three;
    private ImageView iv_touxiang_four;
    private TextView tv_ren_num;
    private LinearLayout ll_baoming;
    private TextView tv_pingfen_num;
//    private MyLocationStyle myLocationStyle;
//    private AMap aMap;
//    //获取经度
//    private double longitude;
//    //获取纬度
//    private double latitude;
    /**
     * 声明定位回调监听器
     */
//    public AMapLocationListener mLocationListener = new AMapLocationListener() {
//        @Override
//        public void onLocationChanged(AMapLocation amapLocation) {
//            if (amapLocation != null) {
//                if (amapLocation.getErrorCode() == 0) {
//                    //定位成功回调信息，设置相关消息
//                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                    amapLocation.getLatitude();//获取纬度
//                    amapLocation.getLongitude();//获取经度
//                    amapLocation.getAccuracy();//获取精度信息
//                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date date = new Date(amapLocation.getTime());
//                    df.format(date);//定位时间
//                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                    amapLocation.getCountry();//国家信息
//                    amapLocation.getProvince();//省信息
//                    amapLocation.getCity();//城市信息
//                    amapLocation.getDistrict();//城区信息
//                    amapLocation.getStreet();//街道信息
//                    amapLocation.getStreetNum();//街道门牌号信息
//                    amapLocation.getCityCode();//城市编码
//                    amapLocation.getAdCode();//地区编码
//                    amapLocation.getAoiName();//获取当前定位点的AOI信息
//                    latitude = amapLocation.getLatitude();
//                    longitude = amapLocation.getLongitude();
//                    Log.v("pcw", "lat : " + latitude + " lon : " + longitude);
//
//                } else {
//                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
//                    Log.e("AmapError", "location Error, ErrCode:"
//                            + amapLocation.getErrorCode() + ", errInfo:"
//                            + amapLocation.getErrorInfo());
//                }
//            }
//        }
//    };
    private ImageView iv_ditu;
    private ImageView left_icon;
    private AutoLinearLayout mleft_return;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void init() {
        addBodyView(R.layout.activity_orderdetails);
    }

    @Override
    protected void run() {
        lv_pingjia_youke = (ListView) findViewById(R.id.lv_pingjia_youke);
//        iv_back = (ImageView) findViewById(R.id.iv_back);
        rl = (RelativeLayout) findViewById(R.id.rl);
        iv_iamge_big = (ImageView) findViewById(R.id.iv_iamge_big);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_renminbi_chengren = (TextView) findViewById(R.id.tv_renminbi_chengren);
        tv_renminbi_ertong = (TextView) findViewById(R.id.tv_renminbi_ertong);
        tv_one_miaoshu = (TextView) findViewById(R.id.tv_one_miaoshu);
        tv_two_mianshu = (TextView) findViewById(R.id.tv_two_mianshu);
        tv_three_mianshu = (TextView) findViewById(R.id.tv_three_mianshu);
        tv_four_mianshu = (TextView) findViewById(R.id.tv_four_mianshu);
        tv_five_mianshu = (TextView) findViewById(R.id.tv_five_mianshu);
        tv_tuanduichaoguoshiren = (TextView) findViewById(R.id.tv_tuanduichaoguoshiren);
        tv_lijianyiqianyuan = (TextView) findViewById(R.id.tv_lijianyiqianyuan);
        iv_gengguoyouhui = (ImageView) findViewById(R.id.iv_gengguoyouhui);
        rv_riqi = (RecyclerView) findViewById(R.id.rv_riqi);
        tv_gengduoriqi = (TextView) findViewById(R.id.tv_gengduoriqi);
        rl_gengduoriqi = (RelativeLayout) findViewById(R.id.rl_gengduoriqi);
//        mv_ditu = (MapView) findViewById(R.id.mv_ditu);
        iv_touxiang_one = (ImageView) findViewById(R.id.iv_touxiang_one);
        iv_touxiang_two = (ImageView) findViewById(R.id.iv_touxiang_two);
        iv_touxiang_three = (ImageView) findViewById(R.id.iv_touxiang_three);
        iv_touxiang_four = (ImageView) findViewById(R.id.iv_touxiang_four);
        tv_ren_num = (TextView) findViewById(R.id.tv_ren_num);
        ll_baoming = (LinearLayout) findViewById(R.id.ll_baoming);
        tv_pingfen_num = (TextView) findViewById(R.id.tv_pingfen_num);
        iv_ditu = (ImageView) findViewById(R.id.iv_ditu);

        left_icon = (ImageView) findViewById(R.id.left_icon);
        mleft_return = (AutoLinearLayout) findViewById(R.id.mleft_return);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);

        ArrayList<TouristEvaluationBean> touristEvaluationBean = new ArrayList<>();
        touristEvaluationBean.add(new TouristEvaluationBean("http://img0.imgtn.bdimg.com/it/u=2723687026,1914356634&fm=27&gp=0.jpg", "薛之谦", "12", "sdfsdfsdfsdfsd"));
        Lv_Item_TouristEvaluation_Adapter lv_item_touristEvaluation_adapter = new Lv_Item_TouristEvaluation_Adapter(touristEvaluationBean, this);
        lv_pingjia_youke.setAdapter(lv_item_touristEvaluation_adapter);
        lv_pingjia_youke.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(OrderDetailsActivity.this, OrderGrabbingServiceActivity.class));
            }
        });


        ArrayList<DateBeans> dateBeans = new ArrayList<>();
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        dateBeans.add(new DateBeans("01/26周五", "3960"));
        DateRecAdapter dateRecAdapter = new DateRecAdapter(dateBeans);
        LinearLayoutManager manager = new LinearLayoutManager(OrderDetailsActivity.this);
        manager.setOrientation(OrientationHelper.HORIZONTAL);
        rv_riqi.setLayoutManager(manager);
        rv_riqi.setAdapter(dateRecAdapter);


    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
//        mv_ditu.onDestroy();
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
//        mv_ditu.onResume();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
//        mv_ditu.onPause();
//    }
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
//        mv_ditu.onSaveInstanceState(outState);
//    }
}
