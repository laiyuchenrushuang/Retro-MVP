package com.ly.tvplayer.base;

/**
 * Created by ly on 2019/8/30 15:52
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class CommonResponse<T> {

    private String url;  //url
    private T baseEnity;  //成功实体类
    private String failedResponse; //

    public String getFailedResponse() {
        return failedResponse;
    }

    public void setFailedResponse(String failedResponse) {
        this.failedResponse = failedResponse;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getBaseEnity() {
        return baseEnity;
    }

    public  void setBaseEnity(T baseEnity) {
        this.baseEnity = baseEnity;
    }

}
