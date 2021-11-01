[TOC]
|文档版本|修订日期|修订说明|
|---|---|---|
|V1.0.0|2021.03.29|第一版|  
|V1.0.1|2021.05.25|完善插件安卓相关内容|  

## 秒验Unity插件版使用
### 秒验Unity插件的配置集成
#### IOS集成
1. 挂载SecVerify脚本
2. 导出Xcode项目
3. 配置Info.plist文件或调用init方法来设置appKey和appSecret
4. 因为部分运营商接口为HTTP请求，对于全局禁止HTTP的项目，需要设置HTTP白名单，建议按以下方式配置Info.plist文件。
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
    <key>NSExceptionDomains</key>
 <dict>
        <key>zzx9.cn</key>
        <dict>
            <key>NSIncludesSubdomains</key>
            <true/>
            <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
            <true/>
        </dict>
        <key>cmpassport.com</key>
        <dict>
            <key>NSIncludesSubdomains</key>
            <true/>
            <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
            <true/>
        </dict>
        <key>id6.me</key>
        <dict>
            <key>NSIncludesSubdomains</key>
            <true/>
            <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
            <true/>
        </dict>
        <key>wostore.cn</key>
        <dict>
            <key>NSIncludesSubdomains</key>
            <true/>
            <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
            <true/>
        </dict>
        <key>mdn.open.wo.cn</key>
        <dict>
            <key>NSIncludesSubdomains</key>
            <true/>
            <key>NSTemporaryExceptionAllowsInsecureHTTPLoads</key>
            <true/>
        </dict>
    </dict>
    <key>NSAllowsArbitraryLoads</key>
    <false/>
</dict>
</plist>
```
#### Android 集成
1. 打开Github下载SecVerify-For-Unity3D项目。将项目中的SecVerify/Assets/Plugins目录拷贝到您的项目的Assets目录中，或双击SecVerify.unitypackage导入相关文件。 注意该操作可能会覆盖您原来已经存在的文件！
2. 挂载SecVerify脚本
选择好需要挂接的GameObject(例如Main Camera),在右侧栏中点击Add Component，选择SMSSDK 进行挂接。如果需要使用Demo.cs文件，也需要进行挂接主相机。方法同挂接SMSSDK相同。
3. 在unity项目中的Build Settings-Player Settings勾选Custom Launcher GradleTemplate、Custom Base Gradle Template,然后在launcherTemplate.gradle中配置以下内容:
    
    ```
        // 下面是mob的配置
        apply plugin: 'com.mob.sdk'
        MobSDK {
        appKey "申请Mob的appkey"
        appSecret "申请Mob的AppSecret"

        SecVerify {
            version '3.1.0'
        }
        }
    ```
        然后在baseProjectTemplate.gradle中配置:
        ```
        dependencies {
            //添加mobSDK的classpath 
            classpath 'com.mob.sdk:MobSDK:+'
        }
        
         repositories {**ARTIFACTORYREPOSITORY**
	    //添加mobSDK的maven库地址
            maven {
                url "http://mvn.mob.com/android"
            }
            google()
            jcenter()
            flatDir {
                dirs "${project(':unityLibrary').projectDir}/libs"
            }
        }
    ```  
        或者在导出的Androidproject相对应的文件进行配置


### 秒验Unity插件方法
#### 初始化方法及回调方法设置

1. 首先，先引入命名空间 using cn.SecVerifySDK.Unity ，并声明 secVerify 的实例，如下：public SecVerify secVerify;并且进行设置：secVerify = gameObject.GetComponent<SecVerify>() 。

2. 实现 SecVerifySDKHandlers 并将它设置给 SecVerify，用来处理回调
    ```
    public class Demo : MonoBehaviour, SecVerifySDKHandlers
    {
    public GUISkin demoSkin;
    public SecVerify secVerify;
    private string phone;
    public Hashtable tokenInfo; 

    void Start()
    {
        secVerify = gameObject.GetComponent<SecVerify>();
        secVerify.setHandler(this);
    }
    
    public void onComplete(SecVerifyResponseResult result) {
        SecVerifyActionType actionType = result.actionType;
        SecVerifyResultStatus status = result.status;
        Hashtable response = (Hashtable)result.response;
    }
    public void onError(SecVerifyResponseResult result) {
        SecVerifyActionType actionType = result.actionType;
        SecVerifyResultStatus status = result.status;
        Hashtable response = (Hashtable)result.response;

        Hashtable err = (Hashtable)response["err"];
        string err_msg = (string)err["err_desc"];
        int err_code = Convert.ToInt32(err["err_code"]);
    }
    }
    ```  
#### 秒验功能方法   

1. 隐私协议接入
  ```
  /*
  * 上传隐私协议状态
  * params: isGrant 是否同意
  */
    submitPrivacyGrantStatus(true);
  ```

2. 预登录
  ```
  /*
  * 预登录
  * params: timeout 预登录超时时间
  * return: {"operator": "CUCC"}
  */
  void preLogin(double timeout);
  ```
3. 拉起授权页+一键登录
  ```
  /*
  * 拉起授权页+一键登录
  * params: uiconfig 自定义UI配置集合,必传
  * return:
  * {
  *    "opToken":"",
  *    "operator":"",
  *    "token":""
  * }
  */
  void loginAuth(SecVerifySDKUIConfig uiconfig)；
  ```
4. 本机认证预请求
  ```
  /*
  * 本机认证预请求
  * params: timeout 预请求超时时间
  * return:
  * {
  *    "opToken":"",
  *    "operator":"",
  *    "token":""
  * }
  */
  void preMobileAuth(double timeout)
  ```
  
5. 本机认证
  ```
  /*
  * 本机认证 安卓目前不支持
  * params:
  *   phoneNum 待验证手机号
  *   tokenInfo token信息
  *   timeout 本机认证超时时间
  * return:
  * {
  *     "isValid": 1,
  *     "valid": YES
  * }
  */
  void mobileAuth(string phoneNum, object tokenInfo, double timeout)
  ```

#### 秒验辅助方法

1. 手动关闭登录界面
   ```
   /**
    * 适用于需要手动关闭登录界面的场景 (如：model manualDismiss=YES,自定义视图按钮事件等)
    */
   void dismissLoginAuthVC(bool animated)
   ```
2. 手动关闭登录界面Loading
   ```
   void hideLoadingView()
   ```
3. 手动设置授权页面CheckBox勾选状态
   ```
   IOS设置：
   void setCheckBoxValue(bool isSelected)
   
   android该项设置在uiconfig中设置:
   andConfig.checkboxDefaultState = false;
   ```
4. 判断当前网络下是否可用(仅供参考)
   ```
   /**
    * 结果为YES 可以认证, NO 不能认证
    */
   void isSecVerifySupport()
   ```
5. 获取当前流量卡运营商(仅供参考,安卓暂不支持)
   ```
    /**
    * CMCC:移动 CUCC:联通 CTCC:电信 UNKNOW:未知
    */
   void operatorType()
   ```
6. 清空SDK内部缓存（安卓暂不支持）
   ```
   void clearSDKCache()
   ```
7. 开启SDK Debug模式
   ```
   void enableDebug(bool enable)
   ```
8. SDK版本号
   ```
   void getSDKVersion()
   ```
### 返回值格式
所有方法返回值为统一格式如下：
```
{
    "actionType": 0, // 详情请参考 enum SecVerifyActionType
    "listenerType": 0, // 详情请参考 enum SecVerifyIOSAuthPageListenerType
    "tag": "", // 自定义Button tag
    "status": 0, // 详情请参考 enum SecVerifyResultStatus
    "response": object // 对SDK返回值内容进行包装
}

