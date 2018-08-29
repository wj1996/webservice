package com.wj.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * SEI
 * @author 24253
 *
 */
@WebService
public interface HelloWS {

	@WebMethod
	public String sayHello(String name);

}
