package com.example.hysrecyclerviewtest.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hysrecyclerviewtest.R;
import com.example.hysrecyclerviewtest.example.bean.Person;
import com.example.hysrecyclerviewtest.example.utils.MyItemTouchHelperCallback;
import com.hys.mylog.MyLog;

import java.util.Collections;
import java.util.List;

/**
 * Created by hys on 2016/6/7.
 */
public class PersonAdapter extends RecyclerView.Adapter implements MyItemTouchHelperCallback.onMoveAndSwipedListener {
    private List<Person> list;


    public PersonAdapter(List<Person> list){
        this.list=list;
    }

    //set the interface
    public static interface OnRecyclerViewListener {
        void onItemClick(int position);
        boolean onItemLongClick(int position);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //the linearlayout of the item_person-->view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item_person, null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new PersonViewHolder(view);
    }


    //调用adapter.notifyDataSetChanged()方法，应该也会重新调用onBindViewHolder()方法,绘制item
    //Called by RecyclerView to display the data at the specified position. This method should update the
    // contents of the RecyclerView.ViewHolder.itemView to reflect the item at the given position.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        PersonViewHolder holder = (PersonViewHolder) viewHolder;
        holder.position = position;
        Person person = list.get(position);
        holder.nameTv.setText(person.getName());
        holder.ageTv.setText(person.getAge() + "岁");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View rootView;
        public TextView nameTv;
        public TextView ageTv;
        public int position;

        public PersonViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_name_tv);
            ageTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_age_tv);
            rootView = itemView.findViewById(R.id.ll_item_person);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
           MyLog.i("ll_item click");
            if (onRecyclerViewListener!=null) {
                //interface callback
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
           MyLog.i("ll_item long click1");
            //暂时屏蔽掉长按 删除item功能
//            if (onRecyclerViewListener!=null) {
//  //              MyLog.i("onLongCLick and onItemLongClick");
//                return onRecyclerViewListener.onItemLongClick(position);
//            }
           return false;
       }//onLongClick.
    }//PersonViewHolder_cls

    // (MyItemTouchHelperCallback) interface callback
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {

        //交换mItems数据的位置
       Collections.swap(list,fromPosition,toPosition);
        //交换RecyclerView列表中item的位置
        notifyItemMoved(fromPosition,toPosition);
        return true;

    }

    @Override
    public void onItemDismiss(int position) {

        MyLog.i("onItemDismiss in adapter");
        //删除mItems数据
        list.remove(position);
        //删除RecyclerView列表对应item
        notifyItemRemoved(position);
    }
}//PersonAdapter_cls
