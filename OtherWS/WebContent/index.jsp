<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function reqWebService(){
		var xhq = getXmlHttpObject();
		xhq.onreadystatechange = function(){
			/* alert(xhq.readyState + "--" + xhq.status); */
			if(xhq.readyState == 4 && xhq.status == 200){
				/* alert(2); */
				var result = xhq.responseXML;
				alert(result);
			}
		};
		var name = document.getElementById('username').value;
		var data = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Header><auth><username>test</username><password>123</password></auth></soap:Header><soap:Body><ns2:sayHello xmlns:ns2="http://ws.wj.com/"><arg0>' + name +
		'</arg0></ns2:sayHello></soap:Body></soap:Envelope>';
		xhq.open("POST","http://192.168.1.167:8990/ws/hellows");
		xhq.setRequestHeader("Content-Type","text/html;charset=utf-8");
		xhq.send(data);
	}


	function getXmlHttpObject(){
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp=new XMLHttpRequest();
		}
		else
		{
		    // IE6, IE5 浏览器执行代码
		    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		return xmlhttp;
		
	}
</script>
</head>
<body>
	用户名：<input type="text" id="username" name="username" /><br/>
	<button onclick="reqWebService()">Ajax请求WebService</button>
	
</body>
</html>