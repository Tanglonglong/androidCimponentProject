package com.example.basenetwork;


import android.app.Application;

import com.example.library_base.ModuleApplicationInit;

import static com.example.basenetwork.NetWorkConfig.BASE_URL;
import static com.example.basenetwork.NetWorkConfig.FOOTBALL_BASE_URL;

public class NetWorkInit extends ModuleApplicationInit {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        NetworkRequiredInfo networkRequiredInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(BASE_URL)
                .build();
        BaseNetworkApi.init(networkRequiredInfo);

        NetworkRequiredInfo footballApiInfo = new NetworkRequiredInfo.Builder(application)
                .baseUrl(FOOTBALL_BASE_URL)
                .build();
        FootballNetworkApi.init(footballApiInfo);

    }
}
