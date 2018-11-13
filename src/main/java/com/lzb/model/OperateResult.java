package com.lzb.model;

import java.io.Serializable;

public class OperateResult implements Serializable {//返回结果对象
    private static final long serialVersionUID = 1L;

    private boolean success = false;

    private String msg = "";

    private Object obj = null;

    public OperateResult() {
    }

    public OperateResult(boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
