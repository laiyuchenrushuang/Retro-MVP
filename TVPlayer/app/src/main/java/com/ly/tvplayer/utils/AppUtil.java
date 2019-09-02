package com.ly.tvplayer.utils;

import android.app.Activity;
import android.provider.Settings;
import android.view.WindowManager;

import com.ly.tvplayer.MyApplication;

/**
 * Created by ly on 2019/8/30 14:34
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class AppUtil {
    /**
     * 全屏的方式
     * @param activity
     */
    public static void getFullScreen(Activity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    /**
     * 获取设备ID
     * @return
     */
    public static String getAndroidID(){
        return Settings.System.getString(MyApplication.getContext().getContentResolver(), Settings.System.ANDROID_ID);
    }
}
