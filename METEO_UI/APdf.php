<?php
session_start();

//load and initialize database class
require_once 'core/DB.php';
$db = new DB();

$q = $_REQUEST["id"];
      
     

require ("fpdf/fpdf.php");


class PDF extends FPDF
{
// Page header
function Header()
{
    // Logo
   // $this->Image('logo.png',60,5,180);
    // Arial bold 15
   $this->SetFont('Arial','B',15);
    // Move to the right
  // $this->Cell(80);
    // Title
    $this->Cell(0,10,' REPUBLIC OF RWANDA',0,1,'C');
     $this->Cell(0,10,' RWANDA METEOROLOGY ',0,1,'C');
   $this->Cell(0,10,' Disaster Alert Archive  ',0,0,'C');
    // Line break
    $this->Ln(20);
}

// Page footer
function Footer()
{
    // Position at 1.5 cm from bottom
    $this->SetY(-15);
    // Arial italic 8
    $this->SetFont('Arial','B',10);
    // Page number
    $this->Cell(0,10,date('d-M-Y'),0,0,'L');
    $this->Cell(0,10,'Page '.$this->PageNo().'/{nb}',0,1,'R');
    // $this->Ln();
    $this->Cell(120,5,'Kigali',0);
     
     $this->Cell(120,5,'www.meteorwanda.gov.rw',0);
       
   
    
   // 
}
}
$title='  '.$mon.'  '.$Year;
  
$pdf = new PDF();
$pdf->AliasNbPages();
$pdf->AddPage(L,A4);
$pdf->SetFont('Arial','i',15);	

$condition =array 
                (
                  
                  'where'=> array('alert_id' => $q , )
                );


          $alerts = $db->getRows('alert',$condition);

          if(!empty($alerts)): $ct = 0; foreach($alerts as $alert): $ct++;
                                   

                                   $pdf->Cell(60,5,'Alert ID : ');   $pdf->Cell(30,5,$alert['alert_id']);
                                   $pdf->ln();
                                   $pdf->ln();
                                   $pdf->Cell(60,5,'date : ');   $pdf->Cell(30,5,$alert['date']);
                                   $pdf->ln();
                                   $pdf->ln();

                                   $loc="";
       $District="";
                $condition =array 
                (
                    'where'=>array('sector_id' =>$alert['sector_id'] ),
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
$pdf->Cell(60 ,5,'Location   : ');   $pdf->Cell(30,5,$District);
                           //$District.= $dist['name']."/".$loc;  
                            endforeach; else:
                      endif;
                        endforeach; else:
                      endif; 
                                   
                                   $pdf->ln();
                                   $pdf->ln();
                                   $pdf->Cell(60 ,5,'Max Temprature  : ');   $pdf->Cell(30,5,$alert['max_temp']);
                                    $pdf->ln();
                                   $pdf->ln();
                                   $pdf->Cell(60,5,'Rain  : ');   $pdf->Cell(30,5,$alert['rain_volume'].'ml');
                                   $pdf->ln();
                                   $pdf->ln();
                                   $pdf->Cell(60,5,'Wind Speed  : ');   $pdf->Cell(30,5,$alert['wind_speed'].'km/h');
                                    $pdf->ln();
                                   $pdf->ln();
                                   $condition =array 
                                    (
                                      'where'=>array('condition_id' => $alert['condition_id'],),

                                    );
                            $wheather = $db->getRows('conditionn',$condition);

                                   $pdf->Cell(60,5,'Wind Direction  : ');   $pdf->Cell(30,5,$alert['wind_direction']);
                                   $pdf->ln();
                                   $pdf->ln();
                                   if(!empty($wheather)): $count = 0; foreach($wheather as $cond): $count++;
                                   $pdf->Cell(60,5,'Wheather Condition  : ');   $pdf->Cell(30,5,$cond['name']);  $pdf->Cell(30,5,'');  $pdf->Cell(30,5,$cond['symbol']);
                                   endforeach; else:
                      endif;    
                                      $pdf->ln();
                                   $pdf->ln();
                                   $pdf->Cell(60,5,'Description   : '); 
                                    $pdf->ln();
                                    $pdf->ln();
                                     $pdf->Cell(170,5,$alert['content']);

                                           
                               endforeach; else:
                      endif;            






$pdf->Output();	


?>
