package com.study.demo.response;

/**
 * Created by xiexie on 2019/4/24.
 */

public class RestResultResponse<T> extends ResultBean
{
    private static final long serialVersionUID = -3630734380336964442L;
    T data;
    boolean success;

    public boolean isSuccess()
    {
        return this.success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public RestResultResponse success(boolean success)
    {
        setSuccess(success);
        return this;
    }

    public RestResultResponse data(T data)
    {
        setResultCode(Integer.valueOf(200));
        setData(data);
        return this;
    }
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString()
    {
        return "RestResultResponse [data=" + this.data + ", success=" + this.success + "]";
    }
}