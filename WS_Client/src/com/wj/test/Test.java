package com.wj.test;

import com.wj.ws.HelloWSImpl;
import com.wj.ws.HelloWSImplService;

/**
 * 调用WebService
 * @author 24253
 *
 */
public class Test {

	public static void main(String[] args) {
		HelloWSImplService factory = new HelloWSImplService();
		HelloWSImpl h = factory.getHelloWSImplPort();
		System.out.println(h.getClass());
		
		String result = h.sayHello("jack");
		System.out.println(result);
	}
}
