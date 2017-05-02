<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to Login</title>
</head>
<!-- copy css folder and paste it on project   -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<body style="background-color: #e9eaed">

	<%
		String errorMessage = request.getParameter("error");
	%>

	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h1 class="text-center">LOGIN</h1>
					<br>
					<%
						if (errorMessage != null) {
					%>
					<h4 style="color: red" class="text-center">username or
						password incorrect !!</h4>
					<%
						}
					%>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" action="CheckLogin"
						method="post">
						<div class="form-group">
							<input type="text" class="form-control input-lg"
								placeholder="username" name="username">
						</div>
						<div class="form-group">
							<input type="password" class="form-control input-lg"
								placeholder="password" name="password">
						</div>

						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block" type="submit">LOGIN</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12">
						<button class="btn btn-success" data-dismiss="modal"
							aria-hidden="true" onclick="window.location.href='#'">Home</button>
						<button class="btn btn-success" data-dismiss="modal"
							aria-hidden="true" onclick="window.location.href='#'">Register</button>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>