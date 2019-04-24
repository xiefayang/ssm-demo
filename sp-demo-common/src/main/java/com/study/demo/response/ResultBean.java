package com.study.demo.response;

/**
 * Created by xiexie on 2019/4/24.
 */

public class ResultBean
        implements Serializable
{
    private static final long serialVersionUID = -1092646848721671618L;
    public static final Integer SUCCESS = Integer.valueOf(200);

    public static final Integer VALID_FAILD = Integer.valueOf(400);

    public static final Integer ERROR_UNKNOWN = Integer.valueOf(900);

    public static final Integer ERROR_DB = Integer.valueOf(901);
    private Integer resultCode;
    private String errMsg;
    private long elapsedMilliseconds;

    public ResultBean()
    {
    }

    public ResultBean(Integer resultCode, String errMsg)
    {
        this.resultCode = resultCode;
        this.errMsg = errMsg;
    }

    public long getElapsedMilliseconds()
    {
        return this.elapsedMilliseconds;
    }

    public void setElapsedMilliseconds(long elapsedMilliseconds) {
        this.elapsedMilliseconds = elapsedMilliseconds;
    }

    public Integer getResultCode()
    {
        return this.resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}