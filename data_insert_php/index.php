<?php
   ob_start();
   session_start();
?>

<html lang="en">
   
	<head>
		<title>eGablec</title>
		<link href="style.css" rel="stylesheet">
	</head>

	<body>  
		<div class="container form-signin">
	         
			<?php
			$msg = '';
			$form_show = true;

			if (isset($_POST['login']) && !empty($_POST['username']) && !empty($_POST['password'])) {

				if ($_POST['username'] == 'admin' && $_POST['password'] == 'adminpass') {
					$form_show = false;
					$_SESSION['valid'] = true;
					$_SESSION['timeout'] = time();
					$_SESSION['username'] = 'admin';
				} else {
					$msg = 'Wrong username or password';
				}
			}
			?>
		</div> <!-- /container -->

		<?php if($form_show == true) { ?>
	      
		<div class = "container">
		<h2>Login to eGablec</h2>
			<form class="form-signin" role="form" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" method="post">
				<h4 class="form-signin-heading"><?php echo $msg; ?></h4>
				<input type="text" class="form-control" name="username" placeholder="username" required autofocus></br>
				<input type="password" class="form-control" name="password" placeholder="password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit" name="login">Login</button>
			</form>

		</div>

		<?php } else { ?>
				<h2>Insert gablec data</h2>
				<form class="form-signin" action="insert.php" method="post" enctype="multipart/form-data">
					<p>Upload image:</p> 
					<input type="file" name="fileToUpload" id="fileToUpload" required="required">
					<input class="form-control" type="text" name="gablec_title" placeholder="Gablec title" required="required">
					<input class="form-control" type="text" name="gablec_desc" placeholder="Gablec description" required="required">
					<input class="form-control" type="text" name="gablec_price" placeholder="Gablec price" required="required">
					<input class="form-control" type="text" name="gablec_date" placeholder="Gablec date" required="required">
					<input class="form-control" type="text" name="restaurant_title" placeholder="Restaurant title" required="required">
					<input class="form-control" type="text" name="restaurant_adress" placeholder="Restaurant adress" required="required">
					<input class="form-control" type="text" name="restaurant_phone" placeholder="Restaurant phone" required="required">
					<input class="form-control" type="text" name="mail" placeholder="Mail" required="required">
					<input type="submit" value="Submit">
					<br />
					<a href="logout.php" tite="Logout">Logout</a>
				</form>
		<?php } ?>

   </body>
</html>