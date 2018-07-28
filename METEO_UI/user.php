

<?php
	include 'core/dboperation.php';
    $dbaction = new dboperation();
    if(isset($_POST['generate_text'])){

		$firestname="bojos";
		$lastname="kaghusa";

       $fields = array(
                    'First_name' => $firestname,
                    'Last_name' => $lastname
                     );

       $tablename='user';
       //echo $fields[0];

       echo $dbaction->insert($tablename,$fields);
       
    }








?>
<html>
<body>
<div id="wrapper">
 <form method="post" action="">
   <input type="text" name="name">
   <input type="text" name="lname">
   <input type="submit" name="generate_text" value="Generate">
 </form>
</div>
</body>
</html>

