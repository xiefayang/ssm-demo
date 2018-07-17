package com.study.ssm.demo.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
	
   public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException, NoSuchMethodException, SecurityException, InstantiationException {
	   reflect01();
	   
	}
	 
	public static void reflect01() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException{
		 Student student = new Student();
		 student.setId(122L);
		 student.setAddress("???");
		 student.setMobilePhone("12345");
		 student.setPassword("23332");
		 student.setUserName("????");
		 Class<? extends Student> class1 = student.getClass();
		 Field[] declaredFields = class1.getDeclaredFields();
		 for (Field field : declaredFields) {
			 String name = field.getName();
			 field.setAccessible(true);
			 Object object = field.get(student);
			 System.out.println("??????="+name+"===="+"?????="+object);
			 System.out.println("============");
		 }
		 Constructor<? extends Student> constructor = class1.getConstructor(null);
		 Student newInstance = constructor.newInstance(null);
		 System.out.println("newInstance=="+newInstance);
	}
	
	public static void reflect02() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		 Student student = new Student();
		 student.setId(122L);
		 student.setAddress("????");
		 student.setMobilePhone("12345");
		 student.setPassword("23332");
		 student.setUserName("????");
		 BeanInfo beanInfo = Introspector.getBeanInfo(student.getClass());
		 PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		 for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			 String name = propertyDescriptor.getName();//??????
			 Method readMethod = propertyDescriptor.getReadMethod();
			 Object invoke = readMethod.invoke(student);
			 String string = invoke.toString();
			 System.out.println("??????="+name+"===="+"?????="+string);
			 System.out.println("============");
		}
	}
}












