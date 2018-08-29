package com.wj.test;

import com.wj.ws.HelloWS;
import com.wj.ws.HelloWSImplService;

public class Test {

	public static void main(String[] args) {
		HelloWSImplService ws = new HelloWSImplService();
		HelloWS helloWS = ws.getHelloWSImplPort();
		String sayHello = helloWS.sayHello("name");
		System.out.println(sayHello);
	}
}
