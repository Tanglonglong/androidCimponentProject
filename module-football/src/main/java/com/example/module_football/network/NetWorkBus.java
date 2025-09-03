package com.example.module_football.network;

import com.example.basenetwork.FootballNetworkApi;
import com.example.basenetwork.observer.BaseObserver;
import com.example.module_football.api.ApiService;
import com.example.module_football.bean.FootballResponse;
import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import static com.example.module_football.network.NetWorkConfig.JUHE_API_JEY;


public class NetWorkBus {

    public static Map<String, String> COM_PARMA = new HashMap<>();

    static {
        COM_PARMA.put("key", JUHE_API_JEY);
    }

    /**
     * 足球联赛类型, 可选:
     * jiangsu(江苏城市足球联赛、苏超)
     * xijia(西甲)
     * dejia(德甲)
     * yingchao(英超)
     * yijia(意甲)
     * fajia(法甲)
     * zhongchao(中超)
     **/

    public static void getFootballWithNetWork(String type, BaseObserver<FootballResponse> callBack) {
        HashMap<String, String> parms = new HashMap<>();
        parms.put("type", type);
        parms.putAll(COM_PARMA);
        FootballNetworkApi.createService(ApiService.class)
                .getNews(parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }
}
