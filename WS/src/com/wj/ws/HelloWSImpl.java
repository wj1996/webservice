package com.wj.ws;

import javax.jws.WebService;

/**
 * SEI实现
 * @author 24253
 *
 */
@WebService
public class HelloWSImpl implements HelloWS {

	@Override
	public String sayHello(String name) {
		System.out.println("server调用sayHello()" + name);
		return "Hello " + name;
	}

}
