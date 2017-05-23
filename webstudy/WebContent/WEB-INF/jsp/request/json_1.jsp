<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script type="text/javascript">
function createXMLHttpRequest(){
  // See http://en.wikipedia.org/wiki/XMLHttpRequest
  // Provide the XMLHttpRequest class for IE 5.x-6.x:
  if( typeof XMLHttpRequest == "undefined" ) XMLHttpRequest = function() {
    try { return new ActiveXObject("Msxml2.XMLHTTP.6.0") } catch(e) {}
    try { return new ActiveXObject("Msxml2.XMLHTTP.3.0") } catch(e) {}
    try { return new ActiveXObject("Msxml2.XMLHTTP") } catch(e) {}
    try { return new ActiveXObject("Microsoft.XMLHTTP") } catch(e) {}
    throw new Error( "This browser does not support XMLHttpRequest." )
  };
  return new XMLHttpRequest();
}
 
var AJAX = createXMLHttpRequest();
 
function handler() {
  if(AJAX.readyState == 4 && AJAX.status == 200) {
      var json = eval('(' + AJAX.responseText +')');
      alert('Success. Result: name => ' + json.name + ',' + 'balance => ' + json.balance);
  }else if (AJAX.readyState == 4 && AJAX.status != 200) {
    alert('Something went wrong...');
  }
}
 
function show(){
  AJAX.onreadystatechange = handler;
  AJAX.open("GET", "service.jsp");
  AJAX.send("");
};
</script>
 
  <a href="/webstudy/json_2"  s> json_2 페이지</a>
  <br/><br/>
  <a href="/webstudy/json_3"  s> json_3 페이지</a>
  <br/><br/>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP_JSON</title>
</head>
<body>

</body>
</html>