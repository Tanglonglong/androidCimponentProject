package com.example.newsmodule;

import com.example.basenetwork.BaseNetworkApi;
import com.example.library_base.BaseApplication;


public class NewsModuleApplication extends BaseApplication {

    public ApplicationInit mApplicationInit;

    public BaseNetworkApi mNewsNetWorkApiBase;


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("newsModule:onCreate() ");
        mApplicationInit = new ApplicationInit();
        mApplicationInit.onCreate(this);
    }



}
