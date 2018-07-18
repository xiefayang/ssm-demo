package com.study.ssm.demo.util;

import java.beans.BeanInfo;  
import java.beans.Introspector;  
import java.beans.PropertyDescriptor;  
import java.lang.reflect.Method;  

//通过Introspector类修改属性

/**
 * 
 * @author xiexie
 *
 */
public class BeanInfoUtil02 {  
    public static void setPropertyByIntrospector(Student userInfo,  
            String userName) throws Exception {  

        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);  
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();  
        if (proDescrtptors != null && proDescrtptors.length > 0) {  
            for (PropertyDescriptor propDesc : proDescrtptors) {  
                if (propDesc.getName().equals(userName)) {  
                    Method methodSetUserName = propDesc.getWriteMethod();  
                    methodSetUserName.invoke(userInfo, "alan");  
                    System.out  
                            .println("set userName:" + userInfo.getUserName());  
                    break;  
                }  
            }  
        }  
    }  

    public static void getPropertyByIntrospector(Student userInfo,  
            String userName) throws Exception {  
        BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);  
        PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();  
        if (proDescrtptors != null && proDescrtptors.length > 0) {  
            for (PropertyDescriptor propDesc : proDescrtptors) {  
                if (propDesc.getName().equals(userName)) {  
                    Method methodGetUserName = propDesc.getReadMethod();  
                    Object objUserName = methodGetUserName.invoke(userInfo);  
                    System.out  
                            .println("get userName:" + objUserName.toString());  
                    break;  
                }  
            }  
        }  
    }  

}  