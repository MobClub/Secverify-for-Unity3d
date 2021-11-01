using System;
using UnityEngine;
using System.Collections;

namespace cn.SecVerifySDK.Unity {
    public class SecVerify: MonoBehaviour {
        private SecVerifySDKInterface svsdkImpl;
        private SecVerifySDKHandlers handler;
        
        void Awake() {
            Console.WriteLine("[SecVerifySDK] SecVerifySDK ===>>> Awake");
    #if UNITY_ANDROID
            svsdkImpl = new SecVerifySDKAndroidImpl(gameObject);
            #elif UNITY_IPHONE
            svsdkImpl = new SecVerifyIOSImpl(gameObject);
#endif
        }

        /// <summary>
        /// Calls back.
        /// <summary>
        /// <param name="callBackData">Call back data.</param>
        private void _callback(string callbackData) {
            Console.WriteLine("SecVerify: _callback has been called" );
            if (callbackData == null)
            {
                return;
            }
           
            Hashtable dict = (Hashtable)MiniJSON.jsonDecode(callbackData);
            SecVerifyResponseResult result = (SecVerifyResponseResult)parseResponseDictToResult(dict);

            if (handler == null)
            {
                return;
            }

            if (result.status == 0)
            {
                handler.onComplete(result);
            } else
            {
                handler.onError(result);
            }
        }

        /// <summary>
        /// Set the call back handler.
        /// <summary>
        /// <param name="handler">Handler.</param>
        public void setHandler(SecVerifySDKHandlers handler) {
            this.handler = handler;
        }

        /// <summary>
        /// Set the call back handler.
        /// <summary>
        /// <param name="appKey">App Key.</param>
        /// <param name="appSecret">App Secret.</param>
        public void init(string appKey, string appSecret) {
            if (svsdkImpl != null)
            {
                svsdkImpl.init(appKey, appSecret);
            }
        }

        /// <summary>
        /// Submit privacy grant status.
        /// <summary>
        /// <param name="appKey">App Key.</param>
        public void submitPrivacyGrantStatus(bool status) {
            if (svsdkImpl != null)
            {
                svsdkImpl.submitPrivacyGrantStatus(status);
            }
        }

        /// <summary>
        /// Get the sdk version.
        /// <summary>
        public void getSDKVersion() {
            if (svsdkImpl != null)
            {
                svsdkImpl.sdkVersion();
            }
        }

        /// <summary>
        /// Set whether is debug mode
        /// <summary>
        /// <param name="enable">bool value.</param>
        public void enableDebug(bool enable) {
            if (svsdkImpl != null)
            {
                svsdkImpl.enableDebug(enable);
            }
        }

        /// <summary>
		/// SecVerify whether support.
		/// </summary>
        public void isSecVerifySupport() {
            if (svsdkImpl != null) {
                svsdkImpl.isVerifySupport();
            }
        }

        /// <summary>
		/// Method to clear cache.
		/// </summary>
        public void clearSDKCache() {
            if (svsdkImpl != null)
            {
                svsdkImpl.clearPhoneScripCache();
            }
        }

        /// <summary>
        /// Get the current operator type (for reference only)
        /// <summary>
        public void operatorType() {
            if (svsdkImpl != null)
            {
                svsdkImpl.currentOperatorType();
            }
        }

        /// <summary>
        /// Set the value of CheckBox
        /// <summary>
        /// <param name="isSelected">bool value.</param>
        public void setCheckBoxValue(bool isSelected) {
            if (svsdkImpl != null)
            {
                svsdkImpl.setCheckBoxValue(isSelected);
            }
        }

        /// <summary>
        /// PreLogin with timeout
        /// <summary>
        /// <param name="timeout">double value.</param>
        public void preLogin(double timeout) {
            if (svsdkImpl != null)
            {
                svsdkImpl.preLogin(timeout);
            }
        }

        /// <summary>
        /// Open the login auth vc
        /// <summary>
        /// <param name="uiconfig">The uiconfig.</param>
        public void loginAuth(SecVerifySDKUIConfig uiconfig) {
            if (svsdkImpl != null)
            {
                svsdkImpl.openAuthPage(uiconfig);
            }
        }

        /// <summary>
        /// Hide the loding view when manual dismiss the login auth vc.
        /// <summary>
        public void hideLoadingView() {
            if (svsdkImpl != null)
            {
                svsdkImpl.hideAuthPageLoading();
            }
        }

        /// <summary>
		/// Dismiss the auth page when the parameter is manual dismiss.
		/// </summary>
		/// <param name="animated">bool value</param>
        public void dismissLoginAuthVC(bool animated) {
            if (svsdkImpl != null)
            {
                svsdkImpl.finishAuthPage(animated);
            }
        }

        /// <summary>
		/// Request MobileAuth token
		/// </summary>
        public void preMobileAuth(double timeout) {
            if (svsdkImpl != null)
            {
                svsdkImpl.mobileAuthToken(timeout);
            }
        }

        /// <summary>
		/// Verify Phone Number With TokenInfo
		/// </summary>
        public void mobileAuth(string phoneNum, object tokenInfo, double timeout) {
            if (svsdkImpl != null)
            {
                svsdkImpl.mobileVerify(phoneNum, tokenInfo, timeout);
            }
        }

        private SecVerifyResponseResult parseResponseDictToResult(Hashtable response) {
            SecVerifyActionType actionType = (SecVerifyActionType)Convert.ToInt32(response["actionType"]);
            SecVerifyIOSAuthPageListenerType listenerType = (SecVerifyIOSAuthPageListenerType)Convert.ToInt32(response["listenerType"]);
            string tag = (string)response["tag"];
            SecVerifyResultStatus status = (SecVerifyResultStatus)Convert.ToInt32(response["status"]);
            object responseObj = (object)response["response"];

            SecVerifyResponseResult result = new SecVerifyResponseResult(actionType, status, responseObj, tag, listenerType);

            return result;
        }
    }
}