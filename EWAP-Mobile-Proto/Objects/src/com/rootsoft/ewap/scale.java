package com.rootsoft.ewap;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class scale {
private static scale mostCurrent = new scale();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static double _rate = 0;
public static double _cscalex = 0;
public static double _cscaley = 0;
public static double _cscaleds = 0;
public static int _crefwidth = 0;
public static int _crefheight = 0;
public static double _crefscale = 0;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public com.rootsoft.ewap.main _main = null;
public com.rootsoft.ewap.listalerts _listalerts = null;
public com.rootsoft.ewap.feedback _feedback = null;
public static int  _bottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 527;BA.debugLine="Public Sub Bottom(v As View) As Int";
 //BA.debugLineNum = 528;BA.debugLine="Return v.Top + v.Height";
if (true) return (int) (_v.getTop()+_v.getHeight());
 //BA.debugLineNum = 529;BA.debugLine="End Sub";
return 0;
}
public static float  _getdevicephysicalsize(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.keywords.LayoutValues _lv = null;
 //BA.debugLineNum = 148;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
 //BA.debugLineNum = 149;BA.debugLine="Dim lv As LayoutValues";
_lv = new anywheresoftware.b4a.keywords.LayoutValues();
 //BA.debugLineNum = 151;BA.debugLine="lv = GetDeviceLayoutValues";
_lv = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(_ba);
 //BA.debugLineNum = 152;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
if (true) return (float) (anywheresoftware.b4a.keywords.Common.Sqrt(anywheresoftware.b4a.keywords.Common.Power(_lv.Height/(double)_lv.Scale/(double)160,2)+anywheresoftware.b4a.keywords.Common.Power(_lv.Width/(double)_lv.Scale/(double)160,2)));
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return 0f;
}
public static double  _getscaleds(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub GetScaleDS As Double";
 //BA.debugLineNum = 133;BA.debugLine="Return cScaleDS";
if (true) return _cscaleds;
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Public Sub GetScaleX As Double";
 //BA.debugLineNum = 72;BA.debugLine="Return cScaleX";
if (true) return _cscalex;
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex_l(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Public Sub GetScaleX_L As Double";
 //BA.debugLineNum = 110;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 111;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 113;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex_p(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 121;BA.debugLine="Public Sub GetScaleX_P As Double";
 //BA.debugLineNum = 122;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 123;BA.debugLine="Return (100%y / cRefWidth / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_crefwidth/(double)_crefscale);
 }else {
 //BA.debugLineNum = 125;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Public Sub GetScaleY As Double";
 //BA.debugLineNum = 78;BA.debugLine="Return cScaleY";
if (true) return _cscaley;
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley_l(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Public Sub GetScaleY_L As Double";
 //BA.debugLineNum = 86;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 87;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 89;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley_p(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="Public Sub GetScaleY_P As Double";
 //BA.debugLineNum = 98;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 99;BA.debugLine="Return (100%y / (cRefHeight - 50dip) / cRefScale";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 101;BA.debugLine="Return (1 + Rate * (100%y / (cRefHeight - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return 0;
}
public static String  _horizontalcenter(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Public Sub HorizontalCenter(v As View)";
 //BA.debugLineNum = 362;BA.debugLine="v.Left = (100%x - v.Width) / 2";
_v.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getWidth())/(double)2));
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _horizontalcenter2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vleft,anywheresoftware.b4a.objects.ConcreteViewWrapper _vright) throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Public Sub HorizontalCenter2(v As View, vLeft As V";
 //BA.debugLineNum = 368;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Left";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(_vright.getLeft()-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 //BA.debugLineNum = 369;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 370;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("The view is an Activity !",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 371;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 373;BA.debugLine="If IsActivity(vLeft) Then";
if (_isactivity(_ba,_vleft)) { 
 //BA.debugLineNum = 374;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 375;BA.debugLine="v.Left = (100%x - v.Width) / 2";
_v.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getWidth())/(double)2));
 }else {
 //BA.debugLineNum = 377;BA.debugLine="v.Left = (vRight.Left - v.Width) / 2";
_v.setLeft((int) ((_vright.getLeft()-_v.getWidth())/(double)2));
 };
 }else {
 //BA.debugLineNum = 380;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 381;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (100%x - (";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 }else {
 //BA.debugLineNum = 383;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Le";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(_vright.getLeft()-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 };
 };
 };
 //BA.debugLineNum = 387;BA.debugLine="End Sub";
