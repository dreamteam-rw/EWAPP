
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

?>
<!-- Logo -->
    <a href="" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>AD</b>MIN</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>EWAP</b>  METEO </span>
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

           <li class="dropdown notifications-menu">
            <a href="user-list" class="dropdown-toggle" >
              <i class="fa fa-comments"></i>
              <span class="label label-success">70</span>
            </a>
           
          </li>
          <li>
            

          </li>
         <li>
           


         </li>
          <!-- Notifications: style can be found in dropdown.less -->
           <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
             <?php if(!empty($statusMsg) && ($statusMsgType == 'success')){ ?>
    <div   class="alert alert-success" style="color: white; font-style: bold" ><?php echo $statusMsg; ?></div>
    <?php }elseif(!empty($statusMsg) && ($statusMsgType == 'error')){ ?>
    <div class="alert alert-success" style="color: white; font-style: bold"  ><?php echo $statusMsg; ?></div>
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
          <!-- Control Sidebar Toggle Button -->
          
        </ul>
      </div>
    </nav>