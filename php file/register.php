<?php

    
    $conn = mysqli_connect("localhost","root","");
    mysqli_select_db($conn,"elegant_touch");

            $name = trim($_POST["name"]);
            $email = trim($_POST["email"]);
            $password = trim($_POST["password"]);
            $mobile= trim($_POST["mobile"]);
           $address = trim($_POST["address"]);


            $query = "select * from tbl_user where email ='$email'";
            $raw = mysqli_query($conn,$query);

            $count = mysqli_num_rows($raw);
            if($count > 0){
                $response['message'] = 'exist';
            }
            else{
                $query2 = "INSERT INTO `tbl_user` (`id`, `name`, `email`, `password`, `mobile`, `address`) 
                VALUES (NULL, '$name', '$email', MD5('$password'), '$mobile', '$address')";

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