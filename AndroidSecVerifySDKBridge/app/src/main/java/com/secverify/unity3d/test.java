package com.secverify.unity3d;

import android.content.Context;

import com.mob.MobSDK;
import com.unity3d.player.UnityPlayer;

public class test {
    // 通过Mob console申请获得
    private static final String MOB_APPKEY = "moba6b6c6d6";
    private static final String MOB_APPSECRET = "b89d2427a3bc7ad1aea1e1e8c1d36bf3";
    private static Context context;
    public void Init(){
        if(context==null){
            context = UnityPlayer.currentActivity.getApplicationContext();
        }
        // 初始化SecVerify
        MobSDK.init(context, MOB_APPKEY, MOB_APPSECRET);

    }

}
