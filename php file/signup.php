<<?php
$conn = mysqli_connect("localhost","root","");
mysqli_select_db($conn,"elegant_touch");

		$name = trim($_POST["name"]);
		$email = trim($_POST["email"]);
		$mobile= trim($_POST["mobile"]);
	    $password= trim($_POST["password"]);


		$query = "select * from user_registration where email ='$email'";
		$raw = mysqli_query($conn,$query);

		$count = mysqli_num_rows($raw);
		if($count > 0){
			$response['message'] = 'exist';
		}
		else{
			$query2 = "INSERT INTO `user_registration` (`id`, `name`, `email`,`mobile`,`password`) 
			VALUES (NULL, '$name', '$email', '$mobile',MD5('$password'))";

			$res = mysqli_query($conn,$query2);
			if($res == true){
				$response['message'] = 'inserted';
			}
			else{
				$response['message'] = 'Failed';
			}

		}

	echo json_encode($response);
?>