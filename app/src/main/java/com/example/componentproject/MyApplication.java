package com.example.componentproject;

import android.app.Application;

import com.example.newsmodule.ApplicationInit;
import com.example.newsmodule.NetworkRequiredInfo;
import com.example.newsmodule.NewsModuleApplication;


public class MyApplication extends Application {

    public NetworkRequiredInfo mNetworkRequiredInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MainAPP:onCreate() ");
        NewsModuleApplication newsModuleApplication = new NewsModuleApplication();
        newsModuleApplication.onCreateInit(this);
//
//        System.out.println("BBBBBBBBBBBBBB:" + newsModuleApplication.mNetworkRequiredInfo.hashCode());
//
//        System.out.println("CCCCCCCCCCCCCC:" + mNetworkRequiredInfo);

//        ApplicationInit applicationInit = new ApplicationInit();
//        applicationInit.initApplicationOnCreate(this);
//        NetworkRequiredInfo mNetworkRequiredInfo1 = applicationInit.mNetworkRequiredInfo;
//        System.out.println("CCCCCCCCCCCCCC:" + mNetworkRequiredInfo1.hashCode());

    }


}
