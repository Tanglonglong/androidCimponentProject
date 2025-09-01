package com.example.newsmodule;

import android.app.Application;

import com.example.basenetwork.NetworkApi;

import static com.example.newsmodule.NetWorkConfig.JUHE_BASE_URL;

public class ApplicationInit {

    public NetworkRequiredInfo mNetworkRequiredInfo;
    public void initApplicationOnCreate(Application application){
        mNetworkRequiredInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(JUHE_BASE_URL)
                .build();
        NetworkApi.init(mNetworkRequiredInfo);


    }

}
