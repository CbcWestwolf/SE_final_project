package com.nightonke.leetcoder.tests;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import com.robotium.solo.Solo;
import com.robotium.solo.Solo.Config;
import junit.framework.AssertionFailedError;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.widget.*;

public class TestCase extends ActivityInstrumentationTestCase2{
private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME ="com.nightonke.leetcoder.Activity.MainActivity";
private Solo solo = null;
private WifiManager wifiManager = null;
private static Class<?> launcherActivityClass;
private long time = 0;
static {
try {
launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
} catch(ClassNotFoundException e) {
e.printStackTrace();
}
}
public TestCase() {
super(launcherActivityClass);
}
protected void setUp() throws Exception {
super.setUp();		
Config config = new Config();
config.timeout_small = 2000;
config.timeout_large = 2000;
config.screenshotSavePath = "/sdcard/Robotium-Screenshots/com.nightonke.leetcoder2018_01_11_20_41_46";
solo = new Solo(getInstrumentation(), config, getActivity());
Context context = solo.getCurrentActivity().getBaseContext();
wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
}
protected void tearDown() throws Exception {
solo.setWiFiData(true);
solo.finishOpenedActivities();
super.tearDown();
}
private void clickOnRate(double x, double y) {
DisplayMetrics  metrics = new DisplayMetrics();
solo.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
int width = metrics.widthPixels;
int hight = metrics.heightPixels;
int xpx = (int)(width * x);
int ypx = (int)(hight * y);
solo.clickOnScreen(xpx, ypx);
solo.sleep(500);
}
private void scrollorswipe(View view, int direction, double param1, double param2) {
int width = 0;
int height = 0;
int x = 0;
int y = 0;
if (null != view) {
int[] location = new int[2];
view.getLocationOnScreen(location);
x = location[0];
y = location[1];
width = view.getWidth();
height = view.getHeight();
} else {
DisplayMetrics  metrics = new DisplayMetrics();
solo.getCurrentActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
width = metrics.widthPixels;
height = metrics.heightPixels;
}
switch(direction) {
case Solo.DOWN:{
solo.drag(x + width/2, x + width/2, y + (int)(height*param1), y + (int)(height*param2), 1);
break;
}
case Solo.UP:{
solo.drag(x + width/2, x + width/2, y + (int)(height*param1), y + (int)(height*param2), 1);
break;
}
case Solo.LEFT:{
solo.drag(x + (int)(width*param1), x + (int)(width*param2), y + height/2, y + height/2, 1);
break;
}
case Solo.RIGHT:{
solo.drag(x + (int)(width*param1), x + (int)(width*param2), y + height/2, y + height/2, 1);
break;
}
}
}
    public void testCase000() throws Exception {
        View view = null;
        Activity act = null;
        solo.sleep(1000);
        solo.sleep(1000);
        view = solo.getView("com.nightonke.leetcoder:id/action_search");
        solo.clickOnView(view);
        solo.sleep(1000);
        solo.takeScreenshot("000-0");
    }

    public void testCase001() throws Exception {
        View view = null;
        Activity act = null;
        solo.sleep(1000);
        solo.sleep(1000);
        view = solo.getView("com.nightonke.leetcoder:id/action_sort");
        solo.clickOnView(view);
        solo.sleep(1000);
        solo.takeScreenshot("001-0");
    }

    public void testCase002() throws Exception {
        View view = null;
        Activity act = null;
        solo.sleep(1000);
        solo.sleep(1000);
        view = solo.getView("com.nightonke.leetcoder:id/action_sort");
        solo.clickOnView(view);
        solo.sleep(1000);
        solo.takeScreenshot("002-0");
        clickOnRate(0.5, ,);
        ;
        solo.sleep(1000);
        solo.takeScreenshot("002-1");
    }
}

