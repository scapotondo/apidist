<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>
	
 	<div class="login">
		<h1>Login</h1>
	    <form method="post" action="${pageContext.request.contextPath}/Login">
	    	<input type="text" name="usuario" placeholder="Username" required="required" />
	        <input type="password" name="password" placeholder="Password" required="required" />
	
	        <button type="submit" class="btn btn-primary btn-block btn-large">Ingresar</button>
	    </form>
	</div>
  
    <script src="js/index.js"></script>
  
</body>
</html>
