package com.mob.secverify.unity3d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.mob.MobSDK;
import com.mob.secverify.SecVerify;
import com.mob.tools.utils.UIHandler;
import com.unity3d.player.UnityPlayer;

public class SecVerifyUtils  implements Handler.Callback{
	private static boolean DEBUG = true;
	private static final int MSG_PREVERIFY = 1;
	private static final int MSG_VERIFY = 2;
	private static final int MSG_SET_UISETTING = 3;
	private static final int MSG_SET_LANDUISETTING = 4;
	private static Context context;
	private static String u3dGameObject;
	private static String u3dCallback;

	public SecVerifyUtils(String gameObject, String callback)
	{
		if (DEBUG) {
			System.out.println("SecVerifyUtils.prepare");
		}
		if (context == null) {
			context = UnityPlayer.currentActivity.getApplicationContext();
		}
		if (!TextUtils.isEmpty(gameObject)) {
			u3dGameObject = gameObject;
		}
		if (!TextUtils.isEmpty(callback)) {
			u3dCallback = callback;
		}
	}

	public void initSDK(String appKey, String screct)
	{
		if (DEBUG) {
			System.out.println("initSDK appkey ==>>" + appKey + "appscrect ==>>" + screct);
		}
		if ((!TextUtils.isEmpty(appKey)) && (!TextUtils.isEmpty(screct))) {
			MobSDK.init(context, appKey, screct);
		} else if (!TextUtils.isEmpty(appKey)) {
			MobSDK.init(context, appKey);
		} else {
			MobSDK.init(context);
		}
	}

	public void preVerify(){
		Message msg = new Message();
		msg.what = MSG_PREVERIFY;
		UIHandler.sendMessageDelayed(msg, 1000L, this);
	}

	public void verify(){
		Message msg = new Message();
		msg.what = MSG_VERIFY;
		UIHandler.sendMessageDelayed(msg, 1000L, this);
	}

	public void setUiSettings(String uiSettings){
		Message msg = new Message();
		msg.what = MSG_SET_UISETTING;
		msg.obj = uiSettings;
		UIHandler.sendMessageDelayed(msg, 1000L, this);
	}

	public void setLandUiSettings(String uiSettings){
		Message msg = new Message();
		msg.what = MSG_SET_LANDUISETTING;
		msg.obj = uiSettings;
		UIHandler.sendMessageDelayed(msg, 1000L, this);
	}

	public void refreshOAuthPage(){
		SecVerify.refreshOAuthPage();
	}

	public String getVersion(){
		if (DEBUG) {
			System.out.println("SecVerifyUtils.getVersion");
		}
		return SecVerify.getVersion();
	}

	public void setTimeOut(int time){
		SecVerify.setTimeOut(time);
	}

	public void setDebugMode(boolean debugMode){
		SecVerify.setDebugMode(debugMode);
	}

	public boolean handleMessage(Message msg)
	{
		switch (msg.what) {
			case MSG_PREVERIFY:
				if (DEBUG) {
					System.out.println("SecVerifyUtils.preVerify");
				}
				Unity3dOperationCallback callback = new Unity3dOperationCallback(u3dGameObject, u3dCallback);
				SecVerify.preVerify(callback);
				break;
			case MSG_VERIFY:
				if (DEBUG) {
					System.out.println("SecVerifyUtils.verify");
				}
				Unity3dVerifyCallback verifyCallback  = new Unity3dVerifyCallback(u3dGameObject, u3dCallback);
				SecVerify.verify(verifyCallback);
				break;
			case MSG_SET_UISETTING:
				if (DEBUG) {
					System.out.println("SecVerifyUtils.setUiSetting");
				}
				String uiSetting = (String)msg.obj;
				if (TextUtils.isEmpty(uiSetting)){
					System.out.println("UiSetting is empty");
					break;
				}

				SecVerify.setUiSettings(UiSettingsTransfer.transfer(context,uiSetting));
				break;
			case MSG_SET_LANDUISETTING:
				if (DEBUG) {
					System.out.println("SecVerifyUtils.setLandUiSetting");
				}
				String landUiSetting = (String)msg.obj;
				if (DEBUG) {
					System.out.println("LandUiSetting  ==>>" + landUiSetting);
				}
				if (TextUtils.isEmpty(landUiSetting)){
					System.out.println("LandUiSetting is empty");
					break;
				}
				SecVerify.setLandUiSettings(UiSettingsTransfer.transferLandUiSetting(context,landUiSetting));
				break;
		}
		return false;
	}

	//由于 unity 处于非unityplayeractivity的时候活动会停止，所以以下方法都无法使用
	public void finishOAuthPage(){
		SecVerify.finishOAuthPage();
	}

	public void autoFinishOAuthPage(boolean isFinish){
		SecVerify.autoFinishOAuthPage(isFinish);
	}

	public void otherLoginAutoFinishOAuthPage(boolean isFinish){
		SecVerify.otherLoginAutoFinishOAuthPage(isFinish);
	}

//	public void OtherOAuthPageCallBack(){
//		Unity3dOAuthPageOtherCallback callback = new Unity3dOAuthPageOtherCallback(u3dGameObject, u3dCallback);
//		SecVerify.OtherOAuthPageCallBack(callback);
//	}

}
