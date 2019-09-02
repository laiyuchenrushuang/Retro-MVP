package com.ly.tvplayer.http;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.ly.tvplayer.MyApplication;
import com.ly.tvplayer.R;
import com.ly.tvplayer.base.BaseModule;
import com.ly.tvplayer.base.CommonResponse;
import com.ly.tvplayer.bean.TestBean;
import com.ly.tvplayer.utils.NetWorkUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ly on 2019/8/30 15:27
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class HttpService {
    private static HttpService mHttpService;
    private BaseModule mBaseModule;

    private final int SUCCESS_CODE = 0;
    private final int FAILED_CODE = 1;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NetWorkUtil.BASE_IP)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static HttpService getInstance() {
        if (mHttpService == null) {
            synchronized (HttpService.class) {
                if (mHttpService == null) {
                    mHttpService = new HttpService();
                }
            }
        }
        return mHttpService;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SUCCESS_CODE:
                    CommonResponse commonResponse1 = (CommonResponse) msg.obj;
                    mBaseModule.doWorkResults(commonResponse1, true);
                    break;
                case FAILED_CODE:
                    CommonResponse commonResponse2 = (CommonResponse) msg.obj;
                    mBaseModule.doWorkResults(commonResponse2, false);
                    break;
            }
        }
    };

    /**
     * 网络全新请求方式
     *
     * @param url
     * @param map
     * @param method
     * @param module
     * @param tClass 实体类
     */
    public <T> void getServer(final String url, Map<String, String> map, String method, BaseModule module, final Class<T> tClass) {
        this.mBaseModule = module;
        IServer iServer = retrofit.create(IServer.class);
        //GET请求
        if (method.equals(NetWorkUtil.GET)) {
            Call<ResponseBody> call = iServer.getServer(url, map);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        if (response.body() != null && TextUtils.isEmpty(response.body().string())) {
                            T a = new Gson().fromJson(response.body().string(), tClass);
                            sendSuccessMsg(a, url);
                        } else {
                            sendSuccessMsg(MyApplication.getContext().getString(R.string.warring), url);
                        }
                    } catch (IOException e) {
                        sendSuccessMsg(e.getMessage(), url);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    sendSuccessMsg(t.getMessage(), url);
                }
            });
            //POST请求
        } else {
            MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
            JSONObject jsonObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jsonObject.put(entry.getKey().trim(), entry.getValue().trim());
                }
            } catch (JSONException e) {
                sendSuccessMsg(e.getMessage(),url);
                return;
            }
            //转为json字符
            String str = jsonObject.toString();
            // 获取到请求体（RequestBody）
            final RequestBody requestBody = RequestBody.create(mediaType, str);

            Call<ResponseBody> call = iServer.postServer(url, requestBody);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    sendSuccessMsg(new Object(),url);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    sendSuccessMsg(t.getMessage(),url);
                }
            });
        }
    }

    private void sendSuccessMsg(Object a, String url) {
        //失败的
        if (a.getClass() == String.class) {
            Message message = Message.obtain();
            message.what = FAILED_CODE;
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setUrl(url);
            commonResponse.setFailedResponse(a.toString());
            message.obj = commonResponse;
            mHandler.sendMessage(message);

            //成功的
        } else {
            Message message = Message.obtain();
            message.what = SUCCESS_CODE;
            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setUrl(url);
            commonResponse.setBaseEnity(a);
            message.obj = commonResponse;
            mHandler.sendMessage(message);
        }
    }
}
