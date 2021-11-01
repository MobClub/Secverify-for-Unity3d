package com.secverify.unity3d;

import com.mob.secverify.common.exception.VerifyException;
import com.mob.tools.utils.Hashon;

import java.util.HashMap;
import java.util.Map;

public class FormartResponseUtils {

    /**
     *
     * @param actionType 业务类型
     * @param e VerifyException
     * @return
     */
    public static String getFormartErrorResponse(String actionType, VerifyException e){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", 1);
        map.put("actionType", "8");
        HashMap<String, Object> resPonseMap = new HashMap<String, Object>();
        HashMap<String, Object> errMap = new HashMap<String, Object>();
        resPonseMap.put("err", errMap);
        errMap.put("err_desc",e.getMessage().toString());
        errMap.put("err_code",e.getCode());
        map.put("response", resPonseMap);
        Hashon hashon = new Hashon();
        String forMartStr = hashon.fromHashMap(map);
        return forMartStr;
    }

    /**
     *
     * @param actionType 业务类型
//     * @param msg 自定义key
//     * @param msgValue 自定义值
     * @return
     */
    public static String getFormartCompleteResponse(String actionType, Map value){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("status", 0);
        map.put("actionType", actionType);
        HashMap<String, Object> map1 = new HashMap<String, Object>();
//        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map1.put("ret", value);
//        map2.put(key, value);
        map.put("response", map1);

        Hashon hashon = new Hashon();
        String forMartStr = hashon.fromHashMap(map);
        return forMartStr;
    }
}
