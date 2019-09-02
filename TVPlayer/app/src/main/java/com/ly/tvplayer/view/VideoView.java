package com.ly.tvplayer.view;

import com.ly.tvplayer.base.BaseView;
import com.ly.tvplayer.base.CommonResponse;

/**
 * Created by ly on 2019/8/30 16:42
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public interface VideoView extends BaseView {
    void netWorkTaskSuccess(CommonResponse commonResponse);

    void netWorkTaskfailed(CommonResponse commonResponse);
}
