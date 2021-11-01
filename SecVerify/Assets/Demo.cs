using System;
using UnityEngine;
using UnityEditor;
using System.Collections;
using cn.SecVerifySDK.Unity;


public class Demo : MonoBehaviour, SecVerifySDKHandlers
{
    public GUISkin demoSkin;
    public SecVerify secVerify;
    private string phone;
    public Hashtable tokenInfo;
    private string completeResult = null;

    void Start()
    {
        secVerify = gameObject.GetComponent<SecVerify>();
        secVerify.init("moba6b6c6d6", "b89d2427a3bc7ad1aea1e1e8c1d36bf3");
        secVerify.setHandler(this);
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            Application.Quit();
        }
    }
  
    void OnGUI()
    {
        GUI.skin = demoSkin;
		float scale = 1.0f;
		if (Application.platform == RuntimePlatform.IPhonePlayer) {
			scale = Screen.width / 320;
		} else if (Application.platform == RuntimePlatform.Android) {
			if (Screen.orientation == ScreenOrientation.Portrait) {
				scale = Screen.width / 320;
		    } else {
			    scale = Screen.height / 320;
	        }
		}
				
		float btnWidth = 200 * scale;
		float btnHeight = 30 * scale;
		float btnTop = 50 * scale;
		GUI.skin.button.fontSize = Convert.ToInt32(14 * scale);
		GUI.skin.label.fontSize = Convert.ToInt32 (14 * scale);
		GUI.skin.label.alignment = TextAnchor.MiddleCenter;
		GUI.skin.textField.fontSize = Convert.ToInt32 (14 * scale);
		GUI.skin.textField.alignment = TextAnchor.MiddleCenter;

		float labelWidth = 60 * scale;
        
        btnTop += btnHeight + 10 * scale;
        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "同意隐私协议"))
        {
            Debug.Log("Secverify:cs " + "SecVerify-btn-submitPrivacyGrantStatus:");
            secVerify.submitPrivacyGrantStatus(true);  
        }

        btnTop += btnHeight + 10 * scale;
       
        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "秒验功能是否可用"))
        {
            secVerify.isSecVerifySupport();
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "获取秒验版本号"))
        {
            secVerify.getSDKVersion();
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "运营商类型"))
        {
            secVerify.operatorType();
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "清理缓存"))
        {
            secVerify.clearSDKCache();
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "登录预取号"))
        {
            secVerify.preLogin(5.0);
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "登录验证-自动关闭"))
        {
            SecVerifySDKUIConfig uiConfig = configLoginAuthVC(true);
            secVerify.loginAuth(uiConfig);
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "登录验证-手动关闭"))
        {

             SecVerifySDKUIConfig uiConfig = configLoginAuthVC(false);
             secVerify.loginAuth(uiConfig);
        }
        btnTop += btnHeight + 10 * scale;

        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "请求本机认证Token"))
        {
            secVerify.preMobileAuth(5.0);
        }
        btnTop += btnHeight + 10 * scale;
        phone = GUI.TextField(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), phone);
        btnTop += btnHeight + 10 * scale;
        if (GUI.Button(new Rect((Screen.width - btnWidth) / 2, btnTop + 5, btnWidth, btnHeight), "本机认证"))
        {
            Console.WriteLine("Current Token Token TokenInfo: {0}", MiniJSON.jsonEncode(tokenInfo));
            if (phone != null && phone.Length > 0 && tokenInfo != null)
            {
                secVerify.mobileAuth(phone, tokenInfo, 5.0);
            }
        }

        //展示回调结果
        btnTop += btnHeight + 10 * scale;
        GUIStyle style = new GUIStyle();
        style.normal.textColor = new Color(1, 0, 0);   //字体颜色
                                                       // style.fontSize = 30;
        style.fontSize = (int)(20 * scale);       //字体大小
        GUI.Label(new Rect(20, btnTop, Screen.width - 20 - 20, Screen.height - btnTop), completeResult, style);
    }

    // Callback Methods
    public void onComplete(SecVerifyResponseResult result) {
        
        SecVerifyActionType actionType = result.actionType;
        SecVerifyResultStatus status = result.status;
        Hashtable response = (Hashtable)result.response;
        if (response != null)
        {
            Hashtable ret = (Hashtable)response["ret"];
            completeResult = MiniJSON.jsonEncode(ret);
        }

        if (status == SecVerifyResultStatus.failure) {
            return;
        }
        switch (actionType)
            {
                case SecVerifyActionType.uploadPrivacyGrantResult:{
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs "+ "Demo-onComplet: " + MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.sdkSupport: {
                    Debug.Log("Secverify:cs " + "Demo-onComplet: sdkSupport");
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + "Demo-onComplet: " +MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.sdkVersion: {
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.operatorType: {
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.preLogin: {
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.loginAuth: {
                    switch (result.listenerType)
                    {
                        case SecVerifyIOSAuthPageListenerType.openAuthPageEvent:
                        case SecVerifyIOSAuthPageListenerType.cancelAuthPageEvent:
                        case SecVerifyIOSAuthPageListenerType.loginAuthEvent:
                        default:
                            Hashtable ret = (Hashtable)response["ret"];
                            Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                            break;
                    }
                }
                    break;
                case SecVerifyActionType.dismissAuthPage: {
                    Debug.Log("Secverify:cs " + "Dismiss Login Auth VC!");
                }
                    break;
                case SecVerifyActionType.preMobileAuth: {
                    tokenInfo = (Hashtable)response["ret"];
                    Console.WriteLine("Return return return Token: {0}", tokenInfo);
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(tokenInfo));
                }
                    break;
                case SecVerifyActionType.mobileAuth: {
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                }
                    break;
                case SecVerifyActionType.authPageCustomEvent: {
                    Hashtable ret = (Hashtable)response["ret"];
                    Debug.Log("Secverify:cs " + MiniJSON.jsonEncode(ret));
                }
                    break;
                // No Handlers
                case SecVerifyActionType.others:
                case SecVerifyActionType.registerApp:
                case SecVerifyActionType.enableDebug:
                case SecVerifyActionType.clearCache:
                case SecVerifyActionType.setCheckBox:
                case SecVerifyActionType.dismissLoading:
                default:
                    break;
            }
    }

    public void onError(SecVerifyResponseResult result) {
        SecVerifyActionType actionType = result.actionType;
        SecVerifyResultStatus status = result.status;
        Hashtable response = (Hashtable)result.response;

        Hashtable err = (Hashtable)response["err"];
        string err_msg = (string)err["err_desc"];
        int err_code = Convert.ToInt32(err["err_code"]);
        completeResult = err_code+ err_msg;
        Console.WriteLine("Secverify:cs " + "Error Code: {0}, Error Msg: {1}", err_code, err_msg);
    }

    private SecVerifySDKUIConfig configLoginAuthVC(bool manualDismiss) {
        if (Application.platform == RuntimePlatform.IPhonePlayer)
        {
            SecVerifySDKIOSUIConfig iOSConfig = new SecVerifySDKIOSUIConfig();
            iOSConfig.navBarHidden = true;
            iOSConfig.manualDismiss = manualDismiss;
            
            iOSConfig.prefersStatusBarHidden = false;
            iOSConfig.preferredStatusBarStyle = cn.SecVerifySDK.Unity.iOSStatusBarStyle.styleDefault;

            iOSConfig.shouldAutorotate = true;
            iOSConfig.supportedInterfaceOrientations = iOSInterfaceOrientationMask.all;
            iOSConfig.preferredInterfaceOrientationForPresentation = iOSInterfaceOrientation.portrait;

            iOSConfig.presentingWithAnimate = true;
            iOSConfig.modalTransitionStyle = iOSModalTransitionStyle.coverVertical;
            iOSConfig.modalPresentationStyle = iOSModalPresentationStyle.fullScreen;
            
            iOSConfig.showPrivacyWebVCByPresent = false;
            iOSConfig.privacyWebVCPreferredStatusBarStyle = cn.SecVerifySDK.Unity.iOSStatusBarStyle.styleDefault;
            iOSConfig.privacyWebVCModalPresentationStyle = iOSModalPresentationStyle.fullScreen;

            iOSConfig.overrideUserInterfaceStyle = iOSUserInterfaceStyle.unspecified;

            return iOSConfig;
        } else if (Application.platform == RuntimePlatform.Android) {
                SecVerifySDKAndroidUIConfig andConfig = new SecVerifySDKAndroidUIConfig();
                andConfig.manualDismiss = manualDismiss;
                andConfig.navHidden = false;
                andConfig.loginBtnTextStringName = "一键登录";
                andConfig.dialogTheme = false;
                andConfig.navCloseImgHidden = false;
                andConfig.sloganHidden = false;
                andConfig.checkboxDefaultState = false;
                andConfig.switchAccText = "切换账号";

            return andConfig;
        } else {
            SecVerifySDKOtherUIConfig otherConfig = new SecVerifySDKOtherUIConfig();

            return otherConfig;
        }
    }
}
