package com.example.newsmodule;

import android.app.Application;

import com.example.basenetwork.NetworkApi;

import static com.example.newsmodule.NetWorkConfig.JUHE_BASE_URL;


public class NewsModuleApplication extends Application {

    public NetworkRequiredInfo mNetworkRequiredInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("newsModule:onCreate() ");
        mNetworkRequiredInfo = new NetworkRequiredInfo.Builder(this)
                .baseUrl(JUHE_BASE_URL)
                .build();
        NetworkApi.init(mNetworkRequiredInfo);
    }


    public void onCreateInit(Application application){
        mNetworkRequiredInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(JUHE_BASE_URL)
                .build();
        NetworkApi.init(mNetworkRequiredInfo);
    }




}
