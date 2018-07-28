package com.rootsoft.ewap;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.rootsoft.ewap", "com.rootsoft.ewap.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.rootsoft.ewap", "com.rootsoft.ewap.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.rootsoft.ewap.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.gps.GPS _gps1 = null;
public static anywheresoftware.b4a.objects.Timer _checkgps = null;
public static anywheresoftware.b4a.objects.Timer _splashtimer = null;
public static com.rootsoft.ewap.main._fore[] _array_dis = null;
public static String _sms1 = "";
public static String _sms1_date = "";
public static int _sms1_id = 0;
public static int _sms1_dis = 0;
public static String _sms2 = "";
public static String _sms2_date = "";
public static int _sms2_id = 0;
public static int _sms2_dis = 0;
public static String _sms3 = "";
public static String _sms3_date = "";
public static int _sms3_id = 0;
public static int _sms3_dis = 0;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _sol = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _chuva = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _nublado = null;
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _noitelimpa = null;
public com.rootsoft.locationmanager.LocationManager1 _lm = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllon = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllat = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblspeed = null;
public anywheresoftware.b4a.objects.collections.List _districts = null;
public static int _indice = 0;
public anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label5 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label8 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _listview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview4 = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.rootsoft.ewap.scale _scale = null;
public com.rootsoft.ewap.listalerts _listalerts = null;
public com.rootsoft.ewap.feedback _feedback = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (listalerts.mostCurrent != null);
vis = vis | (feedback.mostCurrent != null);
return vis;}
public static class _fore{
public boolean IsInitialized;
public int id;
public int morning;
public int adternoon;
public int evening;
public int Mx;
public int Mn;
public void Initialize() {
IsInitialized = true;
id = 0;
morning = 0;
adternoon = 0;
evening = 0;
Mx = 0;
Mn = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stdout = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stderr = null;
anywheresoftware.b4a.gps.LocationWrapper _location1 = null;
 //BA.debugLineNum = 134;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 136;BA.debugLine="Activity.LoadLayout(\"getlocation\")";
mostCurrent._activity.LoadLayout("getlocation",mostCurrent.activityBA);
 //BA.debugLineNum = 138;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 139;BA.debugLine="Dim StdOut, StdErr As StringBuilder";
_stdout = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_stderr = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 140;BA.debugLine="StdErr.Initialize";
_stderr.Initialize();
 //BA.debugLineNum = 141;BA.debugLine="StdOut.Initialize";
_stdout.Initialize();
 //BA.debugLineNum = 145;BA.debugLine="Panel1.Width=100%x";
mostCurrent._panel1.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 146;BA.debugLine="Panel1.Height=100%y";
mostCurrent._panel1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 148;BA.debugLine="scale.SetRate(0.5)";
mostCurrent._scale._setrate(mostCurrent.activityBA,0.5);
 //BA.debugLineNum = 151;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 153;BA.debugLine="sol.InitializeSample(File.DirAssets,\"if_weathe";
_sol.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"if_weather_3_2682848.png",(int) (128),(int) (128));
 //BA.debugLineNum = 154;BA.debugLine="nublado.InitializeSample(File.DirAssets,\"if_weath";
_nublado.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"if_weather_2_2682849.png",(int) (128),(int) (128));
 //BA.debugLineNum = 155;BA.debugLine="chuva.InitializeSample(File.DirAssets,\"if_weather";
_chuva.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"if_weather_16_2682835.png",(int) (128),(int) (128));
 //BA.debugLineNum = 156;BA.debugLine="noitelimpa.InitializeSample(File.DirAssets,\"weath";
_noitelimpa.InitializeSample(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"weather_4-128.png",(int) (128),(int) (128));
 //BA.debugLineNum = 158;BA.debugLine="File.MakeDir(File.DirInternal,\"/data/data/com.";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"/data/data/com.rootsoft.ewap/files");
 //BA.debugLineNum = 159;BA.debugLine="File.MakeDir(File.DirInternal,\"/data/data/com.";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"/data/data/com.rootsoft.ewap/files/bin/");
 //BA.debugLineNum = 160;BA.debugLine="Splashtimer.Initialize(\"SplashTimer\",3000)";
_splashtimer.Initialize(processBA,"SplashTimer",(long) (3000));
 //BA.debugLineNum = 161;BA.debugLine="Splashtimer.Enabled = True";
_splashtimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 162;BA.debugLine="scale.ScaleView(ImageView1)";
mostCurrent._scale._scaleview(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._imageview1.getObject())));
 //BA.debugLineNum = 163;BA.debugLine="scale.ScaleView(Spinner1)";
mostCurrent._scale._scaleview(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._spinner1.getObject())));
 //BA.debugLineNum = 165;BA.debugLine="indice = 22";
_indice = (int) (22);
 //BA.debugLineNum = 167;BA.debugLine="scale.ScaleAll(Panel1,True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel1.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 168;BA.debugLine="Panel2.Visible = False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 169;BA.debugLine="Label1.Visible = False";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 170;BA.debugLine="Label2.Visible = False";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 171;BA.debugLine="Spinner1.Visible = False";
mostCurrent._spinner1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 172;BA.debugLine="ImageView1.Visible = True";
mostCurrent._imageview1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 173;BA.debugLine="Spinner1.Width=Panel1.Width-40";
mostCurrent._spinner1.setWidth((int) (mostCurrent._panel1.getWidth()-40));
 //BA.debugLineNum = 174;BA.debugLine="Spinner1.Left=20";
mostCurrent._spinner1.setLeft((int) (20));
 //BA.debugLineNum = 175;BA.debugLine="districts.Initialize";
