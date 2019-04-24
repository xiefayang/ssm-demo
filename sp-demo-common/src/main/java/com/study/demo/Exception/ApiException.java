package com.study.demo.Exception;

/**
 * Created by xiexie on 2019/4/24.
 */
public class ApiException extends Exception {
    private static final long serialVersionUID = 1L;

    private String message;


    private String code;

    private boolean isFormat;
    private Object[] args;
    public ApiException() {
        super();
    }

    public ApiException(String code) {
        super(code);
        this.code=code;
        this.message=code;
    }
    public ApiException(String code,Object ...args) {
        super(code);
        this.message=code;
        this.code=code;
        this.args=args;
        isFormat=true;

    }
    public ApiException(String code,String message) {
        super(String.format("code=%s;msg=%s", new Object[]{code,message}));
        this.message=String.format("code=%s;msg=%s", new Object[]{code,message});
        this.code=code;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.message=message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean isFormat() {
        return isFormat;
    }

    public void setFormat(boolean isFormat) {
        this.isFormat = isFormat;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

}
