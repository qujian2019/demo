<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="=UTF-8">
<title>登录</title>
<link href="<%=request.getContextPath()%>/r3/css/layui.css"
	type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/r3/layui/css/login.css"
	type="text/css" rel="stylesheet" />
</head>

<body class="beg-login-bg">
	<div class="beg-login-box">
		<header>
			<h1>后台登录</h1>
		</header>
		<div class="beg-login-main">
			<form action="/manage/login" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden"
					value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
				<div class="layui-form-item">
					<label class="beg-login-icon"> <!-- <i class="layui-icon">&#xe612;</i>-->
					</label> <input type="text" name="userName" lay-verify="userName"
						autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<label class="beg-login-icon"> <!-- <i class="layui-icon">&#xe642;</i>-->

					</label> <input type="password" name="password" lay-verify="password"
						autocomplete="off" placeholder="这里输入密码" class="layui-input">
				</div>
				<div class="layui-form-item">
					<div class="beg-pull-left beg-login-remember">
						<label>记住帐号？</label> <input type="checkbox" name="rememberMe"
							value="true" lay-skin="switch" checked title="记住帐号">
					</div>
					<div class="beg-pull-right">
						<button class="layui-btn layui-btn-primary" lay-submit
							lay-filter="login">
							<!--<i class="layui-icon">&#xe650;</i> -->
							登录
						</button>
					</div>
					<div class="beg-clear"></div>
				</div>
			</form>
		</div>
		<footer>
			<p>Beginner © www.zhengjinfan.cn</p>
		</footer>
	</div>
	<script src="<%=request.getContextPath()%>/r3/jquery/jquery-2.2.4.js"
		type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/r3/layui/layui.js"></script>
	<script>
			layui.use(['layer', 'form'], function() {
				var layer = layui.layer,
					$ = layui.jquery,
					form = layui.form();
					
				form.on('submit(login)',function(data){
					
					location.href='index.html';
					return false;
				});
			});
		</script>
</body>


</script>
</html>