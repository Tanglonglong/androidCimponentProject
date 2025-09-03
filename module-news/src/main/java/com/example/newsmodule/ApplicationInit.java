package com.example.newsmodule;

import android.app.Application;
import com.example.basenetwork.BaseNetworkApi;
import com.example.library_base.ModuleApplicationInit;


public class ApplicationInit extends ModuleApplicationInit {

    public BaseNetworkApi mNewsNetWorkApiBase;

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        System.out.println("新闻模块application 初始化");
    }
    //TODO 可以根据需要，实现application不同的生命周期代码


}
