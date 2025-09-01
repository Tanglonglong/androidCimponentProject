package com.example.newsmodule;

import android.app.Application;

import com.example.basenetwork.NetworkApi;
import com.example.library_base.ModuleApplicationInit;

import static com.example.newsmodule.NetWorkConfig.JUHE_BASE_URL;


public class ApplicationInit extends ModuleApplicationInit {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        System.out.println("新闻模块application 初始化");
        NetworkRequiredInfo networkRequiredInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(JUHE_BASE_URL)
                .build();
        NetworkApi.init(networkRequiredInfo);
    }
    //TODO 可以根据需要，实现application不同的生命周期代码


}
