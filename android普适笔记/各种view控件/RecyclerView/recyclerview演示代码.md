##1.recyclerview的介绍网址
<a href="http://blog.csdn.net/skykingf/article/details/50827141">Android开发之RecyclerView的使用全解</a><br>
<a href="http://blog.csdn.net/lmj623565791/article/details/45059587"> Android RecyclerView 使用完全解析 HongYang </a><br>

##2.recyclerview代码演示
fragment_view.xml<br>
<pre>
&lt;?xml version="1.0" encoding="utf-8"?>
&lt;RelativeLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;

    &lt;android.support.v7.widget.RecyclerView
        android:id="@+id/rv_takeoutfrm"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    &lt;/android.support.v7.widget.RecyclerView>

    &lt;TextView
        android:id="@+id/tv_takeoutfrm_empty"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/no_data"
        android:visibility="visible"
        android:textSize="@dimen/empty_size"
        android:layout_centerInParent="true"/>
&lt;/RelativeLayout&gt;
</pre>
--------
recyclerview_item.xml
<pre>
&lt;?xml version="1.0" encoding="utf-8"?>
&lt;FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:background="#44ff0000"
    android:layout_height="wrap_content" >

    &lt;TextView
        android:id="@+id/id_num"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:gravity="center"
        android:text="1" />
&lt;/FrameLayout>
</pre>
---
fragment.java
<pre>
package com.team.witkers.fragment.homefrm;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.team.witkers.R;
import com.team.witkers.adapter.TakeOutMissionAdapter;
import com.team.witkers.base.BaseFragment;
import java.util.ArrayList;

/**
 * Created by hys on 2016/7/30.
 */
public class TakeOutFragment00 extends BaseFragment {
    private TextView tv_takeoutfrm_empty;
    private RecyclerView mRecyclerView;

    private TakeOutMissionAdapter mAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected int setContentId() {
        return R.layout.fragment_index_take_out2;
    }

    @Override
    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }//initData

    @Override
    protected void initView(View view) {
        tv_takeoutfrm_empty= (TextView) view.findViewById(R.id.tv_takeoutfrm_empty);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.rv_takeoutfrm);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter = new TakeOutMissionAdapter(getActivity(),mDatas ) );
    }
}//Frm00_cls

</pre>
----

MyAdapter.java
<pre>
package com.team.witkers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.team.witkers.R;
import java.util.ArrayList;

/**
 * Created by hys on 2016/7/30.
 */
// 注意泛型添加自定义ViewHoler   RecyclerView.Adapter<TakeOutMissionAdapter.TakeOutViewHolder>
public class TakeOutMissionAdapter extends RecyclerView.Adapter<TakeOutMissionAdapter.TakeOutViewHolder> {
    private Context context;
    private ArrayList<String> mDatas;

    public TakeOutMissionAdapter(Context context,ArrayList<String> mDatas){
        this.context=context;
        this.mDatas=mDatas;
    }

    @Override
    public TakeOutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TakeOutViewHolder holder = new TakeOutViewHolder(LayoutInflater.from(
                context).inflate(R.layout.recyclerview_takeout_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(TakeOutViewHolder holder, int position) {
        holder.tv.setText( mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class TakeOutViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public TakeOutViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
        }
    }//TakoutViewHoler_cls

}//TakeOutAdapter_cls

</pre>