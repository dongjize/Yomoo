package com.example.dong.yomoo.activities.farmer;

import android.os.Bundle;

import com.example.dong.yomoo.R;
import com.example.dong.yomoo.activities.common.BaseActivity;

/**
 * Created by dong on 22/12/2017.
 */

public class FarmerUpdateInfoActivity extends BaseActivity {

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
}
