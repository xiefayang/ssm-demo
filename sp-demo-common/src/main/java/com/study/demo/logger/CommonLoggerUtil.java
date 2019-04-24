package com.study.demo.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;




/**
 * Created by xiexie on 2019/4/24.
 */
/**  公共日志打印类
 * user：rziwc
 * time：2015年8月28日 下午5:25:45
 */

public class CommonLoggerUtil {
    static org.slf4j.Logger log=LoggerFactory.getLogger(CommonLoggerUtil.class);
    /**换行字符串*/
    public static String STR_RETURN="\r\n" ;
    public static String STR_RETURN_N="\n" ;
    public static String STR_RETURN_TO_NEWSTR="@@@";
    /**左书名号字符串*/
    public static String STR_LEFT_SMH="\\{" ;
    public static String STR_LEFT_SMH_TO_NEWSTR="｛";
    /**右书名号字符串*/
    public static String STR_RIGHT_SMH="\\}" ;
    public static String STR_RIGHT_SMH_TO_NEWSTR="｝";
    /**双引号字符串*/
    public static String STR_SYH="\"" ;
    public static String STR_SYH_TO_NEWSTR="＂";
    /**等号字符串*/
    public static String STR_EQUAL="=";
    /**&字符串*/
    public static String STR_WITH="&";
    /** 获得request 请求的参数信息
     * @param request
     * @return
     */
    static public String getParamsForRequest(HttpServletRequest request) {
        String paramName ="";
        StringBuffer bf=new StringBuffer();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            paramName =  paramNames.nextElement();
            bf.append(paramName).append(STR_EQUAL).append(request.getParameter(paramName)).append(STR_WITH);
        }
        return bf.toString().replaceAll(STR_LEFT_SMH, STR_LEFT_SMH_TO_NEWSTR)
                .replaceAll(STR_RIGHT_SMH, STR_RIGHT_SMH_TO_NEWSTR).replaceAll(STR_SYH, STR_SYH_TO_NEWSTR);
    }


    /** SecurityInterceptor类使用开始
     * @param log
     * @param clientIP
     * @param url
     * @param reqId
     * @param methodName
     * @param reqPara
     * @param message
     */
    public static void infoForInterceptorBefore(org.slf4j.Logger log,String clientIp,String url,String reqId,
                                                String methodName,String message){
        log.info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.INTERCEPTOR.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"url\":\"").append(url)
                .append("\",\"clientIp\":\"").append(clientIp)
                .append("\",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":{")
                .append("\"methodName\":\"").append(methodName)
                .append("\",\"message\":\"").append(message)
                .append("\"}}").toString());
    }

    /** SecurityInterceptor类使用结束
     * @param log
     * @param infoData
     * @param methodName
     * @param message
     */
    public static void infoForInterceptorEnd(org.slf4j.Logger log,InfoData infoData){
        log.info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.INTERCEPTOR.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append("}").toString());
    }

    /** info级别 Controller 类方法使用的开始日志公共方法
     * @param log
     * @param infoData
     */
    public static void infoForControllerBegin(org.slf4j.Logger log,InfoData infoData){
        log.info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append("}").toString());
    }
    @SuppressWarnings("rawtypes")
    public static void infoForControllerBegin(Class clazz,InfoData infoData){
        LoggerFactory.getLogger(clazz).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazz.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append("}").toString());
    }
    public static void infoForControllerBegin(String clazzName,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append("}").toString());
    }
    /** info级别 Controller 类方法使用的结束日志公共方法
     * @param log
     * @param infoData  这里面需要修改target和message信息
     */
    public static void infoForControllerEnd(String clazzName,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append("}").toString());
    }
    public static void infoForControllerEnd(org.slf4j.Logger log,InfoData infoData){
        log.info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    @SuppressWarnings("rawtypes")
    public static void infoForControllerEnd(Class clazz,InfoData infoData){
        LoggerFactory.getLogger(clazz).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazz.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    @SuppressWarnings("rawtypes")
    public static void  infoForControllerEnd(String clazzName,String reqId,Object logObj){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append("}").toString());
    }
    /** error级别 Controller 类方法使用的开始日志公共方法
     * @param log
     * @param infoData
     */
    public static void errorForController(org.slf4j.Logger log,InfoData infoData,
                                          String errorCode,String errorMsg){
        log.error("{}",new StringBuffer("{").append(LogInvokePlaceEnum.NORMAL.value)
                .append(LogClassTypeEnum.CONTROLLER.getValue())
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(infoData!=null?infoData.getReqId():"")
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerBegin(infoData))
                .append(",\"errorCode\":\"").append(errorCode)
                .append("\",\"errorMsg\":\"").append(strConvert(errorMsg))
                .append("\"}").toString());
    }



    /** Controller invoke api interface log info
     * @param clazzName
     * @param apiServerIp
     * @param infoData
     */
    public static void infoForControllerInvokeApiBefore(String clazzName,String apiServerIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.CONTROLLER_INVOKE_API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"serverIp\":\"").append(apiServerIp)
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    public static void infoForControllerInvokeApiEnd(String clazzName, String apiServerIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.CONTROLLER_INVOKE_API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"serverIp\":\"").append(apiServerIp)
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    public static void infoForServiceInvokeApiBefore(String clazzName,String apiServerIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.SERVICE_INVOKE_API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"serverIp\":\"").append(apiServerIp)
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    public static void infoForServiceInvokeApiEnd(String clazzName, String apiServerIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.SERVICE_INVOKE_API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"serverIp\":\"").append(apiServerIp)
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    public static void infoForInvokeApiImplBefore(String clazzName,String clientIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info(new StringBuffer("{").append(LogInvokePlaceEnum.BEGIN.value)
                .append(LogClassTypeEnum.API_IMPL_RUNNING.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(clientIp)
                .append("\",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }
    public static void infoForInvokeApiImplEnd(String clazzName,String clientIp,InfoData infoData){
        LoggerFactory.getLogger(clazzName).info(new StringBuffer("{").append(LogInvokePlaceEnum.END.value)
                .append(LogClassTypeEnum.API_IMPL_RUNNING.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(infoData.getReqId())
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"clientIp\":\"").append(clientIp)
                .append("\",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append("\",\"className\":\"").append(clazzName)
                .append("\",\"logObj\":")
                .append(getInfoDataJsonForControllerEnd(infoData))
                .append("}").toString());
    }


    @SuppressWarnings("rawtypes")
    public static void  debug(Class clazz,String reqId,Object logObj){

        LoggerFactory.getLogger(clazz).debug("{}",new StringBuffer("{").append(LogInvokePlaceEnum.NORMAL.value)
                .append(",\"classType\":\"normal\"")
                .append(",\"logLevel\":\"debug\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(clazz.getName())
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append("}").toString());
    }



    @SuppressWarnings("rawtypes")
    @Deprecated
    public static void  error(Class clazz,String reqId,Object logObj,
                              String errorCode,Exception e){
        LoggerFactory.getLogger(clazz).error("{}",new StringBuffer("{").append(LogInvokePlaceEnum.NORMAL.value)
                .append(",\"classType\":\"normal\"")
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append(",\"errorCode\":\"").append(errorCode)
                .append("\",\"errorMsg\":\"").append(getErrorInfoByException(e))
                .append("\"}").toString());
    }
    /** 自己try catch 以后的打印的信息
     * @param log
     * @param reqId
     * @param errorCode
     * @param errorMsg
     */
    @SuppressWarnings("rawtypes")
    @Deprecated
    public static void  error(Class clazz,String reqId,
                              String errorCode,String errorMsg){
        LoggerFactory.getLogger(clazz).error("{}",new StringBuffer("{").append(LogInvokePlaceEnum.NORMAL.value)
                .append(",\"classType\":\"normal\"")
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"errorCode\":\"").append(errorCode)
                .append("\",\"errorMsg\":\"").append(strConvert(errorMsg))
                .append("\"}").toString());
    }

    /** 自己try catch 以后的打印的信息
     * @param clazz 当前要打印的类 class
     * @param logClassTypeEnum  类的类型枚举
     * @param logInvokePlaceEnum 日志调用位置起始结束类型：begin 代表开始调用，end=结束调用，normal代表普通调用日志
     * @param reqId 请求ID
     * @param logObj 最好是继承LogDataBase类的对象如 InfoData
     * @param errorCode 错误码
     * @param e
     */
    @SuppressWarnings("rawtypes")
    public static void  error(Class clazz,LogClassTypeEnum logClassTypeEnum,LogInvokePlaceEnum logInvokePlaceEnum,String reqId,Object logObj,
                              String errorCode,Exception e){
        LoggerFactory.getLogger(clazz).error("{}",new StringBuffer("{").append(logInvokePlaceEnum.getValue())
                .append(logClassTypeEnum.getValue())
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append(",\"errorCode\":\"").append(errorCode)
                .append("\",\"errorMsg\":\"").append(getErrorInfoByException(e))
                .append("\"}").toString());
    }
    /** 自己try catch 以后的打印的信息
     * @param clazz 当前要打印的类 class
     * @param logClassTypeEnum  类的类型枚举
     * @param logInvokePlaceEnum 日志调用位置起始结束类型：begin 代表开始调用，end=结束调用，normal代表普通调用日志
     * @param reqId 请求ID
     * @param errorCode 错误码
     * @param errorMsg   错误信息
     */
    @SuppressWarnings("rawtypes")
    public static void  error(Class clazz,LogClassTypeEnum logClassTypeEnum,LogInvokePlaceEnum logInvokePlaceEnum,String reqId,
                              String errorCode,String errorMsg){
        LoggerFactory.getLogger(clazz).error("{}",new StringBuffer("{").append(logInvokePlaceEnum.getValue())
                .append(logClassTypeEnum.getValue())
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(log.getName())
                .append("\",\"errorCode\":\"").append(errorCode)
                .append("\",\"errorMsg\":\"").append(strConvert(errorMsg))
                .append("\"}").toString());
    }

    /**  开发者自行打印消息info级别公共使用方法
     * @param clazz 当前要打印的类 class
     * @param logClassTypeEnum  类的类型枚举
     * @param logInvokePlaceEnum 日志调用位置起始结束类型：begin 代表开始调用，end=结束调用，normal代表普通调用日志
     * @param reqId 请求ID
     * @param logObj 最好是继承LogDataBase类的对象如 InfoData
     */
    @SuppressWarnings("rawtypes")
    public static void  info(Class clazz,LogClassTypeEnum logClassTypeEnum,LogInvokePlaceEnum logInvokePlaceEnum,String reqId,Object logObj){
        LoggerFactory.getLogger(clazz).info("{}",new StringBuffer("{").append(logInvokePlaceEnum.getValue())
                .append(logClassTypeEnum.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"serverIp\":\"").append(MachineIPInstance.getInstance().getIp())
                .append(",\"className\":\"").append(clazz.getName())
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append("}").toString());
    }
    @SuppressWarnings("rawtypes")
    public static void  info(Class clazz,String reqId,Object logObj){
        LoggerFactory.getLogger(clazz).info("{}",new StringBuffer("{").append(LogInvokePlaceEnum.NORMAL.getValue())
                .append(LogClassTypeEnum.API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(clazz.getName())
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append("}").toString());
    }
    /** 访问第三方API，开发者自行打印消息info级别公共使用方法
     * @param clazz
     * @param logInvokePlaceEnum 日志调用位置起始结束类型：begin 代表开始调用，end=结束调用，normal代表普通调用日志
     * @param apiUrl api调用地址
     * @param reqId 请求ID
     * @param logObj 最好是继承LogDataBase类的对象如 InfoData
     */
    @SuppressWarnings("rawtypes")
    public static void  infoT3Api(Class clazz,LogInvokePlaceEnum logInvokePlaceEnum,String reqId,String apiUrl,Object logObj){
        LoggerFactory.getLogger(clazz).info("{}",new StringBuffer("{").append(logInvokePlaceEnum.getValue())
                .append(LogClassTypeEnum.T3API.getValue())
                .append(",\"logLevel\":\"info\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"className\":\"").append(clazz.getName())
                .append(",\"url\":\"").append(apiUrl)
                .append("\",\"logObj\":")
                .append(getJsonByObj(logObj))
                .append("}").toString());
    }
    /*public static void  error(org.slf4j.Logger log,String reqId,
            String errorCode,String errorMsg){
        log.error(new StringBuffer("#error={").append("\"type\":\"begin\"")
                .append(",\"classType\":\"normal\"")
                .append(",\"logLevel\":\"error\"")
                .append(",\"reqId\":\"").append(reqId)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                 .append(",\"className\":\"").append(log.getName())
                   .append("\",\"errorCode\":\"").append(errorCode)
                 .append("\",\"errorMsg\":\"").append(strConvert(errorMsg))
                 .append("\"}").toString());
     }*/
    private static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    private static String getJsonByObj(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            return "null";
        }

    }
    private static String getInfoDataJsonForControllerBegin(InfoData infoData){
        if(infoData==null){
            return "null";
        }else{
            //StackTraceElement[] temp=Thread.currentThread().getStackTrace();
            return new StringBuffer()
                    .append("{\"methodName\":\"").append(infoData.getMethodName())
                    //.append("\",\"reqId\":\"").append(infoData.getReqId())
                    .append("\",\"token\":\"").append(infoData.getToken())
                    .append("\",\"vin\":\"").append(infoData.getVin())
                    .append("\",\"uid\":").append(infoData.getUid())
                    .append(",\"appId\":\"").append(infoData.getAppId())
                    .append("\",\"aid\":\"").append(infoData.getAid())
                    .append("\",\"mid\":\"").append(infoData.getMid())
                    .append("\",\"source\":\"").append(infoData.getSource())
                    .append("\",\"target\":\"").append(infoData.getTarget())
                    .append("\",\"message\":\"").append(strConvert(infoData.getMessage()))
                    .append("\",\"threadID\":\"").append(infoData.getThreadID())
                    .append("\"}").toString();
        }
    }
    private static String getInfoDataJsonForControllerEnd(InfoData infoData){
        if(infoData==null){
            return "null";
        }else{
            return new StringBuffer()
                    .append("{\"methodName\":\"").append(infoData.getMethodName())
                    //.append("\",\"reqId\":\"").append(infoData.getReqId())
                    .append("\",\"token\":\"").append(infoData.getToken())
                    .append("\",\"vin\":\"").append(infoData.getVin())
                    .append("\",\"uid\":").append(infoData.getUid())
                    .append(",\"appId\":\"").append(infoData.getAppId())
                    .append("\",\"aid\":\"").append(infoData.getAid())
                    .append("\",\"mid\":\"").append(infoData.getMid())
                    .append("\",\"source\":\"").append(infoData.getSource())
                    .append("\",\"target\":\"").append(infoData.getTarget())
                    .append("\",\"message\":\"").append(strConvert(infoData.getMessage()))
                    .append("\",\"threadID\":\"").append(infoData.getThreadID())
                    .append("\"}").toString();
        }
    }
    private static int STACK_OUT_LENGTH=3;
    public static String getErrorInfoByException(Exception e ) {
        if(e==null){
            return "null";
        }
        StringBuffer bf=new StringBuffer();
        if(e instanceof MethodArgumentNotValidException){
            bf.append("message=").append(e.getMessage()).append(getStackInfo(e));
        }else if(e instanceof AppLayerException){
            bf.append("code=").append(((AppLayerException)e).getCode());
            bf.append(";message=").append(e.getMessage()).append(getStackInfo(e));
        }else if( e instanceof ServLayerException){
            String code=((ServLayerException)e).getCode();
            bf.append("service_code=").append(code);
            bf.append(";app_code=").append( new DefaultErrorCodeConvertor().convert(code));
            bf.append(";message=").append(e.getMessage()).append(getStackInfo(e));
        }else{
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            bf.append(" message=").append(e.getMessage());
            bf.append(";stackTrace info=").append(errors.toString());
        }
        return strConvert(bf.toString());
    }
    public static String getStackInfo(Exception e){
        int cnt=0;
        StringBuffer bf=new StringBuffer(";stackTrace info=");
        StackTraceElement[] tracks=e.getStackTrace();
        if(tracks!=null){
            cnt=tracks.length>=STACK_OUT_LENGTH?STACK_OUT_LENGTH:STACK_OUT_LENGTH;
            for(int j = 0; j < cnt; j++)
            {
                bf.append("\tat ").append(tracks[j]);
            }
        }
        return bf.toString();
    }
    /** 将特殊字符进行统一转换
     * @param info
     * @return
     */
    public static String strConvert(String info){
        return info==null||info.length()==0?"":
                info.replaceAll(STR_RETURN, STR_RETURN_TO_NEWSTR)
                        .replaceAll(STR_RETURN_N, STR_RETURN_TO_NEWSTR)
                        .replaceAll(STR_LEFT_SMH, STR_LEFT_SMH_TO_NEWSTR).replaceAll(STR_RIGHT_SMH,STR_RIGHT_SMH_TO_NEWSTR)
                        .replaceAll(STR_SYH, STR_SYH_TO_NEWSTR);
    }

    /** 输出指定模块相关的业务错误码对应信息
     * @param module 模块名称
     * @param code   错误码
     * @param message 错误码信息
     * @param infoObject 具体信息的对象，可以是map或者其他bean对象
     */
    public static void BizErrorCodeInfo(String module,String code,String message,Object infoObject){
        log.error("{}",new StringBuffer("{\"module_code\":\"").append(module).append("_").append("error").append("_").append(code)
                .append("\",\"timestamp\":").append(System.currentTimeMillis())
                .append(",\"message\":\"").append(message)
                .append("\",\"infoObject\":").append(getJsonByObj(infoObject))
                .append("}").toString());
    }
    public static void main(String [] args){
        CommonLoggerUtil.info(CommonLoggerUtil.class, LogClassTypeEnum.API,LogInvokePlaceEnum.BEGIN, "", new InfoData("1",null,"3",null));
        //CommonLoggerUtil.infoForControllerBegin(CommonLoggerFactory.class,new InfoData("1",null,"3",null)) ;
        CommonLoggerUtil.infoForControllerBegin(log,new InfoData("1",null,"3",null)) ;
        //CommonLoggerUtil.infoForControllerBegin(String.class, new InfoData("1",null,"3",null).setAppIdBuild("1222222222")) ;
        CommonLoggerUtil.infoForControllerEnd(String.class, new InfoData("1",null,"3",null)) ;
        CommonLoggerUtil.infoForControllerEnd(log, new InfoData("1",null,"3",null)) ;
        CommonLoggerUtil.infoForInterceptorBefore(log, "11", "11", "1", "2", "3" );
        CommonLoggerUtil.infoForInterceptorEnd(log,  new InfoData("1",null,"3",null)) ;
        try {
            throw new AppLayerException("1212");
        } catch (Exception e) {
            System.out.println("n\"\\\"r="+ CommonLoggerUtil.getErrorInfoByException(e).indexOf(STR_RETURN));
            System.out.println("r\"\\\"n="+ CommonLoggerUtil.getErrorInfoByException(e).indexOf("\r\n"));
            System.out.println("\n="+  CommonLoggerUtil.getErrorInfoByException(e).indexOf("\n"));
            System.out.println("\t="+  CommonLoggerUtil.getErrorInfoByException(e).indexOf("\r"));

        }
        try {
            throw new  Exception("1212");
        } catch (Exception e) {
            System.out.println("n\"\\\"r="+ CommonLoggerUtil.getErrorInfoByException(e).indexOf(STR_RETURN));
            System.out.println("r\"\\\"n="+ CommonLoggerUtil.getErrorInfoByException(e).indexOf("\r\n"));
            System.out.println("\n="+  CommonLoggerUtil.getErrorInfoByException(e).indexOf("\n"));
            System.out.println("\t="+  CommonLoggerUtil.getErrorInfoByException(e).indexOf("\r"));
				/*CommonLoggerUtil.errorForController(log, new InfoData("1",null,"3",null).setAppIdBuild("1222222222"),
						"12323", CommonLoggerUtil.getErrorInfoByException(e));*/
        }

        System.out.println(getJsonByObj(new InfoData("1",null,"3",null).setAppIdBuild("1222222222")));

        System.out.println( new StringBuffer("{leesea==11}").toString().replaceAll("\\{", "1").replaceAll("\\}", "1"));
        CommonLoggerUtil.debug(CommonLoggerUtil.class, "1111", new String("sdfsdf"));
        CommonLoggerUtil.error(Exception.class,LogClassTypeEnum.T3API,LogInvokePlaceEnum.BEGIN, "11",new InfoData("1",null,"3",null).setMessageBuild("sdfasdf"),
                "",new Exception());
    }
    /** 日志调用位置起始结束类型：BEGIN 代表开始调用，END=结束调用，NORMAL=任意调用日志
     * user：rziwc
     * time：2015年11月2日 下午3:14:48
     */
    public enum LogInvokePlaceEnum {
        BEGIN("\"invokePlace\":\"BEGIN\""),
        END("\"invokePlace\":\"END\""),
        NORMAL("\"invokePlace\":\"NORMAL\"");
        private String value;

        private LogInvokePlaceEnum(String value1) {
            this.value = value1;
        }

        public String getValue() {
            return value;
        }
    }
}


