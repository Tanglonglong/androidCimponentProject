package com.example.module_jokes.api;


import com.example.module_jokes.bean.JokesResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ApiService接口 统一管理应用所有的接口
 */
public interface ApiService {
    @POST("joke/content/list")
    @FormUrlEncoded
    Observable<JokesResponse> getNews(@FieldMap Map<String, String> params);

}
