package com.example.module_football;

import android.app.Application;
import com.example.library_base.ModuleApplicationInit;

public class ApplicationInit extends ModuleApplicationInit {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        System.out.println("football模块application 初始化:");
    }

}
