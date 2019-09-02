package com.ly.tvplayer.base;


import java.util.Map;

/**
 * Created by seatrend on 2018/8/20.
 */

public abstract class BaseModule {

    public abstract <T> void doWork(String url, Map<String, String> map, String methed, BaseModule module, Class<T> T);
    public abstract void doWorkResults(CommonResponse commonResponse, boolean isSuccess);

}
