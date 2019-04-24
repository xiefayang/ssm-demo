package com.study.demo.Exception;

/**
 * service层抛异常
 * Created by xiexie on 2019/4/24.
 */
public class ServLayerException extends ApiException {

    private static final long serialVersionUID = 1L;

    public ServLayerException(int code) {
        super( Integer.toString(code));
    }

    public ServLayerException(String code) {
        super(code);
    }
    public ServLayerException(String code, String message) {
        super(code,message);
    }
    public ServLayerException(String code, Object ...args) {
        super(code,args);
    }
}

