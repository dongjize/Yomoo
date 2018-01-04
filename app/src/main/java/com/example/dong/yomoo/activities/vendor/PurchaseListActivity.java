package com.example.dong.yomoo.activities.vendor;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.BaseActivity;
import com.example.dong.yomoo.entities.Purchase;

import java.util.List;

/**
 * （饲料销售商）进货列表页
 */
public class PurchaseListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ListView listView;
    private List<Purchase> purchaseList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String offset = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onRefresh() {

    }
}
