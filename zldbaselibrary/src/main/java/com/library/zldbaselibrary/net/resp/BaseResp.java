package com.library.zldbaselibrary.net.resp;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：Lxw
 * 时间：2021-11-13 11:06
 * <p>
 * 注释：这是和服务器约定的返回结构。任何返回数据应当继承此类以接收服务器的响应
 */
public class BaseResp<T> {

    /** 服务器返回的消息 */
    private String msg;

    /** 服务器时间戳 */
    @SerializedName("server_time")
    private long serverTime;

    /** 状态：1表示成功，其他表示失败 */
    private int status;

    /** 具体数据 */
    private T data;

    /**
     * 是否成功
     *
     * @return true 成功；false 失败
     */
    public boolean isSuccess() {
        return status == 1;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
