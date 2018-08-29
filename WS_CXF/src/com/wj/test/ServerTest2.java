package com.wj.test;

import javax.xml.ws.Endpoint;

import com.wj.ws.DataTypeWSImpl;

public class ServerTest2 {

	public static void main(String[] args) {
		String address = "http://localhost:8990/ws/dataType";
		Endpoint.publish(address, new DataTypeWSImpl());
		System.out.println("发布WebService成功");
	}
	
}
