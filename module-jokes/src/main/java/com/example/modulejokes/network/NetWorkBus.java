package com.example.modulejokes.network;


import com.example.basenetwork.BaseNetworkApi;
import com.example.basenetwork.observer.BaseObserver;
import com.example.modulejokes.api.ApiService;
import com.example.modulejokes.bean.JokesResponse;

import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.modulejokes.network.NetWorkConfig.JUHE_API_JEY;

public class NetWorkBus {

    public static Map<String, String> COM_PARMA = new HashMap<>();

    static {
        COM_PARMA.put("key", JUHE_API_JEY);
    }

    public static void getJokesWithNetWork(String type, int page, int pageSize, BaseObserver<JokesResponse> callBack) {
        HashMap<String, String> parms = new HashMap<>();
        parms.put("sort", type);
        parms.put("page", String.valueOf(page));
        parms.put("page_size", String.valueOf(pageSize));
        parms.put("time", "1418816972");
        parms.putAll(COM_PARMA);
        BaseNetworkApi.createService(ApiService.class)
                .getNews(parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);

        //下面这种是通过用compose操作符将链式调用里面重复的线程调度代码封装成一个新的Observable
        //核心作用是通过封装多个操作符实现逻辑复用，同时保持链式调用的简洁性
//        NetworkApi.createService(ApiService.class)
//                .getNews(parms)
//                .compose(NetworkApi.<NewResponse>applySchedulers())
//                .subscribe(callBack);


    }
}
