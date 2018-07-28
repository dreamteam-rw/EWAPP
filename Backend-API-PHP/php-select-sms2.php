<?php

 session_start(); // Starting Session
 $servername = "node2.oneacrefund.org";
 $username = "root";
 $password = "blablableble";
 $dbname = "meteomidmarp";
 
 $data = array();
 $fim = array();

 // Create connection
 $conn = mysqli_connect($servername, $username, $password, $dbname);
 // // Check connection
 if (!$conn) 
 {
    die("Connection failed: " . mysqli_connect_error());
 }  

                                               
    $sql = "select * from sms where source='midimar' order by date LIMIT 3";
   
    if($result = mysqli_query($conn, $sql))
    {
	    while($row = mysqli_fetch_array($result))
	    {
		    $data['sms_id'] = $row["sms_id"]; 
		    $data['sector_id'] = $row["sector_id"]; 
		    $data['date'] = $row["date"]; 
		    $data['messagebody'] = $row["messagebody"]; 
                    
		     array_push($fim,$data);

            }

	    header('Content-Type: application/json');
	    echo json_encode($fim);
    }


?>
