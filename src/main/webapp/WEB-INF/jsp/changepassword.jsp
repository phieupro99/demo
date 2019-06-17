<html>
	<head>
			
			<title> Change Password</title>
			<link rel="stylesheet" href="css/login.css">

	</head>
	<body class="bodydata">
		<form id="login-form" action="changepassword/update" method="POST">
		
			<input type="text" placeholder="username" name="usernamesss"   class="inputtext username">
			<input type="password" placeholder="old password"  name="oldpassword"  class="inputtext password">
			<input type="password" placeholder="new password"  name="newpassword"  class="inputtext password">
			<input type="password" placeholder="confirm new password"  name="confnewpassword"  class="inputtext password">
            <input type="submit" class="submitdata" value="CHANGE PASSWORD"/>
		</form>
	</body>
</html>