mostCurrent._districts.Initialize();
 //BA.debugLineNum = 176;BA.debugLine="districts.AddAll(Array As String (\"Bugesera\",\"Bur";
mostCurrent._districts.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bugesera","Burera","Gakenke","Gasabo","Gatsibo","Gicumbi","Gisagara","Huye","Kamonyi","Karongi","Kayonza","Kicukiro","Kirehe","Muhanga","Musanze","Ngoma","Ngororero","Nyabihu","Nyagatare","Nyamagabe","Nyamasheke","Nyanza","Nyarugenge","Nyaruguru","Rubavu","Ruhango","Rulindo","Rusizi","Rutsiro","Rwamagana"}));
 //BA.debugLineNum = 178;BA.debugLine="If Spinner1.Width > 330dip Or Spinner1.Height >";
if (mostCurrent._spinner1.getWidth()>anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (330)) || mostCurrent._spinner1.getHeight()>anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220))) { 
 //BA.debugLineNum = 179;BA.debugLine="Spinner1.Width=330dip";
mostCurrent._spinner1.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (330)));
 //BA.debugLineNum = 180;BA.debugLine="Spinner1.Height=220dip";
mostCurrent._spinner1.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
 };
 //BA.debugLineNum = 182;BA.debugLine="scale.HorizontalCenter(Spinner1)";
mostCurrent._scale._horizontalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._spinner1.getObject())));
 //BA.debugLineNum = 183;BA.debugLine="scale.VerticalCenter(Spinner1)";
mostCurrent._scale._verticalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._spinner1.getObject())));
 //BA.debugLineNum = 184;BA.debugLine="Spinner1.AddAll(districts)";
mostCurrent._spinner1.AddAll(mostCurrent._districts);
 //BA.debugLineNum = 186;BA.debugLine="Spinner1.SelectedIndex=22";
mostCurrent._spinner1.setSelectedIndex((int) (22));
 //BA.debugLineNum = 187;BA.debugLine="Label3.Text=Spinner1.GetItem(22)";
