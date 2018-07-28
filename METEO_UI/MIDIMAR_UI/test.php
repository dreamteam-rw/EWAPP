

<?php
require_once 'core/DB.php';
$db = new DB();
?>

<!DOCTYPE html>
<html>
<head>
  <title></title>
</head>
<body>

  <?php 
$nb=0;
                $condition =array 
                (
                  'where'=> array('status' => 0 , ),
                );
                $alerts = $db->getRows('alert',$condition);
                 if(!empty($alerts)): $count = 0;  
                          foreach($alerts as $dist): $count++; 
                            $nb=$count;
                endforeach; else:
                      endif;
                  if ($nb >0 )
                  {
      // echo $nb;
                      ?>
             



                <audio  autoplay>

                      <source src="siren.mp3" type="audio/mpeg">
                    Your browser does not support the audio element.
                    </audio>

<?php
                  }
                  else { }

  ?>


</body>
</html>