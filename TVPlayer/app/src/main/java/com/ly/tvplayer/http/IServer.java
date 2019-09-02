package com.ly.tvplayer.http;

import com.ly.tvplayer.bean.TestBean;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by ly on 2019/8/30 15:30
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public interface IServer {
    @GET()
    Call<ResponseBody> getServer(@Url String url, @QueryMap Map<String, String> map);

    @POST()
    @Headers("Content-Type:application/json")
    Call<ResponseBody> postServer(String url, @Body RequestBody requestBody);
}