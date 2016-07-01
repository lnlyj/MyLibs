package com.wl.libs.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wanglei on 16/5/30.
 */
public class ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private int position;

    public ViewHolder(Context context, View convertView, ViewGroup parent, int layoutId, int position) {

        this.position = position;
        mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {


        if (convertView == null) {
            return new ViewHolder(context, convertView, parent, layoutId, position);
        } else {

            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.position = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    public <T extends View> T getView(int resId) {
        View v = mViews.get(resId);

        if (v == null) {
            v = mConvertView.findViewById(resId);
            mViews.put(resId, v);
        }

        return (T) v;
    }

    public ViewHolder setText(int viewId, String str) {
        TextView tv = getView(viewId);
        tv.setText(str);
        return this;
    }

    public ViewHolder setText(int viewId, int resId) {
        TextView tv = getView(viewId);
        tv.setText(resId);
        return this;
    }

    public ViewHolder setImageRes(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageUri(int viewId, String uri) {
        ImageView iv = getView(viewId);
        // 根据第三方类库自行设定
        return this;
    }
}
