
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
    
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

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
  
  <?php //header("Refresh:10");?>
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
   <section class="content-header">
          <h1>
            Forum
          </h1>
    </section>



<!-- Main content -->
<section class="content">
    
 <!-- Small boxes (Stat box) -->
    <div class="row">
          
  <div class="col-md-12">
          <div class="nav-tabs-custom">
           
            <div class="tab-content">
                 <div id="responsecontainer">
    
                <!-- Post -->
            <?php 

            $ct = 0;

                $condition =array 
                (
                  'order_by'=>'alert_id desc',
                  'LIMIT'=>'50'
                );
               $alerts = $db->getRows('alert',$condition);

         ?>
          <?php if(!empty($alerts)): $count = 0; foreach($alerts as $alert): $count++;





         
$loc="";
       $District="";
                $condition =array 
                (
                    'where'=>array('sector_id' =>$alert['sector_id'], ),
                );

                       $sector = $db->getRows('sector',$condition);
                      if(!empty($sector)): $count = 0;  
                          foreach($sector as $sect): $count++; 

                           $loc.= $sect['name'];  


                            $condition =array 
                (
                    'where'=>array('district_id' =>$sect['district_id'] , ),
                );

                       $district = $db->getRows('district',$condition);
                      if(!empty($district)): $count = 0;  
                          foreach($district as $dist): $count++; 

                           $District.= $dist['name']."/".$loc;  
                            endforeach; else:
                      endif;
                        endforeach; else:
                      endif; 

            ?>


                <div class="post">
                  <div class="user-block">
                    <img class="img-responsive img-bordered-sm" src="dist/img/al.png" alt="user image">
                        <span class="username">
                          <a href="#"> Disaster Alert 000<?php  echo $alert['alert_id'] ?>    from  METEO for  <small><?php  echo $District;  ?></small> </a>
                         </span>
                    <span class="description">Shared with MIDIMAR  On    <?php  echo $alert['date'] ?> </span>
                  </div>
                  <!-- /.user-block -->
                  <p>
                   <?php echo  $alert['content']; ?>
                  </p>


    <?php 


                $condition =array 
                (
                  'order_by'=>'forum_id asc',
                  'LIMIT'=>'15',
                  'where'=>array('alert_id'=> $alert['alert_id'], )
                );
               $forums = $db->getRows('forum',$condition);

               if(!empty($forums)): $ct = 0; foreach($forums as $forum): $ct++;
                endforeach; else:
                  endif;


    ?>            
  <div class="container">
    <div class="row">
        <div class="col-md-11">
            <div class="panel panel-primary">
                <div class="panel-heading" id="accordion">

                    <span class="fa fa-comments"></span> (<?php echo $ct  ?>) Replies
                    <div class="btn-group pull-right">
                        <a type="button" class="btn btn-default btn-xs" data-toggle="collapse" data-parent="#accordion" href="#collapse<?php  echo $alert['alert_id'] ?>">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </a>
                    </div>
                </div>
            <div class="panel-collapse collapse" id="collapse<?php  echo $alert['alert_id'] ?>">
                <div class="panel-body">
                   <?php if(!empty($forums)): $count = 0; foreach($forums as $forum): $count++; ?>

                    <ul class="chat">
                     
                        
                        <?php 

                $condition =array 
                (
                  
                  'where'=>array('userid'=> $forum['user_id'] )
                );
               $users = $db->getRows('user',$condition);

               ?> 

                       <?php if(!empty($users)): $count = 0; foreach($users as $us): $count++; 
                          if ($us['category_id']==8){
                        ?>

                        <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="http://placehold.it/50/FA6F57/fff&text=MD" alt="User Avatar" class="img-circle" />
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span><?php echo $forum['date']; ?></small>
                                    <strong class="pull-right primary-font"><?php echo $us['names']?> </strong>
                                </div>
                                <p>
                                    <?php echo $forum['content']; ?> 
                                </p>
                            </div>
                        </li>

                        <?php }

                        else 
                          {?>

                        <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="http://placehold.it/50/55C1E7/fff&text=MT" alt="User Avatar" class="img-circle" />
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font"> <?php echo $us['names']?> </strong> <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span><?php echo $forum['date']; ?> </small>
                                </div>
                                <p>
                                   <?php echo $forum['content']; ?> 
                                </p>
                            </div>
                        </li>
                        
                        
                       <?php } endforeach; else: ?>
<?php endif; ?>
                      
                       
                    </ul>
                     <?php endforeach; else: ?>
<?php endif;  $ct=0 ;?>

                </div>
                <div class="panel-footer">
                  <form  action="class/config.php?al=<?php  echo $alert['alert_id'] ?>&us=2" method="post">
                    <div class="input-group">
                        <input id="btn-input" name="cmt" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <button  class="btn btn-warning btn-sm" id="btn-chat">
                                Send</button>
                        </span>
                    </div>
                  </form>
                </div>
            </div>
            </div>
        </div>
    </div>

             </div>   
   <!-- /.post -->
              </div>

              <?php endforeach; else: ?>
                              <?php endif; 

$ct = 0;
                              ?>

 <!-- /.post1 -->

          </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>


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
