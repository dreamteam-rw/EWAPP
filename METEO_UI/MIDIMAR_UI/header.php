
<?php
session_start();

if ($_SESSION['name']=="")

  {
    header("Location: login");
  }

$sessData = !empty($_SESSION['sessData'])?$_SESSION['sessData']:'';
//get status message from session
if(!empty($sessData['status']['msg'])){
    $statusMsg = $sessData['status']['msg'];
    $statusMsgType = $sessData['status']['type'];
    unset($_SESSION['sessData']['status']);}


header("Refresh:5"); 

?>

<!-- Logo -->
    <a href="" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>AD</b>MIN</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>EWAP</b> MIDIMAR </span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->

           <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="user-list" class="dropdown-toggle" >
              <i class="fa fa-exclamation-triangle"></i>
              <span class="label label-danger">5</span>
            </a>
           
          </li>

          <li class="dropdown notifications-menu">
            <a href="user-list" class="dropdown-toggle" >
              <i class="fa fa-comments"></i>
              <span class="label label-success">70</span>
            </a>
          </li>

           <li class="dropdown notifications-menu">
            <a href="user-list" class="dropdown-toggle" >
              <i class="fa fa-comment-o"></i>
              <span class="label label-warning">89</span>
            </a>
           
          </li>

          <li class="dropdown user user-menu">
            <a href="class/config.php?action_type=del"  class="label label-warning">
             
              <span >Turn Off Alarm</span>
            </a>
           
          </li>

          
         <li>
                    <?php  include 'test.php'  ?>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
           <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">

             <?php 

             if(!empty($statusMsg) && ($statusMsgType == 'success')){ ?>
    <div  style="color: white; font-style: bold" ><?php echo $statusMsg; ?></div>
    <?php }elseif(!empty($statusMsg) && ($statusMsgType == 'error')){ ?>
    <div style="color: white; font-style: bold"  ><?php echo $statusMsg; ?></div>
    <?php } ?>
            </a>
          <!-- Tasks: style can be found in dropdown.less -->
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-user"></i>
              <span   class="hidden-xs"><?php echo $_SESSION['name']?></span>
            </a>
          
          </li>
          <li>
          <!-- Control Sidebar Toggle Button -->
          
        </ul>
      </div>
    </nav>