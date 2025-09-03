package com.example.module_football.api;




import com.example.module_football.bean.FootballResponse;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ApiService接口 统一管理应用所有的接口
 */
public interface ApiService {
    @POST("fapig/football/query")
    @FormUrlEncoded
    Observable<FootballResponse> getNews(@FieldMap Map<String, String> params);

}
