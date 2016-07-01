package com.wl.libs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wanglei on 16/5/30.
 */
public abstract class CommenBaseAdapter<T> extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<T> mDatas;

    public CommenBaseAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = ViewHolder.get(mContext,convertView,parent,getLayoutId(),position);

        convert(holder, getItem(position));

        return holder.getConvertView();
    }

    public abstract int getLayoutId();

    public abstract void convert(ViewHolder holder, T t);
}
