package com.example.module_football;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.basenetwork.observer.BaseObserver;
import com.example.module_football.adapter.FootballAdapter;
import com.example.module_football.adapter.FootballItem;
import com.example.module_football.bean.FootballMatchBean;
import com.example.module_football.bean.FootballResponse;
import com.example.module_football.bean.TimeMatchBean;
import com.example.module_football.network.NetWorkBus;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/football/FootballMainActivity", group = "football")
public class FootballMainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FootballAdapter mNewAdapter;
    private List<FootballItem> mData = new ArrayList<>();
    private TextView mTitleTv, mDesTv;

    private NetWorkBus mNetWorkBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.football_m_activity_football_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mNetWorkBus = NetWorkBus.getInstance(getApplication());
        initView();
        initData();
        initListener();
    }

    private void initView() {
        mTitleTv = findViewById(R.id.title_tv);
        mDesTv = findViewById(R.id.des_tv);
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
    }

    private void initListener() {

    }

    private void initData() {
        mNewAdapter = new FootballAdapter(this, mData);
        mRecyclerView.setAdapter(mNewAdapter);
        getData();
    }

    private void getData() {
        mNetWorkBus.getFootballWithNetWork("yingchao", new BaseObserver<FootballResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(FootballResponse newResponse) {
                if (newResponse.getError_code() == 0) {
                    mTitleTv.setText(newResponse.getResult().getTitle());
                    mDesTv.setText(newResponse.getResult().getDuration());
                    List<TimeMatchBean> timeMatchs = newResponse.getResult().getMatchs();
                    for (TimeMatchBean item: timeMatchs) {
                        FootballItem footballItem = new FootballItem();
                        footballItem.setType(0);
                        footballItem.setDate(item.getDate());
                        footballItem.setWeek(item.getWeek());
                        mData.add(footballItem);
                        List<FootballMatchBean> matchs = item.getList();
                        for (FootballMatchBean cItem: matchs) {
                            FootballItem footballcItem = new FootballItem();
                            footballcItem.setType(1);
                            footballcItem.setcItem(cItem);
                            mData.add(footballcItem);
                        }
                    }
                    mNewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(FootballMainActivity.this, "业务异常code：" + newResponse.getError_code(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Throwable e) {
                //http 异常处理 TODO
            }
        });

    }
}