package com.ly.tvplayer.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;

import com.ly.tvplayer.utils.AppUtil;

import butterknife.ButterKnife;

/**
 * Created by ly on 2019/8/30 14:22
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public abstract class BaseActivity extends Activity {
    protected String ANDROID_ID = null; //设备ID
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        AppUtil.getFullScreen(this);
        ANDROID_ID = AppUtil.getAndroidID();
        ButterKnife.bind(this);
        initView();
    }
    protected abstract void initView();
    protected abstract int getLayout();



    public void showToast(String msg) {

    }


    public void showToast(int msgId) {

    }

    public void showErrorDialog(String msg) {

    }
    public void showLog(String s){
        Log.d("[lylog]"," -> "+s);
    }
}
