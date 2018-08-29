package com.wj.test;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.message.Message;

import com.wj.ws.HelloWSImpl;

/**
 * 拦截器
 * @author 24253
 *
 */
public class ServerTest3 {
	
	public static void main(String[] args) {
		
		String address = "http://localhost:8090/ws/hellows";
		Endpoint publish = Endpoint.publish(address, new HelloWSImpl());
//		System.out.println(publish);
		EndpointImpl endpointImpl = (EndpointImpl) publish;
		
		//服务器端的入拦截器
		List<Interceptor<? extends Message>> inInterceptors = endpointImpl.getInInterceptors();
		inInterceptors.add(new AuthInterceptor());
		//添加拦截器
		inInterceptors.add(new LoggingInInterceptor());
		//服务器端的出拦截器
		List<Interceptor<? extends Message>> outInterceptors = endpointImpl.getOutInterceptors();
		outInterceptors.add(new LoggingOutInterceptor());
		System.out.println("Webservice发布成功");
	}
}
