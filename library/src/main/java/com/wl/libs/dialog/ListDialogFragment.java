package com.wl.libs.dialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wl.libs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16/7/1.
 */
public class ListDialogFragment<T> extends DialogFragment {

    private ListView listView;
    private List<T> data;

    private boolean isDismiss = false;

    private ListDialogItemClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getDialog() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        View root = inflater.inflate(R.layout.dialog_list, container, false);

        listView = (ListView) root.findViewById(R.id.listview);

        data = (ArrayList<T>) getArguments().getSerializable("data");

        listView.setAdapter(new ListDialogAdapter<T>(getActivity(), data));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onItemClick(position, data.get(position));

                    if (isDismiss)
                        dismiss();
                }
            }
        });



        return root;
    }

    public void setListener(ListDialogItemClickListener listener) {
        this.listener = listener;
    }

    public void setDismiss(boolean dismiss) {
        isDismiss = dismiss;
    }

    public interface ListDialogItemClickListener {
        public void onItemClick(int position, Object obj);
    }

}
