package com.ly.tvplayer.presenter;

import android.content.Context;

import com.ly.tvplayer.base.BaseModule;
import com.ly.tvplayer.base.BasePresenter;
import com.ly.tvplayer.base.BaseView;
import com.ly.tvplayer.base.CommonResponse;
import com.ly.tvplayer.http.HttpService;
import com.ly.tvplayer.module.VideoModule;
import com.ly.tvplayer.view.VideoView;

import java.util.Map;

/**
 * Created by ly on 2019/8/30 16:35
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class VideoPresenter extends BasePresenter {
    private VideoView mViewView;
    private VideoModule mVideoModule;
    public VideoPresenter(VideoView view) {
        this.mViewView = view;
        mVideoModule = new VideoModule(this);
    }

    @Override
    public <T> void doNetworkTask(String url, Map<String, String> map, String methed, Class<T> T) {
        mVideoModule.doWork(url,map,methed,mVideoModule,T);
    }

    @Override
    public void requestResults(CommonResponse commonResponse, Boolean isSuccess) {
        if (isSuccess){
            mViewView.netWorkTaskSuccess(commonResponse);
        }else {
            mViewView.netWorkTaskfailed(commonResponse);
        }
    }
}
