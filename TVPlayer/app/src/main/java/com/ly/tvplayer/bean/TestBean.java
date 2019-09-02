package com.ly.tvplayer.bean;

import com.ly.tvplayer.base.BaseEnity;

import java.util.List;

/**
 * Created by ly on 2019/8/30 17:07
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class TestBean extends BaseEnity {
    private boolean status;

    private int code;

    private String message;

    private Data data;

    private int total;

    public void setStatus(boolean status){
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    public class Data {
        private int pageNo;

        private int pageSize;

        private int count;

        private List<List> list ;

        private String orderDirection;

        public void setPageNo(int pageNo){
            this.pageNo = pageNo;
        }
        public int getPageNo(){
            return this.pageNo;
        }
        public void setPageSize(int pageSize){
            this.pageSize = pageSize;
        }
        public int getPageSize(){
            return this.pageSize;
        }
        public void setCount(int count){
            this.count = count;
        }
        public int getCount(){
            return this.count;
        }
        public void setList(List<List> list){
            this.list = list;
        }
        public List<List> getList(){
            return this.list;
        }
        public void setOrderDirection(String orderDirection){
            this.orderDirection = orderDirection;
        }
        public String getOrderDirection(){
            return this.orderDirection;
        }

    }
}
