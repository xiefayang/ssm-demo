package com.study.demo.Exception;

/**
 * Created by xiexie on 2019/4/24.
 */
public class AppLayerException extends ApiException {

    private static final long serialVersionUID = 1L;

    public AppLayerException(int code) {
        super( Integer.toString(code));
    }

    public AppLayerException(String code) {
        super(code);
    }
    public AppLayerException(String code,String message) {
        super(code,message);
    }
    public AppLayerException(String code,Object ...args) {
        super(code,args);
    }
}

