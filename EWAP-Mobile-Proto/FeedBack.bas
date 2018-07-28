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

	Dim Panel1 As Panel
    Dim EditText1 As EditText
	Dim Spinner1 As Spinner
	Dim Label1 As Label
	Dim LabelBack As Label
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("FeedBack")
    
	Panel1.Left=0
	Panel1.Top=0
	
	scale.SetRate(0.5)
    scale.ScaleAll(Activity,True)
	scale.ScaleView(Panel1)
	scale.SetTopAndBottom(Panel1,1,100%y)
    scale.SetLeftAndRight(Panel1,1,100%x)
    
    position


	
	Spinner1.Add(Main.sms1_date & " Kayonza")
	Spinner1.Add(Main.sms2_date & " Karongi")
	Spinner1.Add(Main.sms3_date & " Huye")
		
	
End Sub


Sub position
'This needs To be complete reviewed in a final product
 'For the sake of the prototype, it is only addressing the camonc9 dimensions
 Spinner1.Left=20
 Spinner1.Width=1050
 scale.ScaleView(Panel1)
 EditText1.Height=1000
 EditText1.Left=20
 EditText1.Top=300
 EditText1.Width=1050
 LabelBack.Height= 200
 LabelBack.Width=200
 LabelBack.Top=1550 
 LabelBack.Left=800
 Label1.Height= 200
 Label1.Width=200
 Label1.Top=1350 
 Label1.Left=20

End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Label1_Click

'This sends a feedback to the dabase
Dim i As Int
Dim submit As String
Dim com As String
Dim ph As Phone
Dim StdOut,StdErr As StringBuilder
StdOut.Initialize 
StdErr.Initialize
  
 'Confirm and execute the remote json
 i=Msgbox2("Do you want to submit your feedback to MIDIMAR?","Send Feedback","Yes","Cancel","No",Null) 
 
 If i=DialogResponse.POSITIVE Then   'do Yes code

    'This needs to implement security. For now it is only for the sake of the prototype
 	submit=EditText1.Text 
	com="/data/data/com.rootsoft.ewap/files/bin/curl http://node2.oneacrefund.org/selects/php-in-feed.php?content="&submit&"&userid=9"	
	
	'Sends the feedback and clear the text area
	'It needs to test the returng of the execution yet
	ph.Shell(com,Null,StdOut,StdErr) 
	EditText1.Text=""	
	ToastMessageShow("Feedback Sent...",False)

	
 End If

End Sub

Sub LabelBack_Click

	'Get back to the main activity screen
	StartActivity(Main)
	
End Sub