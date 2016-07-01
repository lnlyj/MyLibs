package com.mylibs;

import android.content.Context;

import com.wl.libs.adapter.CommenBaseAdapter;
import com.wl.libs.adapter.ViewHolder;

import java.util.List;

/**
 * Created by wanglei on 16/5/30.
 */
public class MyAdapter extends CommenBaseAdapter<Bean> {

    public MyAdapter(Context mContext, List<Bean> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_bean;
    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {

        holder.setText(R.id.title, bean.getTitle())
                .setText(R.id.desc, bean.getDesc());
    }
}
