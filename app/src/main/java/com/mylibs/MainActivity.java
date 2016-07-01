package com.mylibs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.wl.libs.dialog.ListDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ListView mListView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();

    }

    private void initView() {

        mListView = (ListView) findViewById(R.id.listview);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createTestDialog();            }
        });

    }

    private void createTestDialog() {
        ListDialogFragment<String> dialog = new ListDialogFragment<String>();

        ArrayList<String> data = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            String str = "对话框数据：" + i + 1;
            data.add(str);
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("data", data);
        dialog.setArguments(bundle);

        dialog.setListener(new ListDialogFragment.ListDialogItemClickListener() {
            @Override
            public void onItemClick(int position, Object obj) {
                Toast.makeText(MainActivity.this, "点击数据:" + obj.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show(getSupportFragmentManager(), "dialog");
    }

    private void initData() {

        List<Bean> datas = new ArrayList<Bean>();


        for (int i = 0; i < 20; i++) {
            Bean bean = new Bean("测试" + (i+1), "这个是测试的详细内容！");
            datas.add(bean);
        }


        mAdapter = new MyAdapter(this, datas);
    }
}
