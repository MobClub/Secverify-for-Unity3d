using System;
using System.Collections;

namespace cn.SecVerifySDK.Unity
{
    public enum SecVerifyResultStatus
    {
        success,
        failure,
    }

    public enum SecVerifyActionType
    {
        // tools method
        registerApp,
        uploadPrivacyGrantResult,
        sdkSupport,
        sdkVersion, 
        enableDebug,
        operatorType,
        clearCache,
        setCheckBox,
        // mobile auto login
        preLogin,
        loginAuth,
        dismissLoading,
        dismissAuthPage,
        // mobile num verify
        preMobileAuth,
        mobileAuth,
        // Custom Subviews Event
        authPageCustomEvent,
        // Other
        others
    }

    public enum SecVerifyIOSAuthPageListenerType
    {
        unknowEvent,
        openAuthPageEvent,
        cancelAuthPageEvent,
        loginAuthEvent,
    }

    public struct SecVerifyResponseResult
    {
        /// Parameters
        public SecVerifyActionType actionType;
        // If is android, don't need use this parameter.
        // If the platform is iOS and the action type == logingAuth, 
        // use this parameter to distinguish different callbacks.
        public SecVerifyIOSAuthPageListenerType listenerType;
        // If have added custom ui, the tag parameter was is to distinguish different UIs.
        public string tag;

        // success = 0, failure = 1
        public SecVerifyResultStatus status;
        // response
        public object response;

        /// Init method
        public SecVerifyResponseResult(SecVerifyActionType type,  
                                    SecVerifyResultStatus status, 
                                    object response,
                                    string tag = null, 
                                    SecVerifyIOSAuthPageListenerType pageListenerType = SecVerifyIOSAuthPageListenerType.unknowEvent) {
            this.actionType = type;
            this.listenerType = pageListenerType;
            this.tag = tag;
            this.status = status;
            this.response = response;
        }
    }

    public interface SecVerifySDKHandlers
    {
        void onComplete(SecVerifyResponseResult result);
        void onError(SecVerifyResponseResult error);
    }
}