response:
{
    "ret":{}, //成功时内容
    "err":{}, //错误信息
}
```

### 秒验Unity自定义UI的实现

秒验自定义主要是通过`SecVerifySDKIOSUIConfig`类来实现，可根据不同需求进行配置
 ```
        
 
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
        
        secVerify.loginAuth(uiConfig);
            
```

## 秒验Unity插件设计及实现
### 插件接口的设计实现

1. 用户应默认使用`SecVerify`类来使用秒验插件的所有功能，`SecVerify`根据不同的设备来调用不同的功能实现，对外提供统一的功能接口，负责处理、封装SDK返回事件。
2. `SecVerifySDKInterface`接口定义，抽象的规定了插件所能提供的功能
3. `SecVerifyIOSImpl`及`SecVerifyAndroidImpl`是`SecVerifySDKInterface`的具体实现，负责接入、调用以及传递参数给桥接文件定义好的方法，存储并传递observer。
4. `SecVerifySDKUIConfig`接口定义，为iOS和Android端UI自定义配置提供统一的接口
5. `SecVerifySDKIOSUIConfig`、`SecVerifySDKAndroidUIConfig`和`SecVerifySDKOtherUIConfig`都是`SecVerifySDKUIConfig`接口的具体实现，可在这些类里面实现不同的UI参数配置
6. `SecVerifySDKDefines`定义了插件统一的返回格式及使用到的enum
7. `SecVerifySDKIOSUIDefines`定义了iOS UI自定义相关的一些类型和值

### 秒验Unity插件架构
[![架构图](https://s3.ax1x.com/2021/03/19/6WilPe.png)](https://imgtu.com/i/6WilPe)

