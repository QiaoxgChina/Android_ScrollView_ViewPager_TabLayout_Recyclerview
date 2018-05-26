package com.qiaoxg.scrollviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<T> mList;
    public Context mContext;
    protected OnItemClickLitener mOnItemClickLitener;
    protected OnItemLongClickLitener mOnItemLongClickListener;
    public LayoutInflater inflater;private String TAG="BaseRecyclerViewAdapter";

    public BaseRecyclerViewAdapter(Context context) {

        this.mContext = context;
         mList = new ArrayList<>();
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        else
            return 0;
    }

    public void setData(List<T> data) {
        this.mList.clear();
        if(data!= null){
            this.mList.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void setDataOnly(List<T> data){
        if(data!= null){
             this.mList.clear();
             this.mList.addAll(data);
        }
    }
    public void clearDate(){
            this.mList.clear();
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        if(mList != null && mList.size()>position){
            return mList.get(position);
        }
        return null;
    }

    public List<T> getData() {
        return mList;
    }

    public void setData(T[] list) {
        ArrayList<T> arrayList = new ArrayList<>(list.length);
        for (T t : list) {
            arrayList.add(t);
        }
        setData(arrayList);
    }


    public void addData(int position, T item) {
          if (mList != null && position <= mList.size()) {
            mList.add(position, item);
            notifyDataSetChanged();
        }
    }

    public void addLastData(T item) {
        if (mList != null) {
            mList.add(item);
            notifyDataSetChanged();
        }
    }

    public void removeData(int position) {
        if (mList != null && position < mList.size()) {
            mList.remove(position);
            notifyItemRemoved(position);
            //必须调用这行代码
            notifyItemRangeChanged(0, mList.size());
        }
    }

    public void notifyMyItemInserted(int position){
        notifyItemInserted(position);
    }

    public void notifyMyItemRemoved(int position){
        notifyItemRemoved(position);
    }

    public void notifyMyItemChanged(int position){
        notifyItemChanged(position);
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemLongClickLitener {
        void onItemLongClick(View view, int position);
    }

    public void setOnItemLongClickLitener(OnItemLongClickLitener onItemLongClickLitener) {
        this.mOnItemLongClickListener = onItemLongClickLitener;
    }

    //添加元素
    public void addAll(List<T> dd){
        if(dd != null){
            mList.addAll(dd);
            notifyDataSetChanged();
        }


    }

    //清空数据源
    public void clean(){
        mList.clear();
        notifyDataSetChanged();
    }
}
