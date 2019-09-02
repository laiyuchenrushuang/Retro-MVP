package com.ly.tvplayer.utils;

/**
 * Created by ly on 2019/8/30 15:31
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public interface NetWorkUtil {
     String GET = "get";
     String POST = "post";

     String BASE_IP = "http://xxjf.cdjg.chengdu.gov.cn:8090";

     String BASE_URL = BASE_IP+"/jyptdbctl/video/getTvVideo?";

     String BASE_URL_TRUE = "http://bj.migucloud.com/vod2/v1/download_spotviurl?";

     String BASE_URL_COMPLETE = BASE_IP+"/jyptdbctl/video/playComplete?";



     interface UrlType{
          String GET_TV = "jyptdbctl/video/getTvVideo";
     }
}
