<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript">  
  
function reqWebService(){  
      
    var name=document.getElementById("name").value;  
    //获取XMLHttpRequest  
    var request=GetXmlHttpObject();  
    //设置回调函数  
    request.onreadystatechange=function(){  
        if(request.readyState==4 && request.status==200)  
        {  
            var result=request.responseXML;  
            alert(result);  
            var returnEle=result.getElementsByTagName("return")[0];  
            var value=returnEle.firstChild.data;  
            alert(value);  
        }  
    }  
      
    //打开连接  
    request.open("POST","http://localhost:8090/ws/hellows");  
  /*   request.setRequestHeader("Access-Control-Allow-Origin","*"); */
    //设置请求头  
   /*  request.setRequestHeader("Content-type","application/x-www-form-urlencoded");  */
    var data = '<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"><soap:Header><auth><username>test</username><password>123</password></auth></soap:Header><soap:Body><ns2:sayHello xmlns:ns2="http://ws.wj.com/"><arg0>name</arg0></ns2:sayHello></soap:Body></soap:Envelope>';
    request.send(data);  
      
      
}  
  
  
  
function GetXmlHttpObject()  
{  
  var xmlHttp=null;  
  try  
    {  
    // Firefox, Opera 8.0+, Safari  
    xmlHttp=new XMLHttpRequest();  
    }  
  catch (e)  
    {  
    // Internet Explorer  
    try  
      {  
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");  
      }  
    catch (e)  
      {  
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");  
      }  
    }  
  return xmlHttp;  
}  
</script>  
</head>  
<body>  
用户名:<input id="name" name ="username" value="" />  
<button onclick="reqWebService()">Ajax请求webservice</button>  
</body>  

</body>
</html>