mostCurrent._label3.setText((Object)(mostCurrent._spinner1.GetItem((int) (22))));
 }else {
 //BA.debugLineNum = 192;BA.debugLine="Splashtimer.Enabled = True";
_splashtimer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 193;BA.debugLine="ImageView1.Visible = False";
mostCurrent._imageview1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 194;BA.debugLine="Panel2.Visible = True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 196;BA.debugLine="Spinner1.Visible = True";
mostCurrent._spinner1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 197;BA.debugLine="Label1.Visible = True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 198;BA.debugLine="Label2.Visible = True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 199;BA.debugLine="scale.ScaleAll(Panel1,True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel1.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 200;BA.debugLine="scale.ScaleAll(Panel1,True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel1.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 201;BA.debugLine="scale.ScaleAll(Panel2,True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel2.getObject())),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 204;BA.debugLine="position";
_position();
 //BA.debugLineNum = 206;BA.debugLine="If File.Exists(File.DirAssets, \"curl\") = True T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"curl")==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 207;BA.debugLine="ph.Shell(\"mkdir /data/data/com.rootsoft.ewap";
_ph.Shell("mkdir /data/data/com.rootsoft.ewap/files/",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 208;BA.debugLine="ph.Shell(\"mkdir /data/data/com.rootsoft.ewap/fi";
_ph.Shell("mkdir /data/data/com.rootsoft.ewap/files/bin",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 209;BA.debugLine="File.Copy(File.DirAssets, \"curl\", \"/data/data/c";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"curl","/data/data/com.rootsoft.ewap/files/bin/","curl");
 };
 //BA.debugLineNum = 212;BA.debugLine="ph.Shell(\"chmod 777 /data/data/com.rootsoft.ewap/";
_ph.Shell("chmod 777 /data/data/com.rootsoft.ewap/files/bin/curl",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 214;BA.debugLine="Log(StdOut)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_stdout));
 //BA.debugLineNum = 215;BA.debugLine="Log(StdErr)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_stderr));
 //BA.debugLineNum = 216;BA.debugLine="lm.Initialize(\"Location\")";
mostCurrent._lm.Initialize(processBA,"Location");
 //BA.debugLineNum = 217;BA.debugLine="GPS1.Initialize(\"GPS\")";
_gps1.Initialize("GPS");
 //BA.debugLineNum = 218;BA.debugLine="GPS1.Start(0, 0)";
_gps1.Start(processBA,(long) (0),(float) (0));
 //BA.debugLineNum = 219;BA.debugLine="lm.requestGPSLocation";
mostCurrent._lm.requestGPSLocation();
 //BA.debugLineNum = 221;BA.debugLine="Dim Location1 As Location";
_location1 = new anywheresoftware.b4a.gps.LocationWrapper();
 //BA.debugLineNum = 222;BA.debugLine="Location1.Initialize";
_location1.Initialize();
 //BA.debugLineNum = 224;BA.debugLine="checkgps.Initialize(\"checkgps\",6000)";
_checkgps.Initialize(processBA,"checkgps",(long) (6000));
 //BA.debugLineNum = 225;BA.debugLine="checkgps.Enabled = False";
_checkgps.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 227;BA.debugLine="sec";
_sec();
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 389;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 387;BA.debugLine="End Sub";
return "";
}
public static String  _checkgps_tick() throws Exception{
String _lat = "";
String _lon = "";
String _url = "";
anywheresoftware.b4a.phone.Phone _ph = null;
String _result = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _stdout = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stderr = null;
int _pos1 = 0;
int _pos2 = 0;
String[] _args = null;
int _i = 0;
 //BA.debugLineNum = 286;BA.debugLine="Sub checkgps_tick";
 //BA.debugLineNum = 288;BA.debugLine="Dim lat As String";
_lat = "";
 //BA.debugLineNum = 289;BA.debugLine="Dim lon As String";
_lon = "";
 //BA.debugLineNum = 290;BA.debugLine="Dim url As String";
_url = "";
 //BA.debugLineNum = 291;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 292;BA.debugLine="Dim result As String";
_result = "";
 //BA.debugLineNum = 294;BA.debugLine="Dim StdOut, StdErr As StringBuilder";
_stdout = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_stderr = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 295;BA.debugLine="StdErr.Initialize";
_stderr.Initialize();
 //BA.debugLineNum = 296;BA.debugLine="StdOut.Initialize";
_stdout.Initialize();
 //BA.debugLineNum = 298;BA.debugLine="lat=lblLat.Text";
_lat = mostCurrent._lbllat.getText();
 //BA.debugLineNum = 299;BA.debugLine="lon=lblLon.Text";
_lon = mostCurrent._lbllon.getText();
 //BA.debugLineNum = 302;BA.debugLine="lat = lat &\"0000000000\"";
_lat = _lat+"0000000000";
 //BA.debugLineNum = 303;BA.debugLine="lon = lon &\"0000000000\"";
_lon = _lon+"0000000000";
 //BA.debugLineNum = 305;BA.debugLine="Dim pos1 As Int";
_pos1 = 0;
 //BA.debugLineNum = 306;BA.debugLine="Dim pos2 As Int";
_pos2 = 0;
 //BA.debugLineNum = 307;BA.debugLine="pos1=lat.LastIndexOf(\".\")";
_pos1 = _lat.lastIndexOf(".");
 //BA.debugLineNum = 308;BA.debugLine="pos2=lon.LastIndexOf(\".\")";
_pos2 = _lon.lastIndexOf(".");
 //BA.debugLineNum = 309;BA.debugLine="pos1=pos1+6";
_pos1 = (int) (_pos1+6);
 //BA.debugLineNum = 310;BA.debugLine="pos2=pos2+6";
_pos2 = (int) (_pos2+6);
 //BA.debugLineNum = 312;BA.debugLine="lat=lat.SubString2(0,pos1)";
_lat = _lat.substring((int) (0),_pos1);
 //BA.debugLineNum = 313;BA.debugLine="lon=lon.SubString2(0,pos2)";
_lon = _lon.substring((int) (0),_pos2);
 //BA.debugLineNum = 315;BA.debugLine="url=\"https://geocode.xyz/\" & lat & \",\" & lon &\"";
_url = "https://geocode.xyz/"+_lat+","+_lon+"?geoit=xml";
 //BA.debugLineNum = 317;BA.debugLine="Dim args() As String";
_args = new String[(int) (0)];
java.util.Arrays.fill(_args,"");
 //BA.debugLineNum = 318;BA.debugLine="args = Array As String (\"-k\",\"-s\",url,\"|\",\"grep";
_args = new String[]{"-k","-s",_url,"|","grep","staddress"};
 //BA.debugLineNum = 320;BA.debugLine="ph.Shell(\"/data/data/com.rootsoft.ewap/files/bi";
_ph.Shell("/data/data/com.rootsoft.ewap/files/bin/curl",_args,(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 322;BA.debugLine="result=StdOut.ToString";
_result = _stdout.ToString();
 //BA.debugLineNum = 323;BA.debugLine="pos1=result.IndexOf(\"<staddress>\")";
_pos1 = _result.indexOf("<staddress>");
 //BA.debugLineNum = 324;BA.debugLine="pos2=result.IndexOf(\"</staddress>\")";
_pos2 = _result.indexOf("</staddress>");
 //BA.debugLineNum = 326;BA.debugLine="result=result.SubString2(pos1+11,pos2)";
_result = _result.substring((int) (_pos1+11),_pos2);
 //BA.debugLineNum = 330;BA.debugLine="If result <> \"\" Then";
if ((_result).equals("") == false) { 
 //BA.debugLineNum = 332;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 333;BA.debugLine="i=FindPositionStr(result,districts,True)";
_i = _findpositionstr(_result,mostCurrent._districts,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 336;BA.debugLine="If i <> indice Then";
if (_i!=_indice) { 
 //BA.debugLineNum = 337;BA.debugLine="LoadFor(i)";
_loadfor(_i);
 //BA.debugLineNum = 338;BA.debugLine="indice=i";
_indice = _i;
 };
 };
 //BA.debugLineNum = 344;BA.debugLine="Log(StdOut)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_stdout));
 //BA.debugLineNum = 345;BA.debugLine="Log(StdErr)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_stderr));
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return "";
}
public static int  _findpositionstr(String _target,anywheresoftware.b4a.objects.collections.List _l,boolean _higher) throws Exception{
int _imax = 0;
int _imin = 0;
int _imid = 0;
String _val = "";
 //BA.debugLineNum = 349;BA.debugLine="Sub FindPositionStr(Target As String, L As List, H";
 //BA.debugLineNum = 350;BA.debugLine="Dim iMax,iMin,iMid As Int";
_imax = 0;
_imin = 0;
_imid = 0;
 //BA.debugLineNum = 351;BA.debugLine="iMax=L.Size-1";
_imax = (int) (_l.getSize()-1);
 //BA.debugLineNum = 352;BA.debugLine="iMin=0";
_imin = (int) (0);
 //BA.debugLineNum = 354;BA.debugLine="iMid=iMin+((iMax-iMin)/2)";
_imid = (int) (_imin+((_imax-_imin)/(double)2));
 //BA.debugLineNum = 355;BA.debugLine="Dim Val As String = L.get(iMid)";
_val = BA.ObjectToString(_l.Get(_imid));
 //BA.debugLineNum = 358;BA.debugLine="Do While iMin < iMax";
while (_imin<_imax) {
 //BA.debugLineNum = 360;BA.debugLine="If Val.CompareTo(Target) < 0 Then";
if (_val.compareTo(_target)<0) { 
 //BA.debugLineNum = 361;BA.debugLine="iMin=iMid+1";
_imin = (int) (_imid+1);
 }else {
 //BA.debugLineNum = 363;BA.debugLine="iMax=iMid";
_imax = _imid;
 };
 //BA.debugLineNum = 366;BA.debugLine="iMid=iMin+((iMax-iMin)/2)";
_imid = (int) (_imin+((_imax-_imin)/(double)2));
 //BA.debugLineNum = 367;BA.debugLine="Val = L.get(iMid)";
_val = BA.ObjectToString(_l.Get(_imid));
 }
;
 //BA.debugLineNum = 370;BA.debugLine="If Higher Then";
if (_higher) { 
 //BA.debugLineNum = 371;BA.debugLine="If Target.CompareTo(Val) > 0 Then";
if (_target.compareTo(_val)>0) { 
 //BA.debugLineNum = 372;BA.debugLine="Return -1";
if (true) return (int) (-1);
 }else {
 //BA.debugLineNum = 374;BA.debugLine="Return iMid";
if (true) return _imid;
 };
 }else {
 //BA.debugLineNum = 377;BA.debugLine="If Val.CompareTo(Target) > 0 Then";
if (_val.compareTo(_target)>0) { 
 //BA.debugLineNum = 378;BA.debugLine="Return iMid - 1";
if (true) return (int) (_imid-1);
 }else {
 //BA.debugLineNum = 380;BA.debugLine="Return iMid";
if (true) return _imid;
 };
 };
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return 0;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 101;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 104;BA.debugLine="Dim lm As LocationManager";
mostCurrent._lm = new com.rootsoft.locationmanager.LocationManager1();
 //BA.debugLineNum = 105;BA.debugLine="Dim lblLon As Label";
mostCurrent._lbllon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 106;BA.debugLine="Dim lblLat As Label";
mostCurrent._lbllat = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 107;BA.debugLine="Dim lblSpeed As Label";
mostCurrent._lblspeed = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Public districts As List";
mostCurrent._districts = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 110;BA.debugLine="Dim indice As Int";
_indice = 0;
 //BA.debugLineNum = 112;BA.debugLine="Private Spinner1 As Spinner";
mostCurrent._spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 114;BA.debugLine="Private Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 115;BA.debugLine="Private Panel2 As Panel";
mostCurrent._panel2 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 116;BA.debugLine="Private ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 117;BA.debugLine="Private ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 118;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 119;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 120;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 121;BA.debugLine="Private Label4 As Label";
mostCurrent._label4 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 122;BA.debugLine="Private Label5 As Label";
mostCurrent._label5 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 123;BA.debugLine="Private Label6 As Label";
mostCurrent._label6 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 124;BA.debugLine="Private Label7 As Label";
mostCurrent._label7 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 125;BA.debugLine="Private Label8 As Label";
mostCurrent._label8 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 126;BA.debugLine="Private ListView1 As ListView";
mostCurrent._listview1 = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 127;BA.debugLine="Dim ImageView3 As ImageView";
mostCurrent._imageview3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 128;BA.debugLine="Dim ImageView4 As ImageView";
mostCurrent._imageview4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 132;BA.debugLine="End Sub";
return "";
}
public static String  _label1_click() throws Exception{
 //BA.debugLineNum = 467;BA.debugLine="Sub Label1_Click";
 //BA.debugLineNum = 470;BA.debugLine="StartActivity(ListAlerts)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._listalerts.getObject()));
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
public static String  _label2_click() throws Exception{
 //BA.debugLineNum = 476;BA.debugLine="Sub Label2_Click";
 //BA.debugLineNum = 477;BA.debugLine="StartActivity(FeedBack)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._feedback.getObject()));
 //BA.debugLineNum = 478;BA.debugLine="End Sub";
return "";
}
public static String  _loadfor(int _index) throws Exception{
 //BA.debugLineNum = 420;BA.debugLine="Sub LoadFor(index As Int)";
 //BA.debugLineNum = 425;BA.debugLine="Log(array_dis)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_array_dis));
 //BA.debugLineNum = 426;BA.debugLine="ToastMessageShow(\"Changing to...\"& Spinner1.GetIt";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Changing to..."+mostCurrent._spinner1.GetItem(_index)+"",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 428;BA.debugLine="Spinner1.SelectedIndex=index";
mostCurrent._spinner1.setSelectedIndex(_index);
 //BA.debugLineNum = 429;BA.debugLine="Label3.Text=districts.Get(index)";
mostCurrent._label3.setText(mostCurrent._districts.Get(_index));
 //BA.debugLineNum = 430;BA.debugLine="Label4.Text= \"Min \" & array_dis(index+1).Mn & \" C";
mostCurrent._label4.setText((Object)("Min "+BA.NumberToString(_array_dis[(int) (_index+1)].Mn)+" C"));
 //BA.debugLineNum = 431;BA.debugLine="Label5.Text= \"Max \" & array_dis(index+1).Mx & \" C";
mostCurrent._label5.setText((Object)("Max "+BA.NumberToString(_array_dis[(int) (_index+1)].Mx)+" C"));
 //BA.debugLineNum = 433;BA.debugLine="Select array_dis(index+1).adternoon";
switch (BA.switchObjectToInt(_array_dis[(int) (_index+1)].adternoon,(int) (1),(int) (2),(int) (3))) {
case 0:
 //BA.debugLineNum = 435;BA.debugLine="ImageView3.SetBackgroundImage(sol)";
mostCurrent._imageview3.SetBackgroundImage((android.graphics.Bitmap)(_sol.getObject()));
 break;
case 1:
 //BA.debugLineNum = 437;BA.debugLine="ImageView3.SetBackgroundImage(nublado)";
mostCurrent._imageview3.SetBackgroundImage((android.graphics.Bitmap)(_nublado.getObject()));
 break;
case 2:
 //BA.debugLineNum = 439;BA.debugLine="ImageView3.SetBackgroundImage(chuva)";
mostCurrent._imageview3.SetBackgroundImage((android.graphics.Bitmap)(_chuva.getObject()));
 break;
}
;
 //BA.debugLineNum = 442;BA.debugLine="Select array_dis(index+1).evening";
switch (BA.switchObjectToInt(_array_dis[(int) (_index+1)].evening,(int) (1),(int) (2),(int) (3))) {
case 0:
 //BA.debugLineNum = 444;BA.debugLine="ImageView4.SetBackgroundImage(noitelimpa)";
mostCurrent._imageview4.SetBackgroundImage((android.graphics.Bitmap)(_noitelimpa.getObject()));
 break;
case 1:
 //BA.debugLineNum = 446;BA.debugLine="ImageView4.SetBackgroundImage(noitelimpa)";
mostCurrent._imageview4.SetBackgroundImage((android.graphics.Bitmap)(_noitelimpa.getObject()));
 break;
case 2:
 //BA.debugLineNum = 448;BA.debugLine="ImageView4.SetBackgroundImage(noitelimpa)";
mostCurrent._imageview4.SetBackgroundImage((android.graphics.Bitmap)(_noitelimpa.getObject()));
 break;
}
;
 //BA.debugLineNum = 451;BA.debugLine="Select array_dis(index+1).morning";
switch (BA.switchObjectToInt(_array_dis[(int) (_index+1)].morning,(int) (1),(int) (2),(int) (3))) {
case 0:
 //BA.debugLineNum = 453;BA.debugLine="ImageView2.SetBackgroundImage(sol)";
mostCurrent._imageview2.SetBackgroundImage((android.graphics.Bitmap)(_sol.getObject()));
 break;
case 1:
 //BA.debugLineNum = 455;BA.debugLine="ImageView2.SetBackgroundImage(nublado)";
mostCurrent._imageview2.SetBackgroundImage((android.graphics.Bitmap)(_nublado.getObject()));
 break;
case 2:
 //BA.debugLineNum = 457;BA.debugLine="ImageView2.SetBackgroundImage(chuva)";
mostCurrent._imageview2.SetBackgroundImage((android.graphics.Bitmap)(_chuva.getObject()));
 break;
}
;
 //BA.debugLineNum = 465;BA.debugLine="End Sub";
return "";
}
public static String  _location_locationchanged(double _longitude,double _latitude,double _altitude,float _accuracy,float _bearing,String _provider,float _speed,long _time) throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Sub Location_LocationChanged (Longitude As Double,";
 //BA.debugLineNum = 395;BA.debugLine="lblLat.Text =Latitude";
mostCurrent._lbllat.setText((Object)(_latitude));
 //BA.debugLineNum = 396;BA.debugLine="lblLon.Text =Longitude";
mostCurrent._lbllon.setText((Object)(_longitude));
 //BA.debugLineNum = 397;BA.debugLine="lblSpeed.Text = $\"Speed = $1.2{Speed} m/s \"$";
mostCurrent._lblspeed.setText((Object)(("Speed = "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.2",(Object)(_speed))+" m/s ")));
 //BA.debugLineNum = 398;BA.debugLine="checkgps.Enabled = True";
_checkgps.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public static String  _location_providerdisabled(String _provider) throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Sub Location_ProviderDisabled (Provider As String)";
 //BA.debugLineNum = 402;BA.debugLine="Msgbox(\"Provider\",\"Provider Disabled\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Provider","Provider Disabled",mostCurrent.activityBA);
 //BA.debugLineNum = 403;BA.debugLine="End Sub";
return "";
}
public static String  _location_providerenabled(String _provider) throws Exception{
 //BA.debugLineNum = 405;BA.debugLine="Sub Location_ProviderEnabled (Provider As String)";
 //BA.debugLineNum = 406;BA.debugLine="Msgbox(\"Provider\",\"Provider Enabled\")";
anywheresoftware.b4a.keywords.Common.Msgbox("Provider","Provider Enabled",mostCurrent.activityBA);
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public static String  _location_statuschanged(String _provider,int _status) throws Exception{
 //BA.debugLineNum = 409;BA.debugLine="Sub Location_StatusChanged (Provider As String, St";
 //BA.debugLineNum = 410;BA.debugLine="Msgbox(\"Provider: \" & Provider & CRLF & \"Status:";
anywheresoftware.b4a.keywords.Common.Msgbox("Provider: "+_provider+anywheresoftware.b4a.keywords.Common.CRLF+"Status: "+BA.NumberToString(_status),"Status Changed",mostCurrent.activityBA);
 //BA.debugLineNum = 411;BA.debugLine="End Sub";
return "";
}
public static String  _position() throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Sub position";
 //BA.debugLineNum = 233;BA.debugLine="scale.SetRate(0.5)";
mostCurrent._scale._setrate(mostCurrent.activityBA,0.5);
 //BA.debugLineNum = 234;BA.debugLine="scale.SetTopAndBottom(Panel1,1,100%y)";
mostCurrent._scale._settopandbottom(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._panel1.getObject())),(int) (1),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 235;BA.debugLine="scale.SetLeftAndRight(Panel1,1,100%x)";
mostCurrent._scale._setleftandright(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._panel1.getObject())),(int) (1),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 236;BA.debugLine="Panel2.Height=40%y";
mostCurrent._panel2.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (40),mostCurrent.activityBA));
 //BA.debugLineNum = 237;BA.debugLine="Panel2.Width=80%x";
mostCurrent._panel2.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA));
 //BA.debugLineNum = 238;BA.debugLine="Panel2.Left=10%x";
mostCurrent._panel2.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
 //BA.debugLineNum = 239;BA.debugLine="Panel2.Left=40";
mostCurrent._panel2.setLeft((int) (40));
 //BA.debugLineNum = 240;BA.debugLine="scale.HorizontalCenter(Spinner1)";
mostCurrent._scale._horizontalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._spinner1.getObject())));
 //BA.debugLineNum = 241;BA.debugLine="Spinner1.Top=4%y";
mostCurrent._spinner1.setTop(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (4),mostCurrent.activityBA));
 //BA.debugLineNum = 242;BA.debugLine="Spinner1.Height=8%y";
mostCurrent._spinner1.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (8),mostCurrent.activityBA));
 //BA.debugLineNum = 243;BA.debugLine="Label2.Height=200";
mostCurrent._label2.setHeight((int) (200));
 //BA.debugLineNum = 244;BA.debugLine="Label1.Height=200";
mostCurrent._label1.setHeight((int) (200));
 //BA.debugLineNum = 245;BA.debugLine="Label2.Left=20";
mostCurrent._label2.setLeft((int) (20));
 //BA.debugLineNum = 246;BA.debugLine="Label1.Left=Panel1.Width-Label1.Width-20";
mostCurrent._label1.setLeft((int) (mostCurrent._panel1.getWidth()-mostCurrent._label1.getWidth()-20));
 //BA.debugLineNum = 247;BA.debugLine="Label1.Top=Panel1.Height-Label1.Height-200";
mostCurrent._label1.setTop((int) (mostCurrent._panel1.getHeight()-mostCurrent._label1.getHeight()-200));
 //BA.debugLineNum = 248;BA.debugLine="Label2.Top=Panel1.Height-Label2.Height-200";
mostCurrent._label2.setTop((int) (mostCurrent._panel1.getHeight()-mostCurrent._label2.getHeight()-200));
 //BA.debugLineNum = 249;BA.debugLine="Label1.Height=Label1.Width";
