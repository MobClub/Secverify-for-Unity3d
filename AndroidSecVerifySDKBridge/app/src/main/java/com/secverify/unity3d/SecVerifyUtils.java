package com.secverify.unity3d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.mobverify.MobVerify;
import com.mob.secverify.SecVerify;
import com.mob.secverify.VerifyCallback;
import com.mob.secverify.common.exception.VerifyException;
import com.mob.secverify.datatype.LandUiSettings;
import com.mob.secverify.datatype.UiSettings;
import com.mob.secverify.datatype.VerifyResult;
import com.mob.secverify.ui.component.CommonProgressDialog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.unity3d.player.UnityPlayer;

import java.util.HashMap;

public class SecVerifyUtils {
    private static Context context;
    private static String u3dGameObject;
    private static String u3dCallback;

    public SecVerifyUtils(final String gameObject,final String callback) {
        if (context == null) {
            context = UnityPlayer.currentActivity.getApplicationContext();
        }
        u3dGameObject = gameObject;
        u3dCallback = callback;
    }
    //初始化
    private void init(String appKey, String appSecret) {
        if (TextUtils.isEmpty(appKey) || TextUtils.isEmpty(appSecret))
            return;
        MobSDK.init(context, appKey, appSecret);
    }
    //隐私协议
    private void submitPrivacyGrantResult(boolean isGrant) {
        MobSDK.submitPolicyGrantResult(isGrant, new OperationCallback<Void>() {
            @Override
            public void onComplete(Void aVoid) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("onComplete",true);
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("1",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }

            @Override
            public void onFailure(Throwable throwable) {
                HashMap<Object, Object> map = new HashMap<>();
                map.put("onFailure",true);
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("1",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }
        });
    }
    //环境是否可用
    private void isVerifySupport() {
        Boolean isSupport = SecVerify.isVerifySupport();
        //将结果转换成json回调回去
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("isSupport",isSupport);
        String formatStr = FormartResponseUtils.getFormartCompleteResponse("2",map);
        UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
    }
    //获取秒验版本号
    private void getVersion() {
        String version = SecVerify.getVersion();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("version", version);
        String formatStr = FormartResponseUtils.getFormartCompleteResponse("3", map);
        UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
    }

    private void currentOperatorType(){
        try {
            int type = OperatorUtils.getCellularOperatorType();
            String tempString = "NOTSUPPORT";
            if (type == 1) {
                //CMCC
                tempString = "CMCC";
            } else if (type == 2) {
                // CUCC
                tempString = "CUCC";
            } else if (type == 3) {
                // CTCC
                tempString = "CTCC";
            }
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("operator",tempString);
            String formatStr = FormartResponseUtils.getFormartCompleteResponse("6",map);
            UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
        } catch (Throwable t) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("operatorErr",t.toString());
            String formatStr = FormartResponseUtils.getFormartCompleteResponse("6",map);
            UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
        }
    }

    /**
     * 预取号
     */
    private void preVerify(double timeout) {
        SecVerify.preVerify(new com.mob.secverify.OperationCallback() {
            @Override
            public void onComplete(Object o) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("success",true);
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("8", map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }

            @Override
            public void onFailure(VerifyException e) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("err_desc",e.getMessage().toString());
                map.put("err_code",e.getCode());

                String formatStr = FormartResponseUtils.getFormartErrorResponse("8",e);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }
        });
    }

    /**
     * 登录
     */
    private void verify() {
        SecVerify.verify(new VerifyCallback() {
            @Override
            public void onOtherLogin() {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("result", "onOtherLogin");
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("9",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }

            @Override
            public void onUserCanceled() {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("result", "onUserCanceled");
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("9",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }

            @Override
            public void onComplete(VerifyResult verifyResult) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("result", "onComplete");
                map.put("token",verifyResult.getToken());
                map.put("Operator",verifyResult.getOperator());
                map.put("OpToken",verifyResult.getOpToken());
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("9",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
                //关闭loading
                CommonProgressDialog.dismissProgressDialog();
            }

            @Override
            public void onFailure(VerifyException e) {
                String formatStr = FormartResponseUtils.getFormartErrorResponse("9", e);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }
        });
    }

    /**
     * 获取本机验证 token
     */
    private void getToken() {
        MobVerify.getToken(new com.mob.mobverify.OperationCallback<com.mob.mobverify.datatype.VerifyResult>() {
            @Override
            public void onComplete(com.mob.mobverify.datatype.VerifyResult verifyResult) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("opToken", verifyResult.getOpToken());
                map.put("token", verifyResult.getToken());
                map.put("operator", verifyResult.getOperator());
                map.put("phoneOperator", verifyResult.getOperator());
                map.put("md5", DeviceHelper.getInstance(MobSDK.getContext()).getSignMD5());
                map.put("appkey", MobSDK.getAppkey());
                String formatStr = FormartResponseUtils.getFormartCompleteResponse("13",map);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }

            @Override
            public void onFailure(com.mob.mobverify.exception.VerifyException e) {
                VerifyException exception = new VerifyException(e.getCode(),e.getMessage());
                String formatStr = FormartResponseUtils.getFormartErrorResponse("13", exception);
                UnityPlayer.UnitySendMessage(u3dGameObject, u3dCallback, formatStr);
            }
        });
    }

    /**
     * 设置竖屏
     * @param map
     */
    private void setPortraitUiSettings(HashMap map) {
        UiSettings uiSettings = UiSettingsTransfer.transferUiSettings(map);
        SecVerify.setUiSettings(uiSettings);
    }

    /**
     * 设置横屏
     * @param map
     */
    private void setLandUiSettings(HashMap map) {
        LandUiSettings uiSettings = LandUiSettingsTransfer.transferLandUiSettings(map);
        SecVerify.setLandUiSettings(uiSettings);
    }

    /**
     * 调试状态设置
     *
     * @param debugMode
     */
    private void setDebugMode(boolean debugMode) {
        SecVerify.setDebugMode(debugMode);
    }

    /**
     * 设置超时时间
     *
     * @param timeout
     */
    private void setTimeOut(int timeout) {
        SecVerify.setTimeOut(timeout);
    }

    //设置是否自动关闭一键登录页面
    private void autoFinishOauthPage(boolean autoFinish) {
        SecVerify.autoFinishOAuthPage(autoFinish);
    }

    //登录验证
    public void loginAuth(String uiconfig) {
        try {
            HashMap map = new Hashon().fromJson(uiconfig);
            for (Object o : map.entrySet()) {
                Log.i("TAG",o.toString());
            }
            setLandUiSettings(map);
            setPortraitUiSettings(map);

            boolean isManualDismiss = false;
            if (map.containsKey("manualDismiss")) {
                isManualDismiss = (boolean) map.get("manualDismiss");
            }
            SecVerify.autoFinishOAuthPage(isManualDismiss);

            verify();
        } catch (Throwable t) {
            System.out.println(t.toString());
        }
    }
}