return "";
}
public static String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
double _devicescale = 0;
 //BA.debugLineNum = 27;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 28;BA.debugLine="Dim DeviceScale As Double";
_devicescale = 0;
 //BA.debugLineNum = 29;BA.debugLine="DeviceScale = 100dip / 100";
_devicescale = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))/(double)100;
 //BA.debugLineNum = 33;BA.debugLine="If cRefHeight <> 480 Or cRefWidth <> 320 Or cRefS";
if (_crefheight!=480 || _crefwidth!=320 || _crefscale!=1) { 
 //BA.debugLineNum = 34;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 36;BA.debugLine="cScaleX = 100%x / cRefHeight / cRefScale / Devi";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefheight/(double)_crefscale/(double)_devicescale;
 //BA.debugLineNum = 37;BA.debugLine="cScaleY = 100%y / (cRefWidth - 50 * cRefScale)";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-50*_crefscale)/(double)_devicescale;
 }else {
 //BA.debugLineNum = 40;BA.debugLine="cScaleX = 100%x / cRefWidth / cRefScale / Devic";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefwidth/(double)_crefscale/(double)_devicescale;
 //BA.debugLineNum = 41;BA.debugLine="cScaleY = 100%y / (cRefHeight - 50dip * cRefSca";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))*_crefscale)/(double)_devicescale;
 };
 }else {
 //BA.debugLineNum = 44;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 45;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 47;BA.debugLine="cScaleX = 100%x / cRefHeight / cRefScale / Dev";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefheight/(double)_crefscale/(double)_devicescale;
 //BA.debugLineNum = 48;BA.debugLine="cScaleY = 100%y / (cRefWidth - 50 * cRefScale)";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-50*_crefscale)/(double)_devicescale;
 }else {
 //BA.debugLineNum = 51;BA.debugLine="cScaleX = 100%x / cRefWidth / cRefScale / Devi";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefwidth/(double)_crefscale/(double)_devicescale;
 //BA.debugLineNum = 52;BA.debugLine="cScaleY = 100%y / (cRefHeight - 50 * cRefScale";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-50*_crefscale)/(double)_devicescale;
 };
 }else {
 //BA.debugLineNum = 55;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 57;BA.debugLine="cScaleX = 1 + Rate * (100%x / cRefHeight / cRe";
_cscalex = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefheight/(double)_crefscale-1)/(double)_devicescale;
 //BA.debugLineNum = 58;BA.debugLine="cScaleY = 1 + Rate * (100%y / (cRefWidth - 50";
_cscaley = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-50*_crefscale)-1)/(double)_devicescale;
 }else {
 //BA.debugLineNum = 61;BA.debugLine="cScaleX = 1 + Rate * (100%x / cRefWidth / cRef";
_cscalex = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_crefwidth/(double)_crefscale-1)/(double)_devicescale;
 //BA.debugLineNum = 62;BA.debugLine="cScaleY = 1 + Rate * (100%y / (cRefHeight - 50";
_cscaley = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))*_crefscale)-1)/(double)_devicescale;
 };
 };
 //BA.debugLineNum = 65;BA.debugLine="cScaleDS = 1 + Rate * ((100%x + 100%y) / (cRefWi";
