package com.example.module_football.network;

import android.app.Application;
import com.example.basenetwork.NetWorkApi;
import com.example.basenetwork.NetWorkFactory;
import com.example.basenetwork.NetworkRequiredInfo;
import com.example.basenetwork.observer.BaseObserver;
import com.example.module_football.api.ApiService;
import com.example.module_football.bean.FootballResponse;
import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.example.module_football.network.NetWorkConfig.FOOTBALL_BASE_URL;
import static com.example.module_football.network.NetWorkConfig.JUHE_API_JEY;


public class NetWorkBus {

    private static volatile NetWorkBus instance;

    private NetWorkApi mFootballApi;
    private Map<String, String> COM_PARMA = new HashMap<>();

    private NetWorkBus(Application application) {
        NetworkRequiredInfo info = new NetworkRequiredInfo.Builder(application)
                .baseUrl(FOOTBALL_BASE_URL)
                .build();
        mFootballApi = NetWorkFactory.createNetWorkApi(info);
        System.out.println("GGGGGGGGGGFDFF:" + mFootballApi);
        COM_PARMA.put("key", JUHE_API_JEY);
    }

    public static NetWorkBus getInstance(Application application) {
        System.out.println("11111111111111111111:" + application);
        if (instance == null) {
            synchronized (NetWorkBus.class) {
                if (instance == null) {
                    instance = new NetWorkBus(application);
                }
            }
        }
        return instance;
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

    public void getFootballWithNetWork(String type, BaseObserver<FootballResponse> callBack) {
        HashMap<String, String> parms = new HashMap<>();
        parms.put("type", type);
        parms.putAll(COM_PARMA);
        mFootballApi.createService(ApiService.class)
                .getNews(parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callBack);
    }
}
