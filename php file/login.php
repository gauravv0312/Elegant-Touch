<?php
 
 $conn =mysqli_connect("localhost","root","");
 mysqli_select_db($conn,"elegant_touch");

 $email=trim($_POST["email"]);
 $password=trim($_POST["password"]);

 $query = "select * from tbl_user where email ='$email' and password= MD5('$password')";
 $raw = mysqli_query($conn,$query);

 $count= mysqli_num_rows($raw);
 if($count>0)
 {
     $response['message'] ='Exist';
 }
 else
 {
     $response['message']= "Check your password";
 }

    echo json_encode($response);
?>