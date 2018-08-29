package com.wj.test;

import javax.xml.ws.Endpoint;

import com.wj.ws.HelloWSImpl;

/**
 * 发布Webservice
 * @author 24253
 *
 */
public class ServerTest {

	public static void main(String[] args) {
		
		String address = "http://192.168.1.167:8989/ws/hellows";
		Endpoint.publish(address, new HelloWSImpl());
		System.out.println("Webservice发布成功");
	}
	
}
