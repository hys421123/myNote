package com.example.hysrecyclerviewtest.example.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by hys on 2016/6/7.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(setContentId());
        ButterKnife.bind(this);
        init();
        loaddata();

    }//onCreate

    protected void initOthersBeforeSetContent(){};
    //setContentId() abstract method,
    //and all sub classes must override the abstract method of the super_cls
    //force to use the method,make it works
    protected abstract int setContentId();
    protected void init(){}
    protected void loaddata() {}

}
