package com.example.modulejokes;

import com.example.library_base.BaseApplication;

public class JokesApplication extends BaseApplication {

    public ApplicationInit mApplicationInit;


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("jokesModule:onCreate() ");
        mApplicationInit = new ApplicationInit();
        mApplicationInit.onCreate(this);
    }




}
