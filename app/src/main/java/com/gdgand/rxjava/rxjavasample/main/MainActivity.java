package com.gdgand.rxjava.rxjavasample.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gdgand.rxjava.rxjavasample.R;
import com.gdgand.rxjava.rxjavasample.main.adapter.MainAdapter;
import com.gdgand.rxjava.rxjavasample.queue.QueueActivity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final static String[] TITLES = {
            "Queue",
            "Scrolling In RecyclerView"
    };

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        MainAdapter adapter = new MainAdapter(MainActivity.this);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        adapter.addAll(Arrays.asList(TITLES));

        adapter.setOnItemClickListener((adapter1, position) -> {
            switch (position) {
                case 0:
                    startActivity(new Intent(MainActivity.this, QueueActivity.class));
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        });
    }
}