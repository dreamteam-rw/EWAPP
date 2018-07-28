Type=Service
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub
Sub Service_Create

End Sub

Sub Service_Start (StartingIntent As Intent)
'Starter service
End Sub

Sub GPS_LocationChanged (Location1 As Location)
   CallSub2(Main, "LocationChanged", Location1)
End Sub

'Main activity
Public Sub LocationChanged(Location1 As Location)
   lblLat.Text = "Lat = " & Location1.ConvertToMinutes(Location1.Latitude)
   lblLon.Text = "Lon = " & Location1.ConvertToMinutes(Location1.Longitude)
   lblSpeed.Text = $"Speed = $1.2{Location1.Speed} m/s "$
End Sub


Sub Service_Destroy

End Sub
