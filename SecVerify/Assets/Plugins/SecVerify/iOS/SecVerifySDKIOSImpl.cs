using System;
using UnityEngine; 
using System.Collections;
using System.Collections.Generic;
using System.Runtime.InteropServices;

namespace cn.SecVerifySDK.Unity {
    #if UNITY_IPHONE || UNITY_IOS
    public class SecVerifyIOSImpl: SecVerifySDKInterface
    {
        [DllImport("__Internal")]
        static extern void __iosSubmitGrantResult(SecVerifyActionType actionType, 
                                                  bool status, 
                                                  string observer);
        [DllImport("__Internal")]
        static extern void __iosRegisterAppWithAppKeyAndAppSerect(SecVerifyActionType actionType, 
                                                                  string appKey, 
                                                                  string appSecret, 
                                                                  string observer);
        
        [DllImport("__Internal")]
        static extern void __iosPrelogin(SecVerifyActionType actionType, double timeout, string observer);
        [DllImport("__Internal")]
        static extern void __iosLoginAuth(SecVerifyActionType actionType, string uiconfig, string observer);
        [DllImport("__Internal")]
        static extern void __iosPreMobileAuth(SecVerifyActionType actionType, double time, string observer);
        [DllImport("__Internal")]
        static extern void __iosMobileAuth(SecVerifyActionType actionType, 
                                           string phoneNum, 
                                           string tokenInfo, 
                                           double timeout, 
                                           string observer);
        
        [DllImport("__Internal")]
        static extern void __iosDismissLoginAuthVCLoading(SecVerifyActionType actionType);
        [DllImport("__Internal")]
        static extern void __iosDismissLoginAuthVC(SecVerifyActionType actionType, bool animated, string observer);

        [DllImport("__Internal")]
        static extern void __iosGetSDKVersion(SecVerifyActionType actionType, string observer);
        [DllImport("__Internal")]
        static extern void __iosEnableSDKDebug(SecVerifyActionType actionType, bool enable);
        [DllImport("__Internal")]
        static extern void __iosClearSDKPhoneScripCache(SecVerifyActionType actionType, string observer);
        [DllImport("__Internal")]
        static extern void __iosGetCurrentOperatorType(SecVerifyActionType actionType, string observer);
        [DllImport("__Internal")]
        static extern void __iosSecVerifySupport(SecVerifyActionType actionType, string observer);
        [DllImport("__Internal")]
        static extern void __iosSetCheckBoxValue(SecVerifyActionType actionType, bool isSelected);
        
        // To get the callback id
        private string _callbackObjectName = "Main Camera";
        public SecVerifyIOSImpl(GameObject go)
        {
            try {
                _callbackObjectName = go.name;
            } catch (Exception e) {
                Console.WriteLine("{0} Exception caught: ", e);
            }
        }

        /// <summary>
        /// Init the specified appKey, appSecret
        /// <summary>
        /// <param name="appKey">Mob App Key.</param>
        /// <param name="appSecret">Mob App Secret.</param>
        public override void init(string appKey, string appSecret) {

            if (Application.platform == RuntimePlatform.IPhonePlayer)
            {
                __iosRegisterAppWithAppKeyAndAppSerect(SecVerifyActionType.registerApp, appKey, appSecret, _callbackObjectName);
            }
        }

        /// <summary>
		/// Upload the privacy grant status.
		/// </summary>
		/// <param name="status">Status.</param>
        public override void submitPrivacyGrantStatus(bool status) {
            __iosSubmitGrantResult(SecVerifyActionType.uploadPrivacyGrantResult, status, _callbackObjectName);
        }

        /// <summary>
        /// To get the SecVerifySDK's version
        /// <summary>
        public override void sdkVersion() {
            Console.WriteLine("Call SecVerify iOSImpl SDKVersion Method!");
            __iosGetSDKVersion(SecVerifyActionType.sdkVersion, _callbackObjectName);
        }

        /// <summary>
        /// Set whether is debug mode
        /// <summary>
        /// <param name="enable">bool value.</param>
        public override void enableDebug(bool enable) {
            __iosEnableSDKDebug(SecVerifyActionType.enableDebug, enable);
        }

        /// <summary>
        /// Is the SDK available
        /// <summary>
        public override void isVerifySupport() {
            __iosSecVerifySupport(SecVerifyActionType.sdkSupport, _callbackObjectName);
        }

        /// <summary>
        /// Clear the SDK cache
        /// <summary>
        public override void clearPhoneScripCache() {
            __iosClearSDKPhoneScripCache(SecVerifyActionType.clearCache, _callbackObjectName);
        }

        /// <summary>
        /// Get the current operator type (for reference only)
        /// <summary>
        public override void currentOperatorType() {
            __iosGetCurrentOperatorType(SecVerifyActionType.operatorType, _callbackObjectName);
        }

        /// <summary>
        /// PreLogin with timeout
        /// <summary>
        /// <param name="timeout">double value.</param>
        public override void preLogin(double timeout) {
            __iosPrelogin(SecVerifyActionType.preLogin, timeout, _callbackObjectName);
        }

        /// <summary>
        /// Set the value of CheckBox
        /// <summary>
        /// <param name="isSelected">bool value.</param>
        public override void setCheckBoxValue(bool isSelected) {
            __iosSetCheckBoxValue(SecVerifyActionType.setCheckBox, isSelected);
        }

        /// <summary>
        /// Open the login auth vc
        /// <summary>
        /// <param name="uiconfig">The uiconfig.</param>
        public override void openAuthPage(SecVerifySDKUIConfig uiconfig) {
            string configStr = MiniJSON.jsonEncode(uiconfig.uiConfig());
            __iosLoginAuth(SecVerifyActionType.loginAuth, configStr, _callbackObjectName);
        }

        /// <summary>
        /// Hide the loding view when manual dismiss the login auth vc.
        /// <summary>
        public override void hideAuthPageLoading() {
            __iosDismissLoginAuthVCLoading(SecVerifyActionType.dismissLoading);
        }

        /// <summary>
        /// Dismiss the login auth vc when manual dismiss
        /// <summary>
        /// <param name="animated">bool value.</param>
        public override void finishAuthPage(bool animated) {
            __iosDismissLoginAuthVC(SecVerifyActionType.dismissAuthPage, animated, _callbackObjectName);
        }

        /// <summary>
        /// Request the mobile auth token with timeout
        /// <summary>
        /// <param name="timeout">double value.</param>
        public override void mobileAuthToken(double timeout) {
            __iosPreMobileAuth(SecVerifyActionType.preMobileAuth, timeout, _callbackObjectName);
        }

        /// <summary>
        /// Verify that the phone number is correct
        /// <summary>
        /// <param name="phoneNum">phone number</param>
        /// <param name="tokenInfo">detail token info.</param>
        /// <param name="timeout">double value.</param>
        public override void mobileVerify(string phoneNum, 
                                          object tokenInfo, 
                                          double timeout) {
            string tokenInfoStr = (string)MiniJSON.jsonEncode(tokenInfo);                                  
            __iosMobileAuth(SecVerifyActionType.mobileAuth, phoneNum, tokenInfoStr, timeout, _callbackObjectName);
        }
    }
    #endif
}