package com.wj.test;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	
	

	public AuthInterceptor() {
		super(Phase.INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		//获取SOAP请求消息头
		System.out.println("server handleMessage()");
		List<Header> headers = msg.getHeaders();
		if(null == headers || headers.size() < 0) {
			throw new Fault(new IllegalArgumentException("没有Header,拦截器实施拦截")); 
		}
		boolean isAuth = false;
		for(Header header:headers) {
			if(header != null) {
				Element element = (Element) header.getObject();
				if(null != element && "auth".equals(element.getTagName())) {
					NodeList usernameEle = element.getElementsByTagName("username");
					NodeList passwordEle = element.getElementsByTagName("password");
					
					if(null == usernameEle || usernameEle.getLength() > 1) {
						 throw new Fault(new IllegalArgumentException("用户名格式不对")); 
					}
					
					if(null == passwordEle || passwordEle.getLength() > 1) {
						 throw new Fault(new IllegalArgumentException("用户密码格式不对")); 
					}
					
					String username = usernameEle.item(0).getTextContent();
					String password = passwordEle.item(0).getTextContent();
					
					if(!"test".equals(username) || !"123".equals(password)) {
						throw new Fault(new IllegalArgumentException("用户名或密码不正确")); 
					}
					isAuth = true;
					break;
				}
			}
		}
		
		if(!isAuth) {
			throw new Fault(new IllegalArgumentException("没有认证")); 
		}
		
	}

}
