
<?php
require_once 'core/DB.php';
$db = new DB();

?>




<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="bower_components/morris.js/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

  <header class="main-header">
   <?php  include 'header.php'  ?>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <?php  include 'nav.php'  ?>
  </aside>
 

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  <!-- Main content -->
 <section class="content">
<div class="row">
 <div class="col-sm-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title"> Alert List  </h3>
            </div>
            <!-- /.box-header -->


            <?php 

                $condition =array 
                (
                  'order_by'=>'alert_id desc',
                  'LIMIT'=>'10'
                );


          $alerts = $db->getRows('alert',$condition);



              ?>
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>No </th>
                  <th>Max Temp.</th>
                  <th>Wind Dir.</th>
                  <th>Wind Speed </th>
                  <th>Rain  Vol. </th>
                  <th>Weather Cond.</th>
                  <th>Message  </th>
                  <th>District/Sector </th>
                  <th>Date </th>
                  <th>Action</th>
                 </tr>
                </thead>
                <tbody>
             
                     <?php if(!empty($alerts)): $ct = 0; foreach($alerts as $alert): $ct++; ?>
                    <tr>
                        <td><?php echo '#'.$ct; ?></td>
                        <td><?php echo  $alert['max_temp']; ?></td>
                      <td><?php echo  $alert['wind_direction']; ?></td>
                      <td><?php echo  $alert['wind_speed']; ?></td>
                       <td><?php echo  $alert['rain_volume']; ?></td>
                          <?php

                            $condition =array 
                                    (
                                      'where'=>array('condition_id' => $alert['condition_id'],),

                                    );
                            $wheather = $db->getRows('conditionn',$condition);
                      ?>
        <!-- /.col --> <?php if(!empty($wheather)): $count = 0; foreach($wheather as $cond): $count++; ?>
                              <td><?php echo  $cond['name']; ?></td>
                              <?php endforeach; else: ?>
                              <?php endif; ?>
                               <td><?php echo  $alert['content']; ?></td>

                            <!-- Code to select the sector name and district name -->
              <?php 
       $location="";
       $District="";
                $condition =array 
                (
                    'where'=>array('sector_id' =>$alert['sector_id'] , ),
                );

                       $sector = $db->getRows('sector',$condition);
                      if(!empty($sector)): $count = 0;  
                          foreach($sector as $sect): $count++; 

                           $location.= $sect['name'];  


                            $condition =array 
                (
                    'where'=>array('district_id' =>$sect['district_id'] , ),
                );

                       $district = $db->getRows('district',$condition);
                      if(!empty($district)): $count = 0;  
                          foreach($district as $dist): $count++; 

                           $District.= $dist['name']."/".$location;  
                            endforeach; else:
                      endif;
                        endforeach; else:
                      endif;

              ?>
                        <td><?php echo  $District; ?></td>
                        <td><?php echo $alert['date']; ?></td>
                         

                          <!-- control the published news-->
                        
                         <td>

                            
                           <!-- <a href="class/config.php?action_type=edit&id=<?php echo $new['ID']; ?>" class="glyphicon glyphicon-edit"> Modifier</a> -->
                           <a href="new-spot"class="fa fa-comment-o"> Reply</a> 
                           <a href="news" class="fa fa-share"> Send Alert</a>
                        </td>
                       
                        
                    </tr>
                    <?php endforeach; else: ?>
                    <tr><td colspan="8">No match found</td>

                      
                    </tr>

                    <?php endif; ?>


                </tbody>
               
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

         
        </div>

          <!-- /.box -->
        </div>
      </section>
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
  
  <?php  include 'footer.php'  ?> 
  </footer>

  <!-- Control Sidebar -->
  
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="bower_components/raphael/raphael.min.js"></script>
<script src="bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="bower_components/moment/min/moment.min.js"></script>
<script src="bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
</body>
</html>
