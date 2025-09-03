package com.example.modulejokes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
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
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.basenetwork.observer.BaseObserver;
import com.example.modulejokes.adapter.NewAdapter;
import com.example.modulejokes.bean.JokesBean;
import com.example.modulejokes.bean.JokesResponse;
import com.example.modulejokes.network.NetWorkBus;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/jokes/JokesMainActivity", group = "jokes")
public class JokesMainActivity extends AppCompatActivity {


    private int mPage = 1;
    private int mPageSize = 10;

    private RecyclerView mRecyclerView;
    private SmartRefreshLayout mRefreshLayout;
    private NewAdapter mNewAdapter;
    private List<JokesBean> mData = new ArrayList<>();

    private Button mGoNewsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.jokes_m_activity_jokes_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        initData();
        initListener();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRefreshLayout = findViewById(R.id.refreshLayout);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPage = 1;
                mData.clear();
                getData();
            }
        });
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPage++;
                getData();
            }
        });
        mGoNewsBtn = findViewById(R.id.go_new_btn);
    }

    private void initListener() {
        mGoNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/news/MainActivity").navigation();
            }
        });
    }

    private void initData() {
        mNewAdapter = new NewAdapter(this, mData);
        mRecyclerView.setAdapter(mNewAdapter);
        getData();
    }
    private void getData() {
        NetWorkBus.getJokesWithNetWork("asc", mPage, mPageSize,  new BaseObserver<JokesResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(JokesResponse jokesResponse) {
                if (jokesResponse.getError_code() == 0) {
                    mData.addAll(jokesResponse.getResult().getData());
                    mNewAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(JokesMainActivity.this, "业务异常code：" + jokesResponse.getError_code(), Toast.LENGTH_SHORT).show();
                }
                mRefreshLayout.finishRefresh();
                mRefreshLayout.finishLoadMore();
            }

            @Override
            public void onFailure(Throwable e) {
                //http 异常处理 TODO
                mRefreshLayout.finishRefresh();
                mRefreshLayout.finishLoadMore();
            }
        });

    }
}