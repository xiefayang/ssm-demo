package com.study.ssm.demo.util;

import java.beans.PropertyDescriptor;  
import java.lang.reflect.Method;  

//通过PropertyDescriptor修改属性方式
public class BeanInfoUtil01 {  
    public static void setProperty(Student userInfo,String userName)throws Exception{  
        PropertyDescriptor propDesc=new PropertyDescriptor(userName,Student.class);  
        Method methodSetUserName=propDesc.getWriteMethod();  
        methodSetUserName.invoke(userInfo, "wong");  
        System.out.println("set userName:"+userInfo.getUserName());  
    }  

    public static void getProperty(Student userInfo,String userName)throws Exception{  
        PropertyDescriptor proDescriptor =new PropertyDescriptor(userName,Student.class);  
        Method methodGetUserName=proDescriptor.getReadMethod();  
        Object objUserName=methodGetUserName.invoke(userInfo);  
        System.out.println("get userName:"+objUserName.toString());  
    }  

}  