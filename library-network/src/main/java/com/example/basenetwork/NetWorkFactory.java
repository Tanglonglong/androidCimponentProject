package com.example.basenetwork;

import android.app.Application;

import static com.example.basenetwork.NetWorkConfig.BASE_URL;

public class NetWorkFactory {


    /**
     *
     *
     * 一般app就一个baseURL，所以这个接口封装到底层，一般不会改动
     *
     * BaseNetworkApi 为了方便使用，底层网络框架已经创建
     *
     * **/
    public static void initBaseNetWorkApi(Application application){
        NetworkRequiredInfo mNetworkRequiredInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(BASE_URL)
                .build();
       new BaseNetworkApi(mNetworkRequiredInfo);
    }

    /**
     *
     *
     * 给组件业务层，提供的扩展接口，比如有需要访问其他域名的需求
     *
     * **/

    public static NetWorkApi createNetWorkApi(NetworkRequiredInfo info){
        return  new NetWorkApi(info);
    }


}