mostCurrent._label1.setHeight(mostCurrent._label1.getWidth());
 //BA.debugLineNum = 250;BA.debugLine="Label2.Height=Label2.Width";
mostCurrent._label2.setHeight(mostCurrent._label2.getWidth());
 //BA.debugLineNum = 251;BA.debugLine="ImageView2.Height=Panel2.Height/4";
mostCurrent._imageview2.setHeight((int) (mostCurrent._panel2.getHeight()/(double)4));
 //BA.debugLineNum = 252;BA.debugLine="ImageView3.Height=Panel2.Height/4";
mostCurrent._imageview3.setHeight((int) (mostCurrent._panel2.getHeight()/(double)4));
 //BA.debugLineNum = 253;BA.debugLine="ImageView4.Height=Panel2.Height/4";
mostCurrent._imageview4.setHeight((int) (mostCurrent._panel2.getHeight()/(double)4));
 //BA.debugLineNum = 255;BA.debugLine="ImageView2.Top=40";
mostCurrent._imageview2.setTop((int) (40));
 //BA.debugLineNum = 256;BA.debugLine="ImageView3.Top=250";
mostCurrent._imageview3.setTop((int) (250));
 //BA.debugLineNum = 257;BA.debugLine="ImageView4.Top=450";
mostCurrent._imageview4.setTop((int) (450));
 //BA.debugLineNum = 258;BA.debugLine="Label6.Top=150";
