package com.library.zldbaselibrary.exception;

/**
 * 作者：Lxw
 * 时间：2021-11-13 11:32
 * <p>
 * 注释：服务器返回了逻辑错误信息,将错误信息封装成异常抛出
 */
public class ReqException extends Exception {
    /** 错误码 */
    private int errorCode;
    /** 错误信息 */
    private String errorMsg;
    /** 原始json字符串数据 可能为空 */
    private String originJsonStr;

    public ReqException(int errorCode, String errorMsg, String originJsonStr) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.originJsonStr = originJsonStr;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getOriginJsonStr() {
        return originJsonStr;
    }

    public void setOriginJsonStr(String originJsonStr) {
        this.originJsonStr = originJsonStr;
    }
}
