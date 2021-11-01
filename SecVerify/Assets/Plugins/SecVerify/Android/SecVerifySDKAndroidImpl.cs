using System;
using UnityEngine;
using System.Collections;
namespace cn.SecVerifySDK.Unity
{
#if UNITY_ANDROID
    public class SecVerifySDKAndroidImpl : SecVerifySDKInterface
    {
        private AndroidJavaObject secverifyObj;

        public SecVerifySDKAndroidImpl (GameObject go) 
	    {
	        try{
                secverifyObj = new AndroidJavaObject("com.secverify.unity3d.SecVerifyUtils", go.name, "_callback");
            } catch(Exception e) {
	            Console.WriteLine("{0} Exception caught.", e);
            }
        }

        public override void init(string appKey, string appSecret)
        {
            secverifyObj.Call("init", appKey, appSecret);

        }

        public override void submitPrivacyGrantStatus(bool status)
        {
             secverifyObj.Call("submitPrivacyGrantResult", status);
        }

        public override void isVerifySupport()
        {
            secverifyObj.Call("isVerifySupport");
        }

        public override void clearPhoneScripCache()
        {
            Debug.Log("SecVerifySDKAndroidImpl ==>>> clearPhoneScripCache");

        }

        public override void preLogin(double timeout)
        {
            secverifyObj.Call("preVerify", timeout);
        }


        public override void openAuthPage(SecVerifySDKUIConfig uiconfig)
        {
            string configStr = MiniJSON.jsonEncode(uiconfig.uiConfig());
//            secverifyObj.Call("setLandUiSettings", configStr);
//            secverifyObj.Call("setPortraitUiSettings", configStr);
//
//            Hashtable table = uiconfig.uiConfig();
//            bool isManualDismiss = (bool)table["manualDismiss"];
//            if(isManualDismiss)
//            {
//                secverifyObj.Call("autoFinishOauthPage", isManualDismiss);
//            }
//            else
//            {
//                secverifyObj.Call("autoFinishOauthPage", isManualDismiss);
//            }
            secverifyObj.Call("verify");
        }

        public override void currentOperatorType()
        {
            secverifyObj.Call("currentOperatorType");
        }

        public override void enableDebug(bool enable)
        {
            secverifyObj.Call("setDebugMode", enable);
        }

        public override void finishAuthPage(bool animated)
        {
            secverifyObj.Call("autoFinishOauthPage", animated);
        }

        public override void hideAuthPageLoading()
        {
            Debug.Log("SecVerifySDKAndroidImpl ==>>> hideAuthPageLoading: Android is not support yet");
        }

        public override void mobileAuthToken(double timeout)
        {
            secverifyObj.Call("getToken");
        }

        public override void mobileVerify(string phoneNum, object tokenInfo, double timeout)
        {
            Debug.Log("SecVerifySDKAndroidImpl ==>>> mobileVerify: Android is not support yet");
        }

        public override void sdkVersion()
        {
            secverifyObj.Call("getVersion");
        }

        public override void setCheckBoxValue(bool isSelected)
        {
            
        }
    }

    
#endif
}