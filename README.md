# EWAP Prototype
Climate Early Warning (METEO-RWANDA AND MIDIMAR REACH THE PUBLIC)

This repo store the prototype of DreamTeam, produced during the Early Climate Warning Hackthon promoted by UNDP/Meteo Rwanda from July 18th to July 24th at Kayonza district. 

## Structure:

### EWAP-Mobile-Proto contains the source of the android prototype. 
  This unit of the system provides a mobile App for users. The features are:
- Automatically fetch forecast based on the GPS track location
- Provide Feedback relative to a warning message from MIDIMAR
- View the most recent list of warnings

*Caveat: This prototype has been coded in B4A for the sake of the speed and timing. The final product shall be entirelly coded in Java

### Backend-API-PHP 
  This unit consists of PHP files which will run backend queries for the mobile system.
  This requires a PHP server with access to the database.
 
### Database
  This is the dump of the database model. It is very incomplete since it is a sketch of what the final product should be.
  Some keys and relations must be reviewed.

### USSD
  Prototype to be used with the africastalking.com USSD platform

### METEO_UI
  This is the PHP component of the system and stands for the Web UI which holds the forum, alerts management, SMS interface, etc.

