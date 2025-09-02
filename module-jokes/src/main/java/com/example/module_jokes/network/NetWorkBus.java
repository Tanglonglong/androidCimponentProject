package com.example.module_jokes.network;


import com.example.basenetwork.NetworkApi;
import com.example.basenetwork.observer.BaseObserver;
import com.example.module_jokes.api.ApiService;
import com.example.module_jokes.bean.JokesResponse;

import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.module_jokes.NetWorkConfig.JUHE_API_JEY;

public class NetWorkBus {

    public static Map<String, String> COM_PARMA = new HashMap<>();

    static {
        COM_PARMA.put("key", JUHE_API_JEY);
    }

    /**
     * 支持类型 type top(推荐,默认) guonei(国内) guoji(国际)
     * yule(娱乐) tiyu(体育junshi(军事)keji(科技)caijing(财经)
     * youxi(游戏)qiche(汽车)jiankang(健康
     * parms.put("type", "");
     * parms.put("page", "");
     * parms.put("page_size", "");
     * parms.put("is_filter", "");
     * <p>
     * isFilter 是否只返回有内容详情的新闻, 1:是, 默认0
     **/

    public static void getJokesWithNetWork(String type, int page, int pageSize, BaseObserver<JokesResponse> callBack) {
        HashMap<String, String> parms = new HashMap<>();
        parms.put("sort", type);
        parms.put("page", String.valueOf(page));
        parms.put("page_size", String.valueOf(pageSize));
        parms.put("time", "1418816972");
        parms.putAll(COM_PARMA);
        NetworkApi.createService(ApiService.class)
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
