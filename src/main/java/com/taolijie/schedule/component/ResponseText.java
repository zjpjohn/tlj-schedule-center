package com.taolijie.schedule.component;


import com.taolijie.schedule.constant.ErrorCode;

/**
 * Created by wanghongfei on 15-6-19.
 */
public class ResponseText {
    private String message = ErrorCode.SUCCESS.toString();
    private int code = ErrorCode.SUCCESS.value();
    private boolean isOk = true;

    private Object data;


    /**
     * 操作成功的消息对象，单例
     */
    public static ResponseText successResponseText;

    public ResponseText(boolean ok, String message, Object data) {
        this.isOk = ok;
        this.message = message;

        this.data = data;
    }

    public static ResponseText getSuccessResponseText() {
        if (null == successResponseText) {
            successResponseText = new ResponseText();
        }

        return successResponseText;
    }


    /**
     * 该构造函数默认处理结果为成功
     * @param data
     */
    public ResponseText(Object data) {
        this.isOk = true;
        //this.message = Constants.StatusMessage.SUCCESS;

        this.data = data;
    }

    /**
     * 默认处理结果为成功,无附带数据
     */
    public ResponseText() {
        this.isOk = true;
        this.message = ErrorCode.SUCCESS.toString();
    }


    /**
     * 该构造函数默认处理结果为失败
     */
    public ResponseText(ErrorCode errorCode) {
        this.isOk = false;
        this.message = errorCode.toString();
        this.code = errorCode.value();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
