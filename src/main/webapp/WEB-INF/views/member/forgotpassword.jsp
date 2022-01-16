<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/head.jsp"%>
<title>Finewiki | Forgot Password</title>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="${path}/"><b>Finewiki</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">비밀 번호를 잊어버리셨습니까? 여기서 새 비밀번호를 설정하세요</p>
				<form action="${path}/member/forgotPost" method="post">
					<div class="input-group mb-3">
						<input type="email" class="form-control" placeholder="Email">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary btn-block">Request
								new password</button>
						</div>
						<!— /.col —>
					</div>
				</form>

				<p class="mt-3 mb-1">
					<a href="login.html">Login</a>
				</p>
				<p class="mb-0">
					<a href="register.html" class="text-center">Register a new
						membership</a>
				</p>
			</div>
			<!— /.login-card-body —>
		</div>
	</div>
	<!— /.login-box —>

	<!— jQuery —>
	<script src="../../plugins/jquery/jquery.min.js"></script>
	<!— Bootstrap 4 —>
	<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!— AdminLTE App —>
	<script src="../../dist/js/adminlte.min.js"></script>
</body>
</html>