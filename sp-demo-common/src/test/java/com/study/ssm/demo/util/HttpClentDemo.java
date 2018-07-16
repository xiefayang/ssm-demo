package com.study.ssm.demo.util;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

public class HttpClentDemo {

	public static void main(String[] args) {
		String urlHttps="https://www.cnblogs.com/javacatalina/p/6641338.html";
		String urlHttp="https://www.baidu.com/";
//		new String[urlHttps,urlHttp];
//		String [] strs={urlHttps,urlHttp};
		String [] strs={urlHttp};
		for (String string : strs) {
			
			if(HttpUtil.isHttps(string)){
				HttpRequest httpRequest = new HttpRequest(string);
				httpRequest.header("Authorization", "1234");
//				httpRequest.setSSLProtocol(SSLSocketFactoryBuilder.SSL);
				HttpResponse execute = httpRequest.execute();
				System.out.println(execute.getStatus());
				System.out.println(execute.body());
				System.out.println("=========");
			}else {
				HttpRequest httpRequest = new HttpRequest(string);
				HttpResponse execute = httpRequest.execute();
				System.out.println(execute.getStatus());
				System.out.println(execute.body());
				System.out.println("!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
}
