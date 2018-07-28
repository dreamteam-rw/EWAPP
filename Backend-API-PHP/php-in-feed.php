<?php

 session_start(); // Starting Session
 $servername = "node2.oneacrefund.org";
 $username = "root";
 $password = "blablableble";
 $dbname = "meteomidmarp";


 // Create connection
 $conn = mysqli_connect($servername, $username, $password, $dbname);
 // // Check connection
 if (!$conn) 
 {
    die("Connection failed: " . mysqli_connect_error());
 }  

 	$content = $_REQUEST['content'];
	$id = $_REQUEST['userid'];


    $sql = "insert into feedback (content,sector_id,user_id) values ('$content',$id,3);";


    if($result = mysqli_query($conn, $sql))
    {

  		header('Content-Type: application/json');
		echo "Ok";       
		echo json_encode($data);
    }
 

?>
