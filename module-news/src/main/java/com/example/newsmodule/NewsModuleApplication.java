package com.example.newsmodule;

import android.app.Application;

import com.example.basenetwork.NetworkApi;
import com.example.library_base.BaseApplication;

import static com.example.newsmodule.NetWorkConfig.JUHE_BASE_URL;


public class NewsModuleApplication extends BaseApplication {

    public ApplicationInit mApplicationInit;


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("newsModule:onCreate() ");
        mApplicationInit = new ApplicationInit();
        mApplicationInit.onCreate(this);
    }



}