mostCurrent._label6.setTop((int) (150));
 //BA.debugLineNum = 259;BA.debugLine="Label7.Top=350";
mostCurrent._label7.setTop((int) (350));
 //BA.debugLineNum = 260;BA.debugLine="Label8.Top=550";
mostCurrent._label8.setTop((int) (550));
 //BA.debugLineNum = 261;BA.debugLine="ImageView2.Left=20";
mostCurrent._imageview2.setLeft((int) (20));
 //BA.debugLineNum = 262;BA.debugLine="ImageView3.Left=20";
mostCurrent._imageview3.setLeft((int) (20));
 //BA.debugLineNum = 263;BA.debugLine="ImageView4.Left=20";
mostCurrent._imageview4.setLeft((int) (20));
 //BA.debugLineNum = 264;BA.debugLine="Label6.Left=20";
mostCurrent._label6.setLeft((int) (20));
 //BA.debugLineNum = 265;BA.debugLine="Label7.Left=20";
mostCurrent._label7.setLeft((int) (20));
 //BA.debugLineNum = 266;BA.debugLine="Label8.Left=20";
mostCurrent._label8.setLeft((int) (20));
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        anywheresoftware.b4a.samples.httputils2.httputils2service._process_globals();
main._process_globals();
scale._process_globals();
listalerts._process_globals();
feedback._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim GPS1 As GPS";
_gps1 = new anywheresoftware.b4a.gps.GPS();
 //BA.debugLineNum = 17;BA.debugLine="Dim checkgps As Timer";
