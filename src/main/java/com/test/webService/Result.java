package com.test.webService;

public class Result {
    private String msg;
    private boolean suc;

    public Result() {
    }

    public Result(String msg, boolean suc) {
        this.msg = msg;
        this.suc = suc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", suc=" + suc +
                '}';
    }
}
