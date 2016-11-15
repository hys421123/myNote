package com.example.hysrecyclerviewtest.example.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.hysrecyclerviewtest.R;
import com.example.hysrecyclerviewtest.example.activity.BaseActivity;
import com.example.hysrecyclerviewtest.example.adapter.PersonAdapter;
import com.example.hysrecyclerviewtest.example.bean.Person;
import com.example.hysrecyclerviewtest.example.utils.MyItemTouchHelperCallback;
import com.hys.mylog.MyLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by hys on 2016/6/7.
 */

public class RecyclerLinearLayoutActivity extends BaseActivity implements  PersonAdapter.OnRecyclerViewListener{
//    @Bind(R.id.recycler_view_linear_toolbar)
//    public Toolbar rv_toolbar;
//    @Override
//    protected void init() {
//        rv_toolbar.setTitle("haahahha");
//    }
    @Bind(R.id.items_recycler_view)
    public RecyclerView items_recycler_view;

    private List<Person> personList=new ArrayList<Person>();
    private PersonAdapter personAdapter;

    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected int setContentId() {
        return R.layout.activity_rv_linearlayout;
    }

    @Override
    protected void init() {

        items_recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        items_recycler_view.setLayoutManager(layoutManager);
        initListData();
        personAdapter=new PersonAdapter(personList);
        personAdapter.setOnRecyclerViewListener(this);
        items_recycler_view.setAdapter(personAdapter);


        //关联ItemTouchHelper和RecyclerView
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallback(personAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(items_recycler_view);

//        adapter = new PersonAdapter(personList);
//        adapter.setOnRecyclerViewListener(this);
//        items_recycler_view.setAdapter(adapter);

    }//init from super BaseActivity

    private void initListData(){
        for(int i=0;i<30;i++) {
            Person person = new Person("li"+i, i);
            personList.add(person);
        }
    }//initListData

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public boolean onItemLongClick(int position) {

//        MyLog.i("onItemLongClick on RecyclerAct");
        personAdapter.notifyItemRemoved(position);
         personList.remove(position);
         personAdapter.notifyItemRangeChanged(position, personAdapter.getItemCount());
        return true;
    }

    /*




        layoutManager.setOnRecyclerViewScrollLocationListener(recyclerView, new OnRecyclerViewScrollLocationListener() {
            @Override
            public void onTopWhenScrollIdle(RecyclerView recyclerView) {
                Logger.d(TAG, "onTopWhenScrollIdle");
            }

            @Override
            public void onBottomWhenScrollIdle(RecyclerView recyclerView) {
                Logger.d(TAG, "onBottomWhenScrollIdle");
            }
        });
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        initData();
        adapter = new PersonAdapter(personList);
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);

     */
}//Rv_ll_act