_checkgps = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 18;BA.debugLine="Dim Splashtimer As Timer";
_splashtimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 19;BA.debugLine="Dim array_dis(31) As fore";
_array_dis = new com.rootsoft.ewap.main._fore[(int) (31)];
{
int d0 = _array_dis.length;
for (int i0 = 0;i0 < d0;i0++) {
_array_dis[i0] = new com.rootsoft.ewap.main._fore();
}
}
;
 //BA.debugLineNum = 21;BA.debugLine="Public sms1 As String";
_sms1 = "";
 //BA.debugLineNum = 22;BA.debugLine="Public sms1_date As String";
_sms1_date = "";
 //BA.debugLineNum = 23;BA.debugLine="Public sms1_id As Int";
_sms1_id = 0;
 //BA.debugLineNum = 24;BA.debugLine="Public sms1_dis As Int";
_sms1_dis = 0;
 //BA.debugLineNum = 26;BA.debugLine="Public sms2 As String";
_sms2 = "";
 //BA.debugLineNum = 27;BA.debugLine="Public sms2_date As String";
_sms2_date = "";
 //BA.debugLineNum = 28;BA.debugLine="Public sms2_id As Int";
_sms2_id = 0;
 //BA.debugLineNum = 29;BA.debugLine="Public sms2_dis As Int";
_sms2_dis = 0;
 //BA.debugLineNum = 31;BA.debugLine="Public sms3 As String";
_sms3 = "";
 //BA.debugLineNum = 32;BA.debugLine="Public sms3_date As String";
_sms3_date = "";
 //BA.debugLineNum = 33;BA.debugLine="Public sms3_id As Int";
_sms3_id = 0;
 //BA.debugLineNum = 34;BA.debugLine="Public sms3_dis As Int";
_sms3_dis = 0;
 //BA.debugLineNum = 36;BA.debugLine="Type fore(id As Int, morning As Int , adternoon A";
;
 //BA.debugLineNum = 38;BA.debugLine="Dim sol,chuva,nublado,noitelimpa As Bitmap";
_sol = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_chuva = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_nublado = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_noitelimpa = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _sec() throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stdout = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stderr = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
anywheresoftware.b4a.objects.collections.Map _colroot_1 = null;
anywheresoftware.b4a.objects.collections.Map _colroot_2 = null;
anywheresoftware.b4a.objects.collections.Map _colroot_3 = null;
 //BA.debugLineNum = 43;BA.debugLine="Sub sec";
 //BA.debugLineNum = 45;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 46;BA.debugLine="Dim StdOut As StringBuilder";
_stdout = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Dim StdErr As StringBuilder";
_stderr = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 48;BA.debugLine="StdErr.Initialize";
_stderr.Initialize();
 //BA.debugLineNum = 49;BA.debugLine="StdOut.Initialize";
_stdout.Initialize();
 //BA.debugLineNum = 50;BA.debugLine="ph.Shell(\"/data/data/com.rootsoft.ewap/files/bin/c";
_ph.Shell("/data/data/com.rootsoft.ewap/files/bin/curl http://node2.oneacrefund.org/selects/php-select-temp.php",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="For i=0 To 30";
{
final int step27 = 1;
final int limit27 = (int) (30);
for (_i = (int) (0); (step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27); _i = ((int)(0 + _i + step27))) {
 //BA.debugLineNum = 53;BA.debugLine="array_dis(i).adternoon=1";
_array_dis[_i].adternoon = (int) (1);
 //BA.debugLineNum = 54;BA.debugLine="array_dis(i).evening=2";
_array_dis[_i].evening = (int) (2);
 //BA.debugLineNum = 55;BA.debugLine="array_dis(i).morning=1";
_array_dis[_i].morning = (int) (1);
 //BA.debugLineNum = 56;BA.debugLine="array_dis(i).Mn=8";
_array_dis[_i].Mn = (int) (8);
 //BA.debugLineNum = 57;BA.debugLine="array_dis(i).Mx=22";
_array_dis[_i].Mx = (int) (22);
 }
};
 //BA.debugLineNum = 60;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 61;BA.debugLine="parser.Initialize(StdOut.ToString)";
_parser.Initialize(_stdout.ToString());
 //BA.debugLineNum = 62;BA.debugLine="Dim root As List = parser.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();
 //BA.debugLineNum = 63;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group37 = _root;
final int groupLen37 = group37.getSize();
for (int index37 = 0;index37 < groupLen37 ;index37++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group37.Get(index37)));
 //BA.debugLineNum = 64;BA.debugLine="i=colroot.Get(\"district_id\")";
_i = (int)(BA.ObjectToNumber(_colroot.Get((Object)("district_id"))));
 //BA.debugLineNum = 65;BA.debugLine="array_dis(i).morning=colroot.Get(\"morning\")";
_array_dis[_i].morning = (int)(BA.ObjectToNumber(_colroot.Get((Object)("morning"))));
 //BA.debugLineNum = 66;BA.debugLine="array_dis(i).evening=colroot.Get(\"evening\")";
_array_dis[_i].evening = (int)(BA.ObjectToNumber(_colroot.Get((Object)("evening"))));
 //BA.debugLineNum = 67;BA.debugLine="array_dis(i).adternoon=colroot.Get(\"afternoon\")";
_array_dis[_i].adternoon = (int)(BA.ObjectToNumber(_colroot.Get((Object)("afternoon"))));
 //BA.debugLineNum = 68;BA.debugLine="array_dis(i).Mn=colroot.Get(\"min_temp\")";
