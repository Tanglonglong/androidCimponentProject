package com.example.componentproject;


import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.example.componentproject.utils.ReflectionInitApplication;
import com.example.library_base.BaseApplication;
//import com.example.newsmodule.NetworkRequiredInfo;
//import com.example.newsmodule.NewsModuleApplication;


public class MyApplication extends BaseApplication {

//    public NetworkRequiredInfo mNetworkRequiredInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         *
         * 这边需要调用每个模块的application的一些初始化等操作
         * 这边通过反射、和依赖注入等方式  自己写个gradle插件
         *
         * 1.反射实现，就需要知道每个模块的初始化类的路径，所以这边需要维护一个每个组件的初始化路径
         * 2.通过依赖注入实现
         * 3.通过自定义注解来实现
         * 4.自己写个gradle插件来自动维护
         *
         *
         *
         * **/

        System.out.println("AAAAAAAAAAAAAAAAA主模块");
        ReflectionInitApplication.getInstance(this).initOnCreate();





//        NewsModuleApplication newsModuleApplication = new NewsModuleApplication();
//        newsModuleApplication.onCreateInit(this);
//
//        System.out.println("BBBBBBBBBBBBBB:" + newsModuleApplication.mNetworkRequiredInfo.hashCode());
//
//        System.out.println("CCCCCCCCCCCCCC:" + mNetworkRequiredInfo);

//        ApplicationInit applicationInit = new ApplicationInit();
//        applicationInit.initApplicationOnCreate(this);
//        NetworkRequiredInfo mNetworkRequiredInfo1 = applicationInit.mNetworkRequiredInfo;
//        System.out.println("CCCCCCCCCCCCCC:" + mNetworkRequiredInfo1.hashCode());

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ReflectionInitApplication.getInstance(this).initOnConfigurationChanged(newConfig);
    }
}
