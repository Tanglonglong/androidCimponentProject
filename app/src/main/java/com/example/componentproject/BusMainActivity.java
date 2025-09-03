package com.example.componentproject;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.alibaba.android.arouter.launcher.ARouter;


public class BusMainActivity extends AppCompatActivity {


    private Button mNewsModule, mJokesModule, mFoolBalModule, mMoneyModule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bus_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        initListener();
    }

    private void initView() {
        mNewsModule = findViewById(R.id.btn_module1);
        mJokesModule = findViewById(R.id.btn_module2);
        mFoolBalModule = findViewById(R.id.btn_module3);
        mMoneyModule = findViewById(R.id.btn_module4);
    }

    private void initListener(){
        mNewsModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/news/MainActivity").navigation();
            }
        });
        mJokesModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/jokes/JokesMainActivity").navigation();
            }
        });
        mFoolBalModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/football/FootballMainActivity").navigation();
            }
        });


    }



}