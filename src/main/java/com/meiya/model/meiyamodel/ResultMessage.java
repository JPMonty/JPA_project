package com.meiya.model.meiyamodel;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/26 下午4:26
 */
public class ResultMessage {
    boolean failed;
    String message;
    Object data;

    public boolean isFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
