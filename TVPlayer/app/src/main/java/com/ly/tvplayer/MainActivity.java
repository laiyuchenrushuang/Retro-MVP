package com.ly.tvplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import com.ly.tvplayer.base.BaseActivity;
import com.ly.tvplayer.base.CommonResponse;
import com.ly.tvplayer.bean.TestBean;
import com.ly.tvplayer.presenter.VideoPresenter;
import com.ly.tvplayer.utils.NetWorkUtil;
import com.ly.tvplayer.view.VideoView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements VideoView {
    @BindView(R.id.video_surface)
    SurfaceView mSurfaceView;

    @BindView(R.id.qcode)
    ImageView mQcode;

    @BindView(R.id.play)
    ImageView mPlay;

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private VideoPresenter mVideoPresenter;

    @Override
    protected void initView() {
        mediaPlayer = new MediaPlayer();
        surfaceHolder = mSurfaceView.getHolder();
        mVideoPresenter = new VideoPresenter(this);
        bindEvent();
    }

    private void bindEvent() {
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> map = new HashMap<>();
                map.put("curPage", "1");
//                map.put("pageSize", "1");//获取最新的
                mVideoPresenter.doNetworkTask(NetWorkUtil.UrlType.GET_TV,map,NetWorkUtil.GET, TestBean.class);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void netWorkTaskSuccess(CommonResponse commonResponse) {
        TestBean t = (TestBean) commonResponse.getBaseEnity();
        showLog("成功:"+t.getMessage());
    }

    @Override
    public void netWorkTaskfailed(CommonResponse commonResponse) {
        showLog("失败:"+commonResponse.getFailedResponse());
    }
}
