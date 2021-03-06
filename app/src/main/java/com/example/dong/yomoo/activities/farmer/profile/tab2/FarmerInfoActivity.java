package com.example.dong.yomoo.activities.farmer.profile.tab2;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;
import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.http.BaseResult;
import com.example.dong.yomoo.http.HttpAPI;
import com.example.dong.yomoo.http.HttpCallback;
import com.example.dong.yomoo.http.RequestBean;
import com.example.dong.yomoo.utils.Global;
import com.example.dong.yomoo.utils.L;

import java.util.HashMap;
import java.util.Map;

/**
 * 养殖户个人信息页面
 */
public class FarmerInfoActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = FarmerInfoActivity.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView tvName, tvVillage, tvGroup, tvStreet, tvLivestock, tvExpLivestock, tvIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmer_info_activity);

        initToolbar();

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        tvName = findViewById(R.id.tv_name);
        tvVillage = findViewById(R.id.tv_village);
        tvGroup = findViewById(R.id.tv_group);
        tvStreet = findViewById(R.id.tv_street_num);
        tvLivestock = findViewById(R.id.tv_livestock);
        tvExpLivestock = findViewById(R.id.tv_exp_livestock);
        tvIntro = findViewById(R.id.tv_intro);

        getFarmerInfo();
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getFarmerInfo() {
        Map<String, Object> params = new HashMap<>();
        long id = Global.farmer.getId();

        RequestBean requestBean = new RequestBean(TAG, HttpAPI.FARMER_INFO + id, params);
        httpHandler.getFarmerInfo(requestBean, new HttpCallback<Farmer>() {
            @Override
            public void onSuccess(BaseResult result) {
                swipeRefreshLayout.setRefreshing(false);
                Farmer farmer = (Farmer) result.getData();
                tvName.setText(farmer.getName());
                tvVillage.setText(farmer.getVillage());
                tvGroup.setText(farmer.getGroup());
                tvStreet.setText(farmer.getStreetNum());
                tvLivestock.setText(farmer.getLivestock());
                tvExpLivestock.setText(farmer.getExpLivestock());
                tvIntro.setText(farmer.getIntro());
            }

            @Override
            public void onFailure(String errMsg) {
                swipeRefreshLayout.setRefreshing(false);
                showToast(errMsg);
                L.d(errMsg);
            }
        });

    }

    @Override
    public void onRefresh() {
        getFarmerInfo();
    }
}
