package com.infrastructure.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hys on 2016/8/5.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }//onCreate

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setContentId(), container, false);
        initDataBeforeView();
        initView(view);
        setListener();
        loadDataAfterView();

        return view;
    }

    @Override
    public void onResume() {
        loadDataonResume();
        super.onResume();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        showView();
    }



    protected abstract int setContentId();
    protected void initView(View view){}
    protected void setListener(){}
    protected void initDataBeforeView(){}
    protected void loadDataAfterView(){}

    protected void showView(){}

    protected void loadDataonResume(){}
}//BaseFrm
