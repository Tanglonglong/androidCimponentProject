package com.example.modulejokes;

import android.app.Application;
import com.example.library_base.ModuleApplicationInit;


public class ApplicationInit extends ModuleApplicationInit {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        System.out.println("笑话大全模块application 初始化");
    }
    //TODO 可以根据需要，实现application不同的生命周期代码


}
