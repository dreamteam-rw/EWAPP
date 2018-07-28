

<?php
require_once 'core/DB.php';
$db = new DB();

?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin AIDES</title>
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
    
 <!-- Small boxes (Stat box) -->
    <div class="row">
          <div class=" col-sm-9" style="margin-left: 140px">
              <form method="post" action="class/config.php">
                 <!--RECENT REGISTER -->
                <div class="box box-info">
                    <div class="box-header with-border">
                      <h3 class="box-title">Add Alert</h3>

                      <div class="box-tools pull-right">
                        
                      </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body" style="padding: 30px;">

                        
                         <div class="form-group">


                        <!--  <label>Select</label>
                  <select class="form-control">
                    <option>option 1</option>
                    <option>option 2</option>
                    <option>option 3</option>
                    <option>option 4</option>
                    <option>option 5</option>
                  </select>-->
                          <label>Max Temperature  </label>
                            <span style="color: red; font-size: 12px; display: block"> </span>
                          <input name="temperature" class="form-control" placeholder=" Enter Max Temperature">
                          <br>
                          <label>Wind Direction  </label>
                           <input name="wind_dir" class="form-control" placeholder="Enter Wind Direction">
                          <br>
                          
                           <label>Wind Speed</label>
                           
                          <input name="wind_speed" class="form-control" placeholder="Enter wind Speed">
                          <br>
                          
                          <label>Rain level  </label>
                          <input name="rain_level"  class="form-control" placeholder="Entrer Rain Volume">
                          <br>
                          <label>Select Weather Condition</label>
                  <select name="weather" class="form-control">


                    <?php

                            $condition =array 
                                    (
                                      //'where'=>array('condition_id' => $alert['condition_id'],),
                                      'order_by'=>'condition_id desc',

                                    );
                            $wheather = $db->getRows('conditionn',$condition);
                      ?>
        <!-- /.col --> <?php if(!empty($wheather)): $count = 0; foreach($wheather as $cond): $count++; ?>
                              <option value="<?php echo $cond['condition_id']; ?>"> <?php echo $cond['name'] ; ?></option>
                              <?php endforeach; else: ?>
                              <?php endif; ?>
                   
                  </select>

                  <br>
                            <label>Select  Sectors </label>
                                      <select  name="location[]"  multiple class="form-control">
                                      <?php 

                                              $condition =array 
                                              (
                                                'order_by'=>'sector_id desc',
                                                
                                              );
                                            $sectors = $db->getRows('sector',$condition);

                                     ?>
                                     <option value="" disabled=""> Select Sector</option>
                                    <?php if(!empty($sectors)): $count = 0; foreach($sectors as $sector): $count++; ?>
                                      <option value="<?php echo $sector['sector_id']; ?>"> <?php echo $sector['name'] ; ?></option>
                                      <?php endforeach; else: ?>
<?php endif; ?>

                                     </select>
                    <br>
                    <label> Disaster Detail</label>
                 <textarea class="textarea" placeholder="Enter Disaster Detail" name="detail_disaster" 
                          style="width: 100%; height: 100px; font-size: 14px; line-height: 10px; border: 1px solid #dddddd; padding: 10px;"></textarea>
                      <br>

                        
                         </div>
                      <!-- /.box-body -->
                  
                    <div class="box-footer clearfix">
                        <a href="user-list" class="btn btn-sm btn-default btn-flat pull-left">Cancel </a>
                        <button type="submit" name="disaster" class="btn btn-sm btn-info btn-flat pull-right">Submit</button>
                    </div>
                    <!-- /.box-footer -->
                  </div>
                 <!--RECENT REGISTER -->
              </form>
          </div>
    </div><!-- /.row -->
    
    <div class="row">
    <div class="col-md-8 col-xs-12">
           
    </div><!-- ./col -->
    <div class="col-md-4 col-xs-12">
           
    </div><!-- ./col -->
    </div><!-- /.row -->
    
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
