package com.wj.test;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.wj.ws.HelloWS;
import com.wj.ws.HelloWSImplService;
/**
 * 客户端使用拦截器
 * @author 24253
 *
 */
public class Test2 {

	public static void main(String[] args) {
		HelloWSImplService ws = new HelloWSImplService();
		HelloWS helloWS = ws.getHelloWSImplPort();
		
		//发送请求的客户端对象
		Client client = ClientProxy.getClient(helloWS);
		//日志出拦截器
//		client.getInInterceptors().add(new LoggingInInterceptor());
		//日志入拦截器
//		client.getOutInterceptors().add(new LoggingOutInterceptor());
		
		client.getOutInterceptors().add(new AddUserInterceptor("test","123"));
		
		String sayHello = helloWS.sayHello("name");
		System.out.println(sayHello);
	}
}
