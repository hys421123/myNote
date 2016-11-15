package com.infrastructure.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by hys on 2016/8/5.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setContentId());
        getIntentData();
        initEventBus();
        initView();
        initToolBar();
        setListener();
        showView();
        initData();

    }//onCreate

    @Override
    protected void onResume() {
        loadDataOnResume();
        super.onResume();
    }

    protected abstract int setContentId();
    protected void getIntentData(){}
    protected void initEventBus(){}
    protected void initView(){}
    protected void initToolBar(){}
    protected void setListener(){}
    protected void showView(){}
    protected void initData(){}

    protected void loadDataOnResume(){}

}//BaseAct_cls
