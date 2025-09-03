package com.example.basenetwork;

import android.app.Application;
import com.example.library_base.ModuleApplicationInit;

public class NetWorkInit extends ModuleApplicationInit {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        NetWorkFactory.initBaseNetWorkApi(application);
    }
}
