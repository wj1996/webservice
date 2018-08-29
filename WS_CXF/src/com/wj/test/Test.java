package com.wj.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String encode = URLEncoder.encode("中", "utf-8");
		System.out.println(encode); //%E4%B8%AD
		String encode2 = URLEncoder.encode("中", "gbk");
		System.out.println(encode2); //%D6%D0
	}
}
