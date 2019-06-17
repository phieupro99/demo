
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="image/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="image/img-01.png" alt="IMG">
				</div>

				<div class="login100-form validate-form">
					<span class="login100-form-title"> Member Register </span> <span
						id="message" style="color: green;"></span> <span id="messageError"
						style="color: red;"></span>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" placeholder="Full Name"
							id="fullname"> <span class="focus-input100"></span> <span
							class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" placeholder="Username"
							id="username"> <span class="focus-input100"></span> <span
							class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="email" placeholder="Email Address"
							id="email"> <span class="focus-input100"></span> <span
							class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>	
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" placeholder="Phone Number"
							id="phonenumber"> <span class="focus-input100"></span> <span
							class="symbol-input100"> <i class="fa fa-envelope"
							aria-hidden="true"></i>
						</span>
					</div>	
						
					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" placeholder="Password"
							id="password"> <span class="focus-input100"></span> <span
							class="symbol-input100"> <i class="fa fa-lock"
							aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="password"
							placeholder="Re-Type Password" id="password2"> <span
							class="focus-input100"></span> <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					<button class="login100-form-btn" id="registerBtn" name="submit">
						Register</button>

					<div class="text-center p-t-136">
						<a class="txt2" href="login"> Already have a acount? <i
							class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!--===============================================================================================-->
	<script src="javascript/jquery-3.3.1.min.js"></script>
	<script>
		$("#registerBtn").click(function() {
			var username = $('#username').val();
			var password = $('#password').val();
			var email = $('#email').val();
			var phonenumber = $('#phonenumber').val();
			var fullname = $('#fullname').val();
			var password2 = $('#password2').val();
			if (password == password2) {
				$.ajax({
					method : "POST",
					url : "register/add",
					data : {
						"username" : username,
						"password" : password,
						"fullname" : fullname,
						"email"    : email,
						"phonenumber": phonenumber
					}
				}).done(function(msg) {
					$("#message").text(msg);
					$("#messageError").text("");
				});
			} else {
				$("#messageError").text("Password is not matched.");
			}

		});
	</script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>


	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="javascript/main.js"></script>

</body>
</html>




























