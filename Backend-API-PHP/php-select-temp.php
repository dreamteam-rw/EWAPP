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

                                               
    $sql = "select * from forecast";
   
    if($result = mysqli_query($conn, $sql))
    {
	    while($row = mysqli_fetch_array($result))
	    {
		    $data['district_id'] = $row["district_id"]; 
		    $data['max_temp'] = $row["max_temp"]; 
		    $data['min_temp'] = $row["min_temp"]; 
		    $data['morning'] = $row["morning"]; 
		    $data['afternoon'] = $row["afternoon"]; 
		    $data['evening'] = $row["evening"]; 
                    
		     array_push($fim,$data);

            }

	    header('Content-Type: application/json');
	    echo json_encode($fim);
    }


?>
