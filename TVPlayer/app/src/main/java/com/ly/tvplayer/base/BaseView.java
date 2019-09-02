package com.ly.tvplayer.base;

/**
 * Created by ly on 2019/8/30 16:31
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public interface BaseView {
    void showToast( String msg);
    void showToast( int msgId);
    void showErrorDialog(String msg);
}
