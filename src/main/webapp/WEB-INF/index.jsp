<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){         
    $('#kaptchaImage').click(function () {//生成验证码  
     $(this).hide().attr('src', '/jpg?' + Math.floor(Math.random()*100) ).fadeIn();  
     event.cancelBubble=true;  
    });  
});   
  
  
window.onbeforeunload = function(){  
    //关闭窗口时自动退出  
    if(event.clientX>360&&event.clientY<0||event.altKey){     
        alert(parent.document.location);  
    }  
};  
  
  
function changeCode() {  
    $('#kaptchaImage').hide().attr('src', '/jpg?' + Math.floor(Math.random()*100) ).fadeIn();  
    event.cancelBubble=true;  
} 
</script>
</head>
<body>
	<img src="/jpg" id="kaptchaImage"  style="margin-bottom: -3px"/>  
	<a href="#" onclick="changeCode()">看不清?换一张</a> 
</body>
</html>