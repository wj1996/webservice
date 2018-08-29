package com.wj.test;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class AddUserInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	private String username;
	private String password;
	
	public AddUserInterceptor(String username,String password) {
//		super(Phase.PRE_PROTOCOL); //准备协议时拦截
		super(Phase.PREPARE_SEND);
		this.username = username;
		this.password = password;
	}

	/**
	 * 请求体
	 * 	<Envelope>
	 * 		<head>
	 * 			<auth>
	 * 				<username>test</username>
	 * 				<password>123</password>
	 * 			</auth>
	 * 		</head>
	 * 		<Body>
	 * 			<sayHello>
	 * 				<arg0>Tom</arg0>
	 * 			</sayHello>
	 * 		</Body>
	 * 	</Envelope>
	 * @param arg0
	 * @throws Fault
	 */
	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		List<Header> headers = msg.getHeaders();
//		Document document = DocumentHelper.createDocument();
		Document document = DOMUtils.createDocument();
		Element auth = document.createElement("auth");
		Element usernameEle = document.createElement("username");
		Element passwordEle = document.createElement("password");
		
		usernameEle.setTextContent(username);
		passwordEle.setTextContent(password);
		
		auth.appendChild(usernameEle);
		auth.appendChild(passwordEle);
		
		headers.add(new SoapHeader(new QName(""),auth));
		
		System.out.println("client handleMessage()");
	}

}