_cscaleds = 1+_rate*((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba))/(double)(_crefwidth+_crefheight-50*_crefscale)-1)/(double)_devicescale;
 };
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static boolean  _isactivity(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 548;BA.debugLine="Public Sub IsActivity(v As View) As Boolean";
 //BA.debugLineNum = 549;BA.debugLine="Try";
try { //BA.debugLineNum = 550;BA.debugLine="v.Left = v.Left";
_v.setLeft(_v.getLeft());
 //BA.debugLineNum = 551;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 } 
       catch (Exception e357) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e357); //BA.debugLineNum = 553;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 555;BA.debugLine="End Sub";
return false;
}
public static boolean  _ispanel(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 533;BA.debugLine="Public Sub IsPanel(v As View) As Boolean";
 //BA.debugLineNum = 534;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.BALayout\" T";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.BALayout")) { 
 //BA.debugLineNum = 535;BA.debugLine="Try";
try { //BA.debugLineNum = 536;BA.debugLine="v.Left = v.Left";
_v.setLeft(_v.getLeft());
 //BA.debugLineNum = 537;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e346) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e346); //BA.debugLineNum = 539;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 }else {
 //BA.debugLineNum = 542;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 544;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Public Rate As Double";
_rate = 0;
 //BA.debugLineNum = 19;BA.debugLine="Rate = 0.3 'value between 0 to 1.";
_rate = 0.3;
 //BA.debugLineNum = 20;BA.debugLine="Private cScaleX, cScaleY, cScaleDS As Double";
_cscalex = 0;
_cscaley = 0;
_cscaleds = 0;
 //BA.debugLineNum = 21;BA.debugLine="Private cRefWidth = 320 As Int";
_crefwidth = (int) (320);
 //BA.debugLineNum = 22;BA.debugLine="Private cRefHeight = 480 As Int";
_crefheight = (int) (480);
 //BA.debugLineNum = 23;BA.debugLine="Private cRefScale = 1 As Double";
_crefscale = 1;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static int  _right(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 522;BA.debugLine="Public Sub Right(v As View) As Int";
 //BA.debugLineNum = 523;BA.debugLine="Return v.Left + v.Width";
if (true) return (int) (_v.getLeft()+_v.getWidth());
 //BA.debugLineNum = 524;BA.debugLine="End Sub";
return 0;
}
public static String  _scaleall(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _act,boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 248;BA.debugLine="Public Sub ScaleAll(act As Activity, FirstTime As";
 //BA.debugLineNum = 249;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 252;BA.debugLine="If IsPanel(act) AND FirstTime = True Then";
if (_ispanel(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_act.getObject()))) && _firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 254;BA.debugLine="ScaleView(act)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_act.getObject())));
 }else {
 //BA.debugLineNum = 256;BA.debugLine="For I = 0 To act.NumberOfViews - 1";
{
final int step149 = 1;
final int limit149 = (int) (_act.getNumberOfViews()-1);
for (_i = (int) (0); (step149 > 0 && _i <= limit149) || (step149 < 0 && _i >= limit149); _i = ((int)(0 + _i + step149))) {
 //BA.debugLineNum = 257;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 258;BA.debugLine="v = act.GetView(I)";
_v = _act.GetView(_i);
 //BA.debugLineNum = 259;BA.debugLine="ScaleView(v)";
_scaleview(_ba,_v);
 }
};
 };
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return "";
}
public static String  _scaleallds(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _act,boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 344;BA.debugLine="Public Sub ScaleAllDS(act As Activity, FirstTime A";
 //BA.debugLineNum = 345;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 348;BA.debugLine="If IsPanel(act) AND FirstTime = True Then";
if (_ispanel(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_act.getObject()))) && _firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 350;BA.debugLine="ScaleViewDS(act)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_act.getObject())));
 }else {
 //BA.debugLineNum = 352;BA.debugLine="For I = 0 To act.NumberOfViews - 1";
{
final int step208 = 1;
final int limit208 = (int) (_act.getNumberOfViews()-1);
for (_i = (int) (0); (step208 > 0 && _i <= limit208) || (step208 < 0 && _i >= limit208); _i = ((int)(0 + _i + step208))) {
 //BA.debugLineNum = 353;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 354;BA.debugLine="v = act.GetView(I)";
_v = _act.GetView(_i);
 //BA.debugLineNum = 355;BA.debugLine="ScaleViewDS(v)";
_scaleviewds(_ba,_v);
 }
};
 };
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public static String  _scaleview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _scv = null;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hcv = null;
anywheresoftware.b4a.objects.ListViewWrapper _ltv = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 158;BA.debugLine="Public Sub ScaleView(v As View)";
 //BA.debugLineNum = 159;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 160;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 163;BA.debugLine="v.Left = v.Left * cScaleX";
