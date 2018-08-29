package com.wj.test;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class Test {

	public static void main(String[] args) {
		WeatherWS ws = new WeatherWS();
		WeatherWSSoap soap = ws.getWeatherWSSoap();
		ArrayOfString weather = soap.getWeather("º¼ÖÝ", null);
		List<String> list = weather.getString();
		System.out.println(list);
		
		MobileCodeWS ws2 = new MobileCodeWS();
		MobileCodeWSSoap soap2 = ws2.getMobileCodeWSSoap();
		String mobileCodeInfo = soap2.getMobileCodeInfo("15236730688", null);
		System.out.println(mobileCodeInfo);
		
	}
}
