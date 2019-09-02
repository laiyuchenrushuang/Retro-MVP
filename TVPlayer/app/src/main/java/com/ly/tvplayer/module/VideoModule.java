package com.ly.tvplayer.module;

import com.ly.tvplayer.base.BaseModule;
import com.ly.tvplayer.base.BasePresenter;
import com.ly.tvplayer.base.CommonResponse;
import com.ly.tvplayer.http.HttpService;
import com.ly.tvplayer.presenter.VideoPresenter;

import java.util.Map;

/**
 * Created by ly on 2019/8/30 16:36
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class VideoModule extends BaseModule {
    private VideoPresenter mVideoPresenter;
    public VideoModule(VideoPresenter vp) {
        this.mVideoPresenter = vp;
    }

    @Override
    public <T> void doWork(String url, Map<String, String> map, String methed, BaseModule module, Class<T> T) {
        HttpService.getInstance().getServer(url,map,methed,module,T);
    }

    @Override
    public void doWorkResults(CommonResponse commonResponse, boolean isSuccess) {
        mVideoPresenter.requestResults(commonResponse,isSuccess);
    }
}
