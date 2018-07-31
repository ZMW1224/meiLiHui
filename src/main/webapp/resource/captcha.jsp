<span style="font-size:18px;"><%@ page language="java" contentType="text/html; charset=UTF-8"
                                       pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>

<title>测试页面</title>
</head>
<body>

<div class="form-group">
    <div class="row">
        <div class="col-sm-8">
            <input type="text" id="code" class="form-control" placeholder="验证码" data-toggle="tooltip" data-placement="top">
        </div>
        <div class="col-sm-4">
            <img id="codeImg" src="http://localhost:8080/sys/captcha" class="img-responsive" style="display: block;width:100%;height: 32px">
        </div>
    </div>
</div>
</body>
</html>
</span>
