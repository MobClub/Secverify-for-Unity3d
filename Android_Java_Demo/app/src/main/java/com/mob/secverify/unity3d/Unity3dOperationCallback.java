package com.mob.secverify.unity3d;

import com.mob.secverify.OperationCallback;
import com.mob.secverify.exception.VerifyException;
import com.mob.tools.utils.Hashon;
import com.unity3d.player.UnityPlayer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 预取号回调
 */
public class Unity3dOperationCallback extends OperationCallback<Void> {

	private String u3dCallback;
	private String u3dGameObject;
	private Hashon hashon = new Hashon();

	public Unity3dOperationCallback(String u3dGameObject, String u3dCallback) {
		this.u3dGameObject = u3dGameObject;
		this.u3dCallback = u3dCallback;
	}

	@Override
	public void onComplete(Void o) {
		HashMap<String, Object> map = new HashMap();
		map.put("type", Integer.valueOf(1));
		map.put("state", Integer.valueOf(1));
		String resp = hashon.fromHashMap(map);
		UnityPlayer.UnitySendMessage(this.u3dGameObject, this.u3dCallback, resp);
	}

	@Override
	public void onFailure(VerifyException exception) {
		Throwable throwable = exception.getCause();
		if (throwable != null) {
			throwable.printStackTrace();
		}
		String resp = javaActionResToCS(exception, exception.getCause());
		UnityPlayer.UnitySendMessage(this.u3dGameObject, this.u3dCallback, resp);
	}


	private String javaActionResToCS(VerifyException exception, Throwable t) {
		HashMap<String, Object> map = new HashMap();
		map.put("type", Integer.valueOf(1));
		map.put("state", Integer.valueOf(2));
		map.put("code", Integer.valueOf(exception.getCode()));
		map.put("message", exception.getMessage());
		map.put("res", throwableToMap(t));
		return hashon.fromHashMap(map);
	}

	private HashMap<String, Object> throwableToMap(Throwable t) {
		HashMap<String, Object> map = new HashMap();
		map.put("msg", t.getMessage());
		ArrayList<HashMap<String, Object>> traces = new ArrayList();
		StackTraceElement[] arrayOfStackTraceElement;
		int j = (arrayOfStackTraceElement = t.getStackTrace()).length;
		for (int i = 0; i < j; i++) {
			StackTraceElement trace = arrayOfStackTraceElement[i];
			HashMap<String, Object> element = new HashMap();
			element.put("cls", trace.getClassName());
			element.put("method", trace.getMethodName());
			element.put("file", trace.getFileName());
			element.put("line", Integer.valueOf(trace.getLineNumber()));
			traces.add(element);
		}
		map.put("stack", traces);
		Throwable cause = t.getCause();
		if (cause != null) {
			map.put("cause", throwableToMap(cause));
		}
		return map;
	}
}
