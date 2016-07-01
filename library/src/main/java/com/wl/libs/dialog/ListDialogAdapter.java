package com.wl.libs.dialog;

import android.content.Context;

import com.wl.libs.adapter.CommenBaseAdapter;
import com.wl.libs.adapter.ViewHolder;

import java.util.List;

/**
 * Created by wanglei on 16/7/1.
 */
public class ListDialogAdapter<T> extends CommenBaseAdapter {

    public ListDialogAdapter(Context mContext, List mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public int getLayoutId() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public void convert(ViewHolder holder, Object o) {
        holder.setText(android.R.id.text1, o.toString());
    }
}
