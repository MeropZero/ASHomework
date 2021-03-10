package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter;
    //private EditText etSearch;
    private List<String> items;
    //private Handler handler = new Handler();

    /*private Runnable delayRun = new Runnable() {
        @Override
        public void run() {
            itemTags(etSearch.getText().toString().trim());
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //etSearch = findViewById(R.id.search_v);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSearchAdapter = new SearchAdapter();
        mRecyclerView.setAdapter(mSearchAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        items = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            items.add("这是第"+i+"行");
        }
        mSearchAdapter.notifyItems(items);

        /*etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (delayRun != null) {
                    handler.removeCallbacks(delayRun);
                }
                handler.postDelayed(delayRun, 800);
            }
        });*/
    }

    /*private void itemTags(String itemTagName) {
        List<String> itemTags = new ArrayList<>();
        for (int i = 1; i<=100; i++) {
            String itemTag = items.get(i);
            if (itemTag.contains(itemTagName)) {
                itemTags.add(itemTag);
            }
            //itemTags.add("这是第 "+i+" 行");
        }
        //items.addAll(itemTags);
        mSearchAdapter.notifyItems(itemTags);
    }*/
}