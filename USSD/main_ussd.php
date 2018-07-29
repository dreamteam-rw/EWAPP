    <?php
    // Reads the variables sent via POST from our gateway
    $sessionId   = $_POST["sessionId"];
    $serviceCode = $_POST["serviceCode"];
    $phoneNumber = $_POST["phoneNumber"];
    $text        = $_POST["text"];
    if ( $text == "" ) {
       

                        //first view to choose the language
                         $response  = "CON HITAMO URURIMI  \n";
                         $response .= "1. IKINYARWANDA \n";
                         $response .= "2. ENGLISH";

                       }
    else if ( $text == "1" ) {
      
                            // when kinyarwanda is chosen
                            $response = "CON HITAMO  \n";
                            $response .= "1. ITEGANYAGIHE \n";
                            $response .= "2. TANGA IGITECYEREZO \n";
                            $response .= "3. KWIYANDIKISHA";
      
                             }

   else if ( $text == "2" ) {

                             // here is when english is choo=sen
                             $response = "CON CHOOSE  \n";
                             $response .= "1. WEATHER FORECAST \n";
                             $response .= "2. FEEDBACK \n";
                             $response .= "3. REGISTER";
      
                             }



  else if($text == "1*1") {
                  
                         // when kinyarwanda forecast is chosen
                        

                         $response = "CON HITAMO AKARERE \n";
                         $response .= "1.KAYONZA\n";
                         $response .= "2.RWAMAGANA\n ";
                         $response .= "3.GASABO \n";
                         $response .= "4.KICUKIRO\n";
                         $response .= "5.RULINDO\n ";
                         $response .= "6.KARONGI";
                         
                          
                         }

     

     else if($text == "1*2") {
                             // kinyarwanda choose to give feedback
                              $response ="CON HITAMO AKARERE  \n";
                             
                               $response .= "1.KAYONZA\n";
                               $response .= "2.RWAMAGANA\n ";
                               $response .= "3.GASABO \n";
                               $response .= "4.KICUKIRO\n";
                               $response .= "5.RULINDO\n ";
                             
                            
      
      
    
                              }
        
      else if ( $text == "1*3" ) {
      
                                    // kinyarwanda registration
                                    $response = "CON UZUZA  \n";
                                    $response .= "AMAZINA: KIMENYI JOHN \n";
                                    $response .= "AHO UTUYE:KAYONZA \n";
                                    $response .= "NOMERO YA TELEPHONE:0785466 ";
                                    
                               
                                  }

     else if($text == "2*1") {
                  
                         // WHEN ENGLISH forecast is CHOSEN
                        

                         $response = "CON CHOOSE DISTRICT \n";
                         $response .= "1.KAYONZA\n";
                         $response .= "2.RWAMAGANA\n ";
                         $response .= "3.GASABO \n";
                         $response .= "4.KICUKIRO\n";
                         $response .= "5.RULINDO\n ";
                         $response .= "6.KARONGI";
                         
                          
                         }






    else if($text == "1*1*1") {
      
                              // KINYARWANDA FORECAST CHOSEN AND DISTRICT SO HERE WE HAVE TO CHOOSE THE TIME

                               $response = "CON KAYONZA \n";
                               $response .= "1. UYU MUNSI \n";
                               $response .= "2. UMUNSI WA KABIRI \n";
                               $response .= "3. UMUNSI WA GATATU \n";
                               $response .= "4. UMUNSI WA KANE \n";
                               $response .= "5. UMUNSI WA GATANU ";
                               
     
     
                               }


    else if($text == "1*1*2") {
                  
                         // when kinyarwanda forecast is chosen
                        

                         $response = "CON RWAMAGANA \n";
                         $response .= "1.KAYONZA\n";
                         $response .= "2.RWAMAGANA\n ";
                         $response .= "3.GASABO \n";
                         $response .= "4.KICUKIRO\n";
                         $response .= "5.RULINDO\n ";
                         $response .= "6.KARONGI";
                         
                          
                         }


else if($text == "1*2*1") {
                  
                         // feedback from ussd the general public 
                        

                         $response = "CON HITAMO \n";
                         $response .= "1.METEO\n";
                         $response .= "2.MIDIMAR\n ";
                        
                                          
                          
                         }



 else if($text == "2*1*1") {
      
                              // KINYARWANDA FORECAST CHOSEN AND DISTRICT SO HERE WE HAVE TO CHOOSE THE TIME

                               $response = "CON KAYONZA \n";
                               $response .= "1. TODAY \n";
                               $response .= "2. THE SECOND DAY \n";
                               $response .= "3. THE THIRD DAY \n";
                               $response .= "4. THE FOURTH DAY \n";
                               $response .= "5. THE FIRTH DAY ";
                               
     
     
                               }




  else if ($text == "1*1*1*1"){

                        //kinyarwanda forecast chosen and district ,time chosen ao here we display the FORECAST ACCORDING TO THE REGION
                        
                        $response = "CON KAYONZA \n";
                        $response .="-MUGITONDO: IBICU BYIGANJE \n";
                        $response .="-KUGICAMUNSI: IBICU BYIGANJE \n";
                        $response .="-IRIJORO: IBICU BIRINGANIYE \n";
                        $response .="-UBUSHYUHE BWO HEJURU: 16\n";
                        $response .="-UBUSHYUHE BWO HASI: 14  ";
                        
                        
                      


                        }



    else if ($text == "1*2*1*1"){

                        //kinyarwanda forecast chosen and district ,time chosen ao here we display the FORECAST ACCORDING TO THE REGION
                        
                        $response = "CON ANDIKIRA METEO\n";
                       
                        
                      


                        }


    else if ($text == "1*2*1*2"){

                        //kinyarwanda forecast chosen and district ,time chosen ao here we display the FORECAST ACCORDING TO THE REGION
                        
                        $response = "CON ANDIKIRA MIDIMAR \n";
                        
                        
                        
                      


                        }



   else if ($text == "2*1*1*1"){

                        //kinyarwanda forecast chosen and district ,time chosen ao here we display the FORECAST ACCORDING TO THE REGION
                        
                        $response = "CON KAYONZA \n";
                        $response .="-MORNING: PARTLY CLOUDY \n";
                        $response .="-AFTERNOON: PARTLY CLOUDY \n";
                        $response .="-TONIGHT: PARTLY CLOUDY \n";
                        $response .="-MAX TEMP: 16\n";
                        $response .="-MIN TEMP: 14  ";
                        
                        
                      


                        }




  
  
     


    // Print the response onto the page so that our gateway can read it
    header('Content-type: text/plain');
    echo $response;
    // DONE!!!
    ?>