package com.library.zldbaselibrary.exception;

/**
 * 作者：Lxw
 * 时间：2021-11-13 11:32
 * <p>
 * 注释：服务端执行逻辑成功，只是返回给客户端一个通知，但通知里面并没有数据；例如这种字符串：
 *
 *  {
 *      "status":1,
 *      "msg":"反馈成功",
 *      "data":[
 *
 *      ],
 *      "server_time":"1615293963"
 *  }
 *
 * 上面的Json中 data 字段是个空数组，在解析时会直接抛出该异常{@link EmptyDataException}
 * 请在 {@link com.library.zldbaselibrary.net.CallBack#onError(Throwable)} 中处理。
 */
public class EmptyDataException extends Exception {
    /** 错误码，该值一定为1，代表服务端逻辑执行成功 */
    private int errorCode;
    /** 错误信息，一般为服务端的成功提示，例如：反馈成功/修改成功 */
    private String errorMsg;

    public EmptyDataException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
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
}