_array_dis[_i].Mn = (int)(BA.ObjectToNumber(_colroot.Get((Object)("min_temp"))));
 //BA.debugLineNum = 69;BA.debugLine="array_dis(i).Mx=colroot.Get(\"max_temp\")";
_array_dis[_i].Mx = (int)(BA.ObjectToNumber(_colroot.Get((Object)("max_temp"))));
 }
;
 //BA.debugLineNum = 73;BA.debugLine="StdOut.Initialize";
_stdout.Initialize();
 //BA.debugLineNum = 75;BA.debugLine="ph.Shell(\"/data/data/com.rootsoft.ewap/files/bin/";
_ph.Shell("/data/data/com.rootsoft.ewap/files/bin/curl http://node2.oneacrefund.org/selects/php-select-sms2.php",(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_stdout.getObject()),(java.lang.StringBuilder)(_stderr.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="parser.Initialize(StdOut.ToString)";
_parser.Initialize(_stdout.ToString());
 //BA.debugLineNum = 78;BA.debugLine="root = parser.NextArray";
_root = _parser.NextArray();
 //BA.debugLineNum = 80;BA.debugLine="Dim colroot_1 As Map = root.Get(0)";
_colroot_1 = new anywheresoftware.b4a.objects.collections.Map();
_colroot_1.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((int) (0))));
 //BA.debugLineNum = 81;BA.debugLine="sms1_dis=colroot_1.Get(\"sector_id\")";
_sms1_dis = (int)(BA.ObjectToNumber(_colroot_1.Get((Object)("sector_id"))));
 //BA.debugLineNum = 82;BA.debugLine="sms1=colroot_1.Get(\"messagebody\")";
_sms1 = BA.ObjectToString(_colroot_1.Get((Object)("messagebody")));
 //BA.debugLineNum = 83;BA.debugLine="sms1_date=colroot_1.Get(\"date\")";
_sms1_date = BA.ObjectToString(_colroot_1.Get((Object)("date")));
 //BA.debugLineNum = 84;BA.debugLine="sms1_id=colroot_1.Get(\"sms_id\")";
_sms1_id = (int)(BA.ObjectToNumber(_colroot_1.Get((Object)("sms_id"))));
 //BA.debugLineNum = 86;BA.debugLine="Dim colroot_2 As Map = root.Get(1)";
_colroot_2 = new anywheresoftware.b4a.objects.collections.Map();
_colroot_2.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((int) (1))));
 //BA.debugLineNum = 87;BA.debugLine="sms2_dis=colroot_2.Get(\"sector_id\")";
_sms2_dis = (int)(BA.ObjectToNumber(_colroot_2.Get((Object)("sector_id"))));
 //BA.debugLineNum = 88;BA.debugLine="sms2=colroot_2.Get(\"messagebody\")";
_sms2 = BA.ObjectToString(_colroot_2.Get((Object)("messagebody")));
 //BA.debugLineNum = 89;BA.debugLine="sms2_date=colroot_2.Get(\"date\")";
_sms2_date = BA.ObjectToString(_colroot_2.Get((Object)("date")));
 //BA.debugLineNum = 90;BA.debugLine="sms2_id=colroot_2.Get(\"sms_id\")";
_sms2_id = (int)(BA.ObjectToNumber(_colroot_2.Get((Object)("sms_id"))));
 //BA.debugLineNum = 92;BA.debugLine="Dim colroot_3 As Map = root.Get(2)";
_colroot_3 = new anywheresoftware.b4a.objects.collections.Map();
_colroot_3.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((int) (2))));
 //BA.debugLineNum = 93;BA.debugLine="sms3_dis=colroot_3.Get(\"sector_id\")";
_sms3_dis = (int)(BA.ObjectToNumber(_colroot_3.Get((Object)("sector_id"))));
 //BA.debugLineNum = 94;BA.debugLine="sms3=colroot_3.Get(\"messagebody\")";
_sms3 = BA.ObjectToString(_colroot_3.Get((Object)("messagebody")));
 //BA.debugLineNum = 95;BA.debugLine="sms3_date=colroot_3.Get(\"date\")";
_sms3_date = BA.ObjectToString(_colroot_3.Get((Object)("date")));
 //BA.debugLineNum = 96;BA.debugLine="sms3_id=colroot_3.Get(\"sms_id\")";
_sms3_id = (int)(BA.ObjectToNumber(_colroot_3.Get((Object)("sms_id"))));
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _spinner1_itemclick(int _po,Object _value) throws Exception{
 //BA.debugLineNum = 413;BA.debugLine="Sub Spinner1_ItemClick (po As Int, Value As Object";
 //BA.debugLineNum = 415;BA.debugLine="indice=po";
_indice = _po;
 //BA.debugLineNum = 416;BA.debugLine="LoadFor(po)";
_loadfor(_po);
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return "";
}
public static String  _splashtimer_tick() throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Sub SplashTimer_Tick";
 //BA.debugLineNum = 275;BA.debugLine="Splashtimer.Enabled=False";
_splashtimer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 276;BA.debugLine="ImageView1.RemoveView";
mostCurrent._imageview1.RemoveView();
 //BA.debugLineNum = 277;BA.debugLine="ImageView1.Visible = False";
mostCurrent._imageview1.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 278;BA.debugLine="Panel2.Visible = True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 279;BA.debugLine="Spinner1.Visible = True";
mostCurrent._spinner1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 280;BA.debugLine="scale.ScaleAll(Panel1,True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(mostCurrent._panel1.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 281;BA.debugLine="Label1.Visible=True";
mostCurrent._label1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 282;BA.debugLine="Label2.Visible=True";
mostCurrent._label2.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
}
