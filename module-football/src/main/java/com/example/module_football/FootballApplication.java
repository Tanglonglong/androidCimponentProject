package com.example.module_football;

import com.example.library_base.BaseApplication;


public class FootballApplication extends BaseApplication {

    public ApplicationInit mApplicationInit;



    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("newsModule:onCreate() ");
        mApplicationInit = new ApplicationInit();
        mApplicationInit.onCreate(this);



    }



}
