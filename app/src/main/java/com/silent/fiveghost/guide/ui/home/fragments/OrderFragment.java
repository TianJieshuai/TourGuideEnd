package com.silent.fiveghost.guide.ui.home.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.base.fragment.BaseFragment;
import com.silent.fiveghost.guide.ui.details_robbing.Details_RobbingActivity;
import com.silent.fiveghost.guide.ui.order.OrderDetailsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment implements View.OnClickListener {

    private Button order_grab_single;
    private Button order_Orderbooking;
    private Button order_MyRoute;

    @Override
    protected void initData(Bundle arguments) {
        addBodyView(R.layout.fragment_order);
    }

    @Override
    protected void run() {
        order_grab_single = (Button) findViewById(R.id.order_grab_single);
        order_Orderbooking = (Button) findViewById(R.id.order_Orderbooking);
        order_MyRoute = (Button) findViewById(R.id.order_MyRoute);

        order_grab_single.setOnClickListener(this);
        order_Orderbooking.setOnClickListener(this);
        order_MyRoute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.order_grab_single:
                startActivity(new Intent(getActivity(), OrderDetailsActivity.class));
                break;
            case R.id.order_Orderbooking:
                startActivity(new Intent(getContext(), Details_RobbingActivity.class).putExtra("IsThere", true));
                break;
            case R.id.order_MyRoute:

                break;
        }
    }
}
