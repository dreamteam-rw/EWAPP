
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
<div class="row">
 <div class="col-sm-12">
          <div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">Liste des Actualités </h3>
            </div>
            <!-- /.box-header -->


            <?php 

                $condition =array 
                (
                  'order_by'=>'ID desc',
                  'LIMIT'=>'50'
                )
                ;

                     $projs = $db->getRows('project',$condition);

              ?>
            <div class="box-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>No </th>
                  <th>Période</th>
                  <th>Titre du Projet</th>
                  <th>Localisation</th>
                  <th>Bailleur de fond</th>
                  <th>Description</th>
                  <th>Status</th>
                
                 </tr>
                </thead>
                <tbody>
             
                     <?php if(!empty($projs)): $count = 0; foreach($projs as $proj): $count++; ?>
                    <tr>
                        <td><?php echo '#'.$count; ?></td>
                        <td><?php echo str_replace ("@@","'", $proj['Period']); ?></td>
                        <td><?php echo str_replace ("@@","'", $proj['Title']); ?></td>
                        
                         <td><?php echo str_replace ("@@","'", $proj['Location']); ?></td>
                         </td>
                        <td><?php echo  str_replace ("@@","'",$proj['Sponsor']); ?></td>
                        <td><?php echo  str_replace ("@@","'",$proj['Description']); ?></td>
                          <td><?php echo $proj['Status']; ?></td>


    <?php
                      if ($proj['Status']=='Terminé'){

                         ?>
                         <td>

                            
                           <!-- <a href="class/config.php?action_type=edit&id=<?php echo $new['ID']; ?>" class="glyphicon glyphicon-edit"> Modifier</a> -->
                            <a href="class/config.php?action_type=deletep&id=<?php echo $sproj['ID']; ?>" class="glyphicon glyphicon-trash" onclick="return confirm('Voulez-Vous Supprimer cet article ?')"> Supprimer</a>
                        </td>
                        <?php
                          }
                          else 
                          {
                        ?>
<td>
                            <a href="class/config.php?action_type=postp&id=<?php echo $proj['ID']; ?>" class="glyphicon glyphicon-share" onclick="return confirm('Voulez-vous publier cet article ?')"> Terminer</a>
                              
                             <a href="class/config.php?action_type=deletep&id=<?php echo $proj['ID']; ?>"class="glyphicon glyphicon-trash" onclick="return confirm('Voulez-Vous Supprimer cet article ?')"> Supprimer</a>
                           </td>
                        <?php
                          }
                        ?>


                         </tr>
                    <?php endforeach; else: ?>
                    <tr><td colspan="5">Aucun élément trouvé</td></tr>
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
