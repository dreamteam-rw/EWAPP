Type=Activity
Version=5.02
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private Panel1 As Panel
	Private LabelBack As Label
	Private ListView1 As ListView

End Sub

Sub Activity_Create(FirstTime As Boolean)


    'Load the list of alerts
    Activity.LoadLayout("ListAlerts")

	'Use full screen
	'Valid for the prototype only
    Panel1.Left=0
	Panel1.Top=0
	scale.SetRate(0.5)
    scale.ScaleAll(Activity,True)
	scale.ScaleView(Panel1)
	scale.SetTopAndBottom(Panel1,1,100%y)
    scale.SetLeftAndRight(Panel1,1,100%x)
    
	'position elements in the activity screen
	'valid for the camonc9 only
    position
	
	'Set up data and fill up those not in the database with test values 	
	ListView1.AddSingleLine(Main.sms1_date & " Kayonza")
	ListView1.AddSingleLine(Main.sms2_date & " Karongi")
	ListView1.AddSingleLine(Main.sms3_date & " Huye")
	
		
	
End Sub

Sub position

 'This needs To be complete reviewed in a final product
 'For the sake of the prototype, it is only addressing the camonc9 dimensions
 scale.ScaleView(Panel1)
 ListView1.Left=20
 ListView1.Top=20
 ListView1.Width=1050
 'ListView1.Height=1500
 LabelBack.Height= 200
 LabelBack.Width=200
 LabelBack.Top=1550 
 LabelBack.Left=800

End Sub

Sub Activity_Resume

'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
    
    

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub LabelBack_Click
	'Go back to the main activity screen
	StartActivity(Main)
	
End Sub

Sub ListView1_ItemClick (pos As Int, Value As Object)
'Display the alert message
'It still need to receive the dynamic variable for district name from the main sms_ variable
Select pos
Case 0
	Msgbox(Main.sms1,Main.sms1_date & " Kayonza")
Case 1
	Msgbox(Main.sms2,Main.sms2_date & " Karongi")
Case 2
	Msgbox(Main.sms3,Main.sms3_date & " Huye")
End Select
 

	
End Sub