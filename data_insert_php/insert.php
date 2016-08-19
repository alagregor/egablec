<?php

$target_dir = "uploads/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
// Check if image file is a actual image or fake image
if(isset($_POST["submit"])) {
    $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
    if($check !== false) {
        echo "File is an image - " . $check["mime"] . ".";
        $uploadOk = 1;
    } else {
        echo "File is not an image.";
        $uploadOk = 0;
    }
}

$link = mysqli_connect("localhost", "srlenet_air", "speedy1989Z", "srlenet_air");
 
// Check connection
if($link === false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
 
// Escape user inputs for security
$gablec_title = mysqli_real_escape_string($link, $_POST['gablec_title']);
$gablec_desc = mysqli_real_escape_string($link, $_POST['gablec_desc']);
$gablec_price = mysqli_real_escape_string($link, $_POST['gablec_price']);
$gablec_date = mysqli_real_escape_string($link, $_POST['gablec_date']);
$restaurant_title = mysqli_real_escape_string($link, $_POST['restaurant_title']);
$restaurant_adress = mysqli_real_escape_string($link, $_POST['restaurant_adress']);
$restaurant_phone = mysqli_real_escape_string($link, $_POST['restaurant_phone']);
$mail = mysqli_real_escape_string($link, $_POST['mail']);
$image_file = basename( $_FILES["fileToUpload"]["name"]);
 
// attempt insert query execution
$sql = "INSERT INTO gableci (gablec_title, gablec_desc, gablec_price, gablec_date, restaurant_title, restaurant_adress, restaurant_phone, mail, image) VALUES ('$gablec_title', '$gablec_desc', '$gablec_price', '$gablec_date', '$restaurant_title', '$restaurant_adress', '$restaurant_phone', '$mail', '$image_file')";
if(mysqli_query($link, $sql) && move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)){
    echo "Records added successfully.";

    echo "<a href='javascript:history.go(-1)'>Add another gablec</a>";

    //write records to json file
    $sql_where = "SELECT * FROM gableci";
		
	$result = $link->query($sql_where);
	$res = array();

	if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
			array_push($res,array(
				"id"=>$row['id'],
				"gablec_title"=>$row['gablec_title'],
				"gablec_desc"=>$row['gablec_desc'],
				"gablec_price"=>$row['gablec_price'],
				"gablec_date"=>$row['gablec_date'],
				"restaurant_title"=>$row['restaurant_title'],
				"restaurant_adress"=>$row['restaurant_adress'],
				"restaurant_phone"=>$row['restaurant_phone'],
				"mail"=>$row['mail'],
				"image"=>$row['image']
				)
			);
		}
	} 
	$file = 'JSON/gableci.json';
	// Write the contents back to the file
	file_put_contents($file, json_encode(array("result"=>$res)));

} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 
// close connection
mysqli_close($link);
?>