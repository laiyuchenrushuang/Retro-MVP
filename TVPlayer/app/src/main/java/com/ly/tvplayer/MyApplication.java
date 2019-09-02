package com.ly.tvplayer;

import android.app.Application;
import android.content.Context;

/**
 * Created by ly on 2019/8/30 13:39
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class MyApplication extends Application {
    private static Context mContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    /**
     * 获取Context的实例
     * @return
     */
    public static Context getContext(){
        return mContext;
    }
}
