package com.example.hysrecyclerviewtest.example.activity;

import android.content.Intent;
import android.view.View;

import com.example.hysrecyclerviewtest.R;
import com.hys.mylog.MyLog;

import butterknife.OnClick;

public class MainActivity extends BaseActivity  {



    @Override
    protected int setContentId() {
        return R.layout.activity_main;
    }



    @OnClick(R.id.recycler_view_main_linear_btn)
    public void click(View v){
        MyLog.i("linear_click--");
        startActivity(new Intent(this,RecyclerLinearLayoutActivity.class));
    }

//    public void click2(View v){
//        MyLog.i("linear_click");
//        startActivity(new Intent(this,RecyclerLinearLayoutActivity.class));
//    }



}//MainAct