_v.setLeft((int) (_v.getLeft()*_cscalex));
 //BA.debugLineNum = 164;BA.debugLine="v.Top = v.Top * cScaleY";
_v.setTop((int) (_v.getTop()*_cscaley));
 //BA.debugLineNum = 165;BA.debugLine="If IsPanel(v) Then";
if (_ispanel(_ba,_v)) { 
 //BA.debugLineNum = 166;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 167;BA.debugLine="pnl = v";
_pnl.setObject((android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 168;BA.debugLine="If pnl.Background Is BitmapDrawable Then";
if (_pnl.getBackground() instanceof android.graphics.drawable.BitmapDrawable) { 
 //BA.debugLineNum = 171;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
_v.setWidth((int) (_v.getWidth()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 //BA.debugLineNum = 172;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
_v.setHeight((int) (_v.getHeight()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 }else {
 //BA.debugLineNum = 174;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 //BA.debugLineNum = 175;BA.debugLine="v.Height = v.Height * cScaleY";
_v.setHeight((int) (_v.getHeight()*_cscaley));
 };
 //BA.debugLineNum = 177;BA.debugLine="ScaleAll(pnl, False)";
_scaleall(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 }else if(_v.getObjectOrNull() instanceof android.widget.ImageView) { 
 //BA.debugLineNum = 181;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
_v.setWidth((int) (_v.getWidth()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 //BA.debugLineNum = 182;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
_v.setHeight((int) (_v.getHeight()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 }else {
 //BA.debugLineNum = 184;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 //BA.debugLineNum = 185;BA.debugLine="v.Height = v.Height * cScaleY";
_v.setHeight((int) (_v.getHeight()*_cscaley));
 };
 //BA.debugLineNum = 188;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 189;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 190;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleX";
_lbl.setTextSize((float) (_lbl.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 193;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView")) { 
 //BA.debugLineNum = 196;BA.debugLine="Dim scv As ScrollView";
_scv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 197;BA.debugLine="scv = v";
_scv.setObject((android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 198;BA.debugLine="ScaleAll(scv.Panel, False)";
_scaleall(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_scv.getPanel().getObject())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 199;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleY";
_scv.getPanel().setHeight((int) (_scv.getPanel().getHeight()*_cscaley));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView")) { 
 //BA.debugLineNum = 203;BA.debugLine="Dim hcv As HorizontalScrollView";
_hcv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 204;BA.debugLine="hcv = v";
_hcv.setObject((android.widget.HorizontalScrollView)(_v.getObject()));
 //BA.debugLineNum = 205;BA.debugLine="ScaleAll(hcv.Panel, False)";
_scaleall(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_hcv.getPanel().getObject())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 206;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleX";
_hcv.getPanel().setWidth((int) (_hcv.getPanel().getWidth()*_cscalex));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView")) { 
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView")) { 
 //BA.debugLineNum = 218;BA.debugLine="Dim ltv As ListView";
_ltv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 219;BA.debugLine="ltv = v";
_ltv.setObject((anywheresoftware.b4a.objects.ListViewWrapper.SimpleListView)(_v.getObject()));
 //BA.debugLineNum = 220;BA.debugLine="ScaleView(ltv.SingleLineLayout.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getSingleLineLayout().Label.getObject())));
 //BA.debugLineNum = 221;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
_ltv.getSingleLineLayout().setItemHeight((int) (_ltv.getSingleLineLayout().getItemHeight()*_cscaley));
 //BA.debugLineNum = 223;BA.debugLine="ScaleView(ltv.TwoLinesLayout.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().Label.getObject())));
 //BA.debugLineNum = 224;BA.debugLine="ScaleView(ltv.TwoLinesLayout.SecondLabel)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().SecondLabel.getObject())));
 //BA.debugLineNum = 225;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
_ltv.getTwoLinesLayout().setItemHeight((int) (_ltv.getTwoLinesLayout().getItemHeight()*_cscaley));
 //BA.debugLineNum = 227;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().Label.getObject())));
 //BA.debugLineNum = 228;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.SecondLabel)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().SecondLabel.getObject())));
 //BA.debugLineNum = 229;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.ImageView)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().ImageView.getObject())));
 //BA.debugLineNum = 230;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
_ltv.getTwoLinesAndBitmap().setItemHeight((int) (_ltv.getTwoLinesAndBitmap().getItemHeight()*_cscaley));
 //BA.debugLineNum = 232;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
_ltv.getTwoLinesAndBitmap().ImageView.setTop((int) ((_ltv.getTwoLinesAndBitmap().getItemHeight()-_ltv.getTwoLinesAndBitmap().ImageView.getHeight())/(double)2));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 236;BA.debugLine="Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 237;BA.debugLine="spn = v";
_spn.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 238;BA.debugLine="spn.TextSize = spn.TextSize * cScaleX";
_spn.setTextSize((float) (_spn.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public static String  _scaleviewds(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _scv = null;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hcv = null;
anywheresoftware.b4a.objects.ListViewWrapper _ltv = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 267;BA.debugLine="Public Sub ScaleViewDS(v As View)";
 //BA.debugLineNum = 268;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 269;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 272;BA.debugLine="v.Left = v.Left * cScaleDS";
_v.setLeft((int) (_v.getLeft()*_cscaleds));
 //BA.debugLineNum = 273;BA.debugLine="v.Top = v.Top * cScaleDS";
_v.setTop((int) (_v.getTop()*_cscaleds));
 //BA.debugLineNum = 274;BA.debugLine="v.Width = v.Width * cScaleDS";
_v.setWidth((int) (_v.getWidth()*_cscaleds));
 //BA.debugLineNum = 275;BA.debugLine="v.Height = v.Height * cScaleDS";
_v.setHeight((int) (_v.getHeight()*_cscaleds));
 //BA.debugLineNum = 277;BA.debugLine="If IsPanel(v) Then";
if (_ispanel(_ba,_v)) { 
 //BA.debugLineNum = 278;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 279;BA.debugLine="pnl = v";
_pnl.setObject((android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 280;BA.debugLine="ScaleAllDS(pnl, False)";
_scaleallds(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_pnl.getObject())),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 283;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 284;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 285;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleDS";
_lbl.setTextSize((float) (_lbl.getTextSize()*_cscaleds));
 };
 //BA.debugLineNum = 288;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView")) { 
 //BA.debugLineNum = 291;BA.debugLine="Dim scv As ScrollView";
_scv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 292;BA.debugLine="scv = v";
_scv.setObject((android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 293;BA.debugLine="ScaleAllDS(scv.Panel, False)";
_scaleallds(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_scv.getPanel().getObject())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 294;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleDS";
_scv.getPanel().setHeight((int) (_scv.getPanel().getHeight()*_cscaleds));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView")) { 
 //BA.debugLineNum = 298;BA.debugLine="Dim hcv As HorizontalScrollView";
_hcv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 299;BA.debugLine="hcv = v";
_hcv.setObject((android.widget.HorizontalScrollView)(_v.getObject()));
 //BA.debugLineNum = 300;BA.debugLine="ScaleAllDS(hcv.Panel, False)";
_scaleallds(_ba,(anywheresoftware.b4a.objects.ActivityWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ActivityWrapper(), (anywheresoftware.b4a.BALayout)(_hcv.getPanel().getObject())),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 301;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleDS";
_hcv.getPanel().setWidth((int) (_hcv.getPanel().getWidth()*_cscaleds));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView")) { 
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView")) { 
 //BA.debugLineNum = 313;BA.debugLine="Dim ltv As ListView";
_ltv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 314;BA.debugLine="ltv = v";
_ltv.setObject((anywheresoftware.b4a.objects.ListViewWrapper.SimpleListView)(_v.getObject()));
 //BA.debugLineNum = 315;BA.debugLine="ScaleViewDS(ltv.SingleLineLayout.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getSingleLineLayout().Label.getObject())));
 //BA.debugLineNum = 316;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
_ltv.getSingleLineLayout().setItemHeight((int) (_ltv.getSingleLineLayout().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 318;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().Label.getObject())));
 //BA.debugLineNum = 319;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.SecondLabel)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().SecondLabel.getObject())));
 //BA.debugLineNum = 320;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
_ltv.getTwoLinesLayout().setItemHeight((int) (_ltv.getTwoLinesLayout().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 322;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().Label.getObject())));
 //BA.debugLineNum = 323;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.SecondLabel)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().SecondLabel.getObject())));
 //BA.debugLineNum = 324;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.ImageView)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().ImageView.getObject())));
 //BA.debugLineNum = 325;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
_ltv.getTwoLinesAndBitmap().setItemHeight((int) (_ltv.getTwoLinesAndBitmap().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 327;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
_ltv.getTwoLinesAndBitmap().ImageView.setTop((int) ((_ltv.getTwoLinesAndBitmap().getItemHeight()-_ltv.getTwoLinesAndBitmap().ImageView.getHeight())/(double)2));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 331;BA.debugLine="Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 332;BA.debugLine="spn = v";
_spn.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 333;BA.debugLine="spn.TextSize = spn.TextSize * cScaleDS";
_spn.setTextSize((float) (_spn.getTextSize()*_cscaleds));
 };
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public static String  _setbottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _ybottom) throws Exception{
 //BA.debugLineNum = 425;BA.debugLine="Sub SetBottom(v As View, yBottom As Int)";
 //BA.debugLineNum = 426;BA.debugLine="v.Top = yBottom - v.Height";
_v.setTop((int) (_ybottom-_v.getHeight()));
 //BA.debugLineNum = 427;BA.debugLine="End Sub";
return "";
}
public static String  _setleftandright(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _xleft,int _xright) throws Exception{
 //BA.debugLineNum = 431;BA.debugLine="Public Sub SetLeftAndRight(v As View, xLeft As Int";
 //BA.debugLineNum = 433;BA.debugLine="v.Left = Min(xLeft, xRight)";
_v.setLeft((int) (anywheresoftware.b4a.keywords.Common.Min(_xleft,_xright)));
 //BA.debugLineNum = 434;BA.debugLine="v.Width = Max(xLeft, xRight) - v.Left";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.Max(_xleft,_xright)-_v.getLeft()));
 //BA.debugLineNum = 435;BA.debugLine="End Sub";
return "";
}
public static String  _setleftandright2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vleft,int _dxl,anywheresoftware.b4a.objects.ConcreteViewWrapper _vright,int _dxr) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v1 = null;
 //BA.debugLineNum = 441;BA.debugLine="Public Sub SetLeftAndRight2(v As View, vLeft As Vi";
 //BA.debugLineNum = 443;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 444;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("The view is an Activity !",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 445;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 449;BA.debugLine="If IsActivity(vLeft) = False And IsActivity(vRigh";
if (_isactivity(_ba,_vleft)==anywheresoftware.b4a.keywords.Common.False && _isactivity(_ba,_vright)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 450;BA.debugLine="If vLeft.Left > vRight.Left Then";
if (_vleft.getLeft()>_vright.getLeft()) { 
 //BA.debugLineNum = 451;BA.debugLine="Dim v1 As View";
_v1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 452;BA.debugLine="v1 = vLeft";
_v1 = _vleft;
 //BA.debugLineNum = 453;BA.debugLine="vLeft = vRight";
_vleft = _vright;
 //BA.debugLineNum = 454;BA.debugLine="vRight = v1";
_vright = _v1;
 };
 };
 //BA.debugLineNum = 458;BA.debugLine="If IsActivity(vLeft) Then";
if (_isactivity(_ba,_vleft)) { 
 //BA.debugLineNum = 459;BA.debugLine="v.Left = dxL";
_v.setLeft(_dxl);
 //BA.debugLineNum = 460;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 461;BA.debugLine="v.Width = 100%x - dxL - dxR";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_dxl-_dxr));
 }else {
 //BA.debugLineNum = 463;BA.debugLine="v.Width = vRight.Left - dxL - dxR";
_v.setWidth((int) (_vright.getLeft()-_dxl-_dxr));
 };
 }else {
 //BA.debugLineNum = 466;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + dxL";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+_dxl));
 //BA.debugLineNum = 467;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 468;BA.debugLine="v.Width = 100%x - v.Left";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getLeft()));
 }else {
 //BA.debugLineNum = 470;BA.debugLine="v.Width = vRight.Left - v.Left - dxR";
_v.setWidth((int) (_vright.getLeft()-_v.getLeft()-_dxr));
 };
 };
 //BA.debugLineNum = 473;BA.debugLine="End Sub";
return "";
}
public static String  _setrate(anywheresoftware.b4a.BA _ba,double _crate) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Public Sub SetRate(cRate As Double)";
 //BA.debugLineNum = 141;BA.debugLine="Rate = cRate";
_rate = _crate;
 //BA.debugLineNum = 142;BA.debugLine="Initialize";
_initialize(_ba);
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _setreferencelayout(anywheresoftware.b4a.BA _ba,int _width,int _height,double _scale) throws Exception{
 //BA.debugLineNum = 559;BA.debugLine="Public Sub SetReferenceLayout(Width As Int, Height";
 //BA.debugLineNum = 560;BA.debugLine="If cRefWidth < cRefHeight Then";
if (_crefwidth<_crefheight) { 
 //BA.debugLineNum = 561;BA.debugLine="cRefWidth = Width";
_crefwidth = _width;
 //BA.debugLineNum = 562;BA.debugLine="cRefHeight = Height";
_crefheight = _height;
 }else {
 //BA.debugLineNum = 564;BA.debugLine="cRefWidth = Height";
_crefwidth = _height;
 //BA.debugLineNum = 565;BA.debugLine="cRefHeight = Width";
_crefheight = _width;
 };
 //BA.debugLineNum = 567;BA.debugLine="cRefScale = Scale";
_crefscale = _scale;
 //BA.debugLineNum = 568;BA.debugLine="Initialize";
_initialize(_ba);
 //BA.debugLineNum = 569;BA.debugLine="End Sub";
return "";
}
public static String  _setright(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _xright) throws Exception{
 //BA.debugLineNum = 419;BA.debugLine="Sub SetRight(v As View, xRight As Int)";
 //BA.debugLineNum = 420;BA.debugLine="v.Left = xRight - v.Width";
_v.setLeft((int) (_xright-_v.getWidth()));
 //BA.debugLineNum = 421;BA.debugLine="End Sub";
return "";
}
public static String  _settopandbottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _ytop,int _ybottom) throws Exception{
 //BA.debugLineNum = 477;BA.debugLine="Public Sub SetTopAndBottom(v As View, yTop As Int,";
 //BA.debugLineNum = 479;BA.debugLine="v.Top = Min(yTop, yBottom)";
_v.setTop((int) (anywheresoftware.b4a.keywords.Common.Min(_ytop,_ybottom)));
 //BA.debugLineNum = 480;BA.debugLine="v.Height = Max(yTop, yBottom) - v.Top";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.Max(_ytop,_ybottom)-_v.getTop()));
 //BA.debugLineNum = 481;BA.debugLine="End Sub";
return "";
}
public static String  _settopandbottom2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vtop,int _dyt,anywheresoftware.b4a.objects.ConcreteViewWrapper _vbottom,int _dyb) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v1 = null;
 //BA.debugLineNum = 487;BA.debugLine="Public Sub SetTopAndBottom2(v As View, vTop As Vie";
 //BA.debugLineNum = 489;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 490;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("The view is an Activity !",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 491;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 494;BA.debugLine="If IsActivity(vTop) = False And IsActivity(vBotto";
if (_isactivity(_ba,_vtop)==anywheresoftware.b4a.keywords.Common.False && _isactivity(_ba,_vbottom)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 496;BA.debugLine="If vTop.Top > vBottom.Top Then";
if (_vtop.getTop()>_vbottom.getTop()) { 
 //BA.debugLineNum = 497;BA.debugLine="Dim v1 As View";
_v1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 498;BA.debugLine="v1 = vTop";
_v1 = _vtop;
 //BA.debugLineNum = 499;BA.debugLine="vTop = vBottom";
_vtop = _vbottom;
 //BA.debugLineNum = 500;BA.debugLine="vBottom = v1";
_vbottom = _v1;
 };
 };
 //BA.debugLineNum = 504;BA.debugLine="If IsActivity(vTop) Then";
if (_isactivity(_ba,_vtop)) { 
 //BA.debugLineNum = 505;BA.debugLine="v.Top = dyT";
_v.setTop(_dyt);
 //BA.debugLineNum = 506;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 507;BA.debugLine="v.Height = 100%y - dyT - dyB";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_dyt-_dyb));
 }else {
 //BA.debugLineNum = 509;BA.debugLine="v.Height = vBottom.Top - dyT - dyB";
_v.setHeight((int) (_vbottom.getTop()-_dyt-_dyb));
 };
 }else {
 //BA.debugLineNum = 512;BA.debugLine="v.Top = vTop.Top + vTop.Height + dyT";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+_dyt));
 //BA.debugLineNum = 513;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 514;BA.debugLine="v.Height = 100%y - v.Top - dyB";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getTop()-_dyb));
 }else {
 //BA.debugLineNum = 516;BA.debugLine="v.Height = vBottom.Top - v.Top - dyB";
_v.setHeight((int) (_vbottom.getTop()-_v.getTop()-_dyb));
 };
 };
 //BA.debugLineNum = 519;BA.debugLine="End Sub";
return "";
}
public static String  _verticalcenter(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 390;BA.debugLine="Public Sub VerticalCenter(v As View)";
 //BA.debugLineNum = 391;BA.debugLine="v.Top = (100%y - v.Height) / 2";
_v.setTop((int) ((anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getHeight())/(double)2));
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public static String  _verticalcenter2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vtop,anywheresoftware.b4a.objects.ConcreteViewWrapper _vbottom) throws Exception{
 //BA.debugLineNum = 396;BA.debugLine="Public Sub VerticalCenter2(v As View, vTop As View";
 //BA.debugLineNum = 397;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 398;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("The view is an Activity !",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 399;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 401;BA.debugLine="If IsActivity(vTop) Then";
if (_isactivity(_ba,_vtop)) { 
 //BA.debugLineNum = 402;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 403;BA.debugLine="v.Top = (100%y - v.Height) / 2";
_v.setTop((int) ((anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getHeight())/(double)2));
 }else {
 //BA.debugLineNum = 405;BA.debugLine="v.Top = (vBottom.Top - v.Height) / 2";
_v.setTop((int) ((_vbottom.getTop()-_v.getHeight())/(double)2));
 };
 }else {
 //BA.debugLineNum = 408;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 409;BA.debugLine="v.Top = vTop.Top + vTop.Height + (100%y - (vTo";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-(_vtop.getTop()+_vtop.getHeight())-_v.getHeight())/(double)2));
 }else {
 //BA.debugLineNum = 411;BA.debugLine="v.Top = vTop.Top + vTop.Height + (vBottom.Top";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+(_vbottom.getTop()-(_vtop.getTop()+_vtop.getHeight())-_v.getHeight())/(double)2));
 };
 };
 };
 //BA.debugLineNum = 415;BA.debugLine="End Sub";
return "";
}
}
