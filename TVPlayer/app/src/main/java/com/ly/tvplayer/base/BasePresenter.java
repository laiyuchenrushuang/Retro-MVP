package com.ly.tvplayer.base;

import java.util.Map;

/**
 * Created by ly on 2019/8/30 16:29
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public abstract class BasePresenter {
   public abstract <T> void doNetworkTask(String url, Map<String, String> map, String methed, Class<T> T);
   public abstract  void requestResults(CommonResponse commonResponse, Boolean isSuccess);
}
