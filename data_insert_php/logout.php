<?php
	session_start();
	unset($_SESSION["username"]);
	unset($_SESSION["password"]);
	session_destroy();
	header('Refresh: 2; URL = index.php');
?>