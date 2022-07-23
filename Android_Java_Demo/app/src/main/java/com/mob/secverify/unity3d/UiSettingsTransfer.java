package com.mob.secverify.unity3d;

import android.content.Context;
import android.graphics.Color;

import com.mob.secverify.datatype.LandUiSettings;
import com.mob.secverify.datatype.UiSettings;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;

import java.util.HashMap;

public class UiSettingsTransfer{

	private static Hashon hashon = new Hashon();
	private static Object map;

	public static UiSettings transfer(Context context, String settings){
		map = hashon.fromJson(settings);
		UiSettings.Builder builder = new UiSettings.Builder();

		if (((HashMap)map).containsKey("navColor")) {
			String navColor = (String)((HashMap)map).get("navColor");
			builder = builder.setNavColorId(Color.parseColor(navColor));
		}

		if (((HashMap)map).containsKey("navText")) {
			builder.setNavTextId((String)((HashMap)map).get("navText"));
		}

		if (((HashMap)map).containsKey("navTextColor")) {
			String navTextColor = (String)((HashMap)map).get("navTextColor");
			builder.setNavTextColorId(Color.parseColor(navTextColor));
		}

		if (((HashMap)map).containsKey("navCloseImg")) {
			builder.setNavCloseImgId(ResHelper.getBitmapRes(context, (String) ((HashMap) map).get("navCloseImg")));
		}

		if (((HashMap)map).containsKey("navHidden")) {
			builder.setNavHidden((Boolean)((HashMap)map).get("navHidden"));
		}


		if (((HashMap)map).containsKey("navTransparent")) {
			builder.setNavTransparent((Boolean)((HashMap)map).get("navTransparent"));
		}



		if (((HashMap)map).containsKey("navCloseImgHidden")) {
			builder.setNavCloseImgHidden((Boolean)((HashMap)map).get("navCloseImgHidden"));
		}

		if (((HashMap)map).containsKey("navTextBold")) {
			builder.setNavTextBold((Boolean)((HashMap)map).get("navTextBold"));
		}

		if (((HashMap)map).containsKey("navTextSize")) {
			builder.setNavTextSize((Integer)((HashMap)map).get("navTextSize"));
		}



		if (((HashMap)map).containsKey("navCloseImgWidth")) {
			builder.setNavCloseImgWidth((Integer)((HashMap)map).get("navCloseImgWidth"));
		}



		if (((HashMap)map).containsKey("navCloseImgHeight")) {
			builder.setNavCloseImgHeight((Integer)((HashMap)map).get("navCloseImgHeight"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetX")) {
			builder.setNavCloseImgOffsetX((Integer)((HashMap)map).get("navCloseImgOffsetX"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetRightX")) {
			builder.setNavCloseImgOffsetRightX((Integer)((HashMap)map).get("navCloseImgOffsetRightX"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetY")) {
			builder.setNavCloseImgOffsetY((Integer)((HashMap)map).get("navCloseImgOffsetY"));
		}



//		if (((HashMap)map).containsKey("navCloseImgPath")) {
//			FileInputStream fis = null;
//			String path = (String)((HashMap)map).get("navCloseImgPath");
//			try {
//				fis = new FileInputStream(path);
//				BitmapFactory.Options options = new BitmapFactory.Options();
//				options.inSampleSize = 2;
//				Bitmap bitmap  = BitmapFactory.decodeStream(fis,null,options);
//				Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
//				builder.setNavCloseImgId(drawable);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Throwable throwable){
//				throwable.printStackTrace();
//			}
//
//
//		}

		if (((HashMap)map).containsKey("logoImg")) {
			builder.setLogoImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("logoImg")));

		}

		if (((HashMap)map).containsKey("logoWidth")) {
			builder.setLogoWidth((Integer)((HashMap)map).get("logoWidth"));
		}



		if (((HashMap)map).containsKey("logoHeight")) {
			builder.setLogoHeight((Integer)((HashMap)map).get("logoHeight"));
		}



		if (((HashMap)map).containsKey("logoOffsetX")) {
			builder.setLogoOffsetX((Integer)((HashMap)map).get("logoOffsetX"));
		}



		if (((HashMap)map).containsKey("logoOffsetY")) {
			builder.setLogoOffsetY((Integer)((HashMap)map).get("logoOffsetY"));
		}

		if (((HashMap)map).containsKey("logoHidden")) {
			builder.setLogoHidden((Boolean)((HashMap)map).get("logoHidden"));
		}

		if (((HashMap)map).containsKey("logoOffsetBottomY")) {
			builder.setLogoOffsetBottomY((Integer)((HashMap)map).get("logoOffsetBottomY"));
		}
		if (((HashMap)map).containsKey("logoOffsetRightX")) {
			builder.setLogoOffsetRightX((Integer)((HashMap)map).get("logoOffsetRightX"));
		}

		if (((HashMap)map).containsKey("logoAlignParentRight")) {
			builder.setLogoAlignParentRight((Boolean)((HashMap)map).get("logoAlignParentRight"));
		}

//		if (((HashMap)map).containsKey("logoImgPath")) {
//			FileInputStream fis = null;
//			String path = (String)((HashMap)map).get("logoImgPath");
//			try {
//				fis = new FileInputStream(path);
//				BitmapFactory.Options options = new BitmapFactory.Options();
//				options.inSampleSize = 2;
//				Bitmap bitmap  = BitmapFactory.decodeStream(fis,null,options);
//				Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
//				builder.setLogoImgId(drawable);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Throwable throwable){
//				throwable.printStackTrace();
//			}
//
//		}


		if (((HashMap)map).containsKey("numberColor")) {
			String numberColor = (String)((HashMap)map).get("numberColor");
			builder.setNumberColorId(Color.parseColor(numberColor));
		}

		if (((HashMap)map).containsKey("numberSize")) {
			builder.setNumberSizeId((Integer)((HashMap)map).get("numberSize"));
		}

		if (((HashMap)map).containsKey("numberOffsetX")) {
			builder.setNumberOffsetX((Integer)((HashMap)map).get("numberOffsetX"));
		}



		if (((HashMap)map).containsKey("numberOffsetY")) {
			builder.setNumberOffsetY((Integer)((HashMap)map).get("numberOffsetY"));
		}


		if (((HashMap)map).containsKey("numberHidden")) {
			builder.setNumberHidden((Boolean)((HashMap)map).get("numberHidden"));
		}

		if (((HashMap)map).containsKey("numberOffsetBottomY")) {
			builder.setNumberOffsetBottomY((Integer)((HashMap)map).get("numberOffsetBottomY"));
		}


		if (((HashMap)map).containsKey("numberOffsetRightX")) {
			builder.setNumberOffsetRightX((Integer)((HashMap)map).get("numberOffsetRightX"));
		}



		if (((HashMap)map).containsKey("numberAlignParentRight")) {
			builder.setNumberAlignParentRight((Boolean)((HashMap)map).get("numberAlignParentRight"));
		}
		if (((HashMap)map).containsKey("numberBold")) {
			builder.setNumberBold((Boolean)((HashMap)map).get("numberBold"));
		}

		//切换登录



		if (((HashMap)map).containsKey("switchAccColor")) {
			String switchAccColor = (String)((HashMap)map).get("switchAccColor");
			builder.setSwitchAccColorId(Color.parseColor(switchAccColor));
		}


		if (((HashMap)map).containsKey("switchAccTextSize")) {
			builder.setSwitchAccTextSize((Integer)((HashMap)map).get("switchAccTextSize"));
		}



		if (((HashMap)map).containsKey("switchAccHidden")) {
			builder.setSwitchAccHidden((Boolean)((HashMap)map).get("switchAccHidden"));
		}

		if (((HashMap)map).containsKey("switchAccOffsetX")) {
			builder.setSwitchAccOffsetX((Integer)((HashMap)map).get("switchAccOffsetX"));
		}



		if (((HashMap)map).containsKey("switchAccOffsetY")) {
			builder.setSwitchAccOffsetY((Integer)((HashMap)map).get("switchAccOffsetY"));
		}

		if (((HashMap)map).containsKey("getSwitchAccText")) {
			builder.setSwitchAccText((String)((HashMap)map).get("getSwitchAccText"));
		}


		if (((HashMap)map).containsKey("switchAccOffsetBottomY")) {
			builder.setSwitchAccOffsetBottomY((Integer)((HashMap)map).get("switchAccOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("switchAccOffsetRightX")) {
			builder.setSwitchAccOffsetRightX((Integer)((HashMap)map).get("switchAccOffsetRightX"));
		}

		if (((HashMap)map).containsKey("switchAccAlignParentRight")) {
			builder.setSwitchAccAlignParentRight((Boolean)((HashMap)map).get("switchAccAlignParentRight"));
		}

		if (((HashMap)map).containsKey("switchAccTextBold")) {
			builder.setSwitchAccTextBold((Boolean)((HashMap)map).get("switchAccTextBold"));
		}

		// 复选框
		if (((HashMap)map).containsKey("checkboxImg")) {
			builder.setCheckboxImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("checkboxImg")));
		}

		if (((HashMap)map).containsKey("checkboxDefaultState")) {
			builder.setCheckboxDefaultState((Boolean)((HashMap)map).get("checkboxDefaultState"));
		}

		if (((HashMap)map).containsKey("checkboxHidden")) {
			builder.setCheckboxHidden((Boolean)((HashMap)map).get("checkboxHidden"));
		}

		if (((HashMap)map).containsKey("checkboxScale")) {
			double scale = (Double) ((HashMap)map).get("checkboxScale");
			builder.setCheckboxScaleX((float) scale);
			builder.setCheckboxScaleY((float) scale);
		}

		if (((HashMap)map).containsKey("checkboxOffsetX")) {
			builder.setCheckboxOffsetX((Integer) ((HashMap)map).get("checkboxOffsetX"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetRightX")) {
			builder.setCheckboxOffsetRightX((Integer) ((HashMap)map).get("checkboxOffsetRightX"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetY")) {
			builder.setCheckboxOffsetY((Integer) ((HashMap)map).get("checkboxOffsetY"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetBottomY")) {
			builder.setCheckboxOffsetBottomY((Integer) ((HashMap)map).get("checkboxOffsetBottomY"));
		}

		//隐私协议

		if (((HashMap)map).containsKey("agreementColor")) {
			String agreementColor = (String)((HashMap)map).get("agreementColor");
			builder.setAgreementColorId(Color.parseColor(agreementColor));
		}


		if (((HashMap)map).containsKey("cusAgreementName1")) {
			builder.setCusAgreementNameId1((String)((HashMap)map).get("cusAgreementName1"));
		}



		if (((HashMap)map).containsKey("cusAgreementUrl1")) {
			builder.setCusAgreementUrl1((String)((HashMap)map).get("cusAgreementUrl1"));
		}



		if (((HashMap)map).containsKey("cusAgreementName2")) {
			builder.setCusAgreementNameId2((String)((HashMap)map).get("cusAgreementName2"));
		}

		if (((HashMap)map).containsKey("cusAgreementUrl2")) {
			builder.setCusAgreementUrl2((String)((HashMap)map).get("cusAgreementUrl2"));
		}

		if (((HashMap)map).containsKey("cusAgreementName3")) {
			builder.setCusAgreementNameId3((String)((HashMap)map).get("cusAgreementName3"));
		}



		if (((HashMap)map).containsKey("cusAgreementUrl3")) {
			builder.setCusAgreementUrl3((String)((HashMap)map).get("cusAgreementUrl3"));
		}

		if (((HashMap)map).containsKey("agreementOffsetX")) {
			builder.setAgreementOffsetX((Integer)((HashMap)map).get("agreementOffsetX"));
		}



		if (((HashMap)map).containsKey("agreementOffsetRightX")) {
			builder.setAgreementOffsetRightX((Integer)((HashMap)map).get("agreementOffsetRightX"));
		}



		if (((HashMap)map).containsKey("agreementOffsetY")) {
			builder.setAgreementOffsetY((Integer)((HashMap)map).get("agreementOffsetY"));
		}



		if (((HashMap)map).containsKey("agreementOffsetBottomY")) {
			builder.setAgreementOffsetBottomY((Integer)((HashMap)map).get("agreementOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("cusAgreementColor1")) {
			String cusAgreementColor1 = (String)((HashMap)map).get("cusAgreementColor1");
			builder.setCusAgreementColor1(Color.parseColor(cusAgreementColor1));
		}

//		if (((HashMap)map).containsKey("cusAgreementColor1")) {
//			builder.setCusAgreementColor1((Integer)((HashMap)map).get("cusAgreementColor1"));
//		}


		if (((HashMap)map).containsKey("cusAgreementColor2")) {
			String cusAgreementColor2 = (String)((HashMap)map).get("cusAgreementColor2");
			builder.setCusAgreementColor2(Color.parseColor(cusAgreementColor2));
		}

		if (((HashMap)map).containsKey("cusAgreementColor3")) {
			String cusAgreementColor3 = (String)((HashMap)map).get("cusAgreementColor3");
			builder.setCusAgreementColor3(Color.parseColor(cusAgreementColor3));
		}
//		if (((HashMap)map).containsKey("cusAgreementColor2")) {
//			builder.setCusAgreementColor2((Integer)((HashMap)map).get("cusAgreementColor2"));
//		}

		if (((HashMap)map).containsKey("agreementBaseTextColor")) {
			String agreementBaseTextColor = (String)((HashMap)map).get("agreementBaseTextColor");
			builder.setAgreementBaseTextColorId(Color.parseColor(agreementBaseTextColor));
		}
//		if (((HashMap)map).containsKey("agreementBaseTextColorId")) {
//			builder.setAgreementBaseTextColorId((Integer)((HashMap)map).get("agreementBaseTextColorId"));
//		}



		if (((HashMap)map).containsKey("agreementTextSize")) {
			builder.setAgreementTextSize((Integer)((HashMap)map).get("agreementTextSize"));
		}

		if (((HashMap)map).containsKey("agreementHidden")) {
			builder.setAgreementHidden((Boolean)((HashMap)map).get("agreementHidden"));
		}

		if (((HashMap)map).containsKey("agreementCmccText")) {
			builder.setAgreementCmccText((String) ((HashMap)map).get("agreementCmccText"));
		}



		if (((HashMap)map).containsKey("agreementCuccText")) {
			builder.setAgreementCuccText((String) ((HashMap)map).get("agreementCuccText"));
		}



		if (((HashMap)map).containsKey("agreementCtccText")) {
			builder.setAgreementCtccText((String) ((HashMap)map).get("agreementCtccText"));
		}



		if (((HashMap)map).containsKey("agreementTextStart")) {
			builder.setAgreementTextStart((String) ((HashMap)map).get("agreementTextStart"));
		}



		if (((HashMap)map).containsKey("agreementTextAnd1")) {
			builder.setAgreementTextAnd1((String) ((HashMap)map).get("agreementTextAnd1"));
		}



		if (((HashMap)map).containsKey("agreementTextAnd2")) {
			builder.setAgreementTextAnd2((String) ((HashMap)map).get("agreementTextAnd2"));
		}

		if (((HashMap)map).containsKey("agreementTextAnd3")) {
			builder.setAgreementTextAnd3((String) ((HashMap)map).get("agreementTextAnd3"));
		}



		if (((HashMap)map).containsKey("agreementTextEnd")) {
			builder.setAgreementTextEnd((String) ((HashMap)map).get("agreementTextEnd"));
		}

		if (((HashMap)map).containsKey("agreementAlignParentRight")) {
			builder.setAgreementAlignParentRight((Boolean)((HashMap)map).get("agreementAlignParentRight"));
		}

		if (((HashMap)map).containsKey("agreementTextBold")) {
			builder.setAgreementTextBold((Boolean)((HashMap)map).get("agreementTextBold"));
		}

		//登录按钮
		if (((HashMap)map).containsKey("loginBtnImg")) {
			builder.setLoginBtnImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("loginBtnImg")));
		}

		if (((HashMap)map).containsKey("loginBtnText")) {
			builder.setLoginBtnTextId((String)((HashMap)map).get("loginBtnText"));
		}

		if (((HashMap)map).containsKey("loginBtnTextColor")) {
			String loginBtnTextColor = (String)((HashMap)map).get("loginBtnTextColor");
			builder.setLoginBtnTextColorId(Color.parseColor(loginBtnTextColor));
		}

		if (((HashMap)map).containsKey("loginBtnTextSize")) {
			builder.setLoginBtnTextSize((Integer)((HashMap)map).get("loginBtnTextSize"));
		}



		if (((HashMap)map).containsKey("loginBtnWidth")) {
			builder.setLoginBtnWidth((Integer)((HashMap)map).get("loginBtnWidth"));
		}



		if (((HashMap)map).containsKey("loginBtnHeight")) {
			builder.setLoginBtnHeight((Integer)((HashMap)map).get("loginBtnHeight"));
		}



		if (((HashMap)map).containsKey("loginBtnOffsetX")) {
			builder.setLoginBtnOffsetX((Integer)((HashMap)map).get("loginBtnOffsetX"));
		}



		if (((HashMap)map).containsKey("loginBtnOffsetY")) {
			builder.setLoginBtnOffsetY((Integer)((HashMap)map).get("loginBtnOffsetY"));
		}

		if (((HashMap)map).containsKey("loginBtnHidden")) {
			builder.setLoginBtnHidden((Boolean)((HashMap)map).get("loginBtnHidden"));
		}

		if (((HashMap)map).containsKey("loginBtnOffsetBottomY")) {
			builder.setLoginBtnOffsetBottomY((Integer)((HashMap)map).get("loginBtnOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("loginBtnOffsetRightX")) {
			builder.setLoginBtnOffsetRightX((Integer)((HashMap)map).get("loginBtnOffsetRightX"));
		}



		if (((HashMap)map).containsKey("loginBtnAlignParentRight")) {
			builder.setLoginBtnAlignParentRight((Boolean)((HashMap)map).get("loginBtnAlignParentRight"));
		}

		if (((HashMap)map).containsKey("loginBtnTextBold")) {
			builder.setLoginBtnTextBold((Boolean)((HashMap)map).get("loginBtnTextBold"));
		}


		//Slogan

		if (((HashMap)map).containsKey("sloganOffsetX")) {
			builder.setSloganOffsetX((Integer)((HashMap)map).get("sloganOffsetX"));
		}



		if (((HashMap)map).containsKey("sloganOffsetY")) {
			builder.setSloganOffsetY((Integer)((HashMap)map).get("sloganOffsetY"));
		}



		if (((HashMap)map).containsKey("sloganOffsetBottomY")) {
			builder.setSloganOffsetBottomY((Integer)((HashMap)map).get("sloganOffsetBottomY"));
		}



		if (((HashMap)map).containsKey("sloganTextSize")) {
			builder.setSloganTextSize((Integer)((HashMap)map).get("sloganTextSize"));
		}

		if (((HashMap)map).containsKey("sloganTextColor")) {
			String sloganTextColor = (String)((HashMap)map).get("sloganTextColor");
			builder.setSloganTextColor(Color.parseColor(sloganTextColor));
		}

//		if (((HashMap)map).containsKey("sloganTextColor")) {
//			builder.setSloganTextColor((Integer)((HashMap)map).get("sloganTextColor"));
//		}
		if (((HashMap)map).containsKey("sloganOffsetRightX")) {
			builder.setSloganOffsetRightX((Integer)((HashMap)map).get("sloganOffsetRightX"));
		}



		if (((HashMap)map).containsKey("sloganAlignParentRight")) {
			builder.setSloganAlignParentRight((Boolean)((HashMap)map).get("sloganAlignParentRight"));
		}
		if (((HashMap)map).containsKey("sloganTextBold")) {
			builder.setSloganTextBold((Boolean)((HashMap)map).get("sloganTextBold"));
		}

		if (((HashMap)map).containsKey("sloganHidden")) {
			builder.setSloganHidden((Boolean)((HashMap)map).get("sloganHidden"));
		}


		// 授权页面
		if (((HashMap)map).containsKey("backgroundImg")) {
			builder.setBackgroundImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("backgroundImg")));
		}


		if (((HashMap)map).containsKey("backgroundClickClose")) {
			builder.setBackgroundClickClose((Boolean)((HashMap)map).get("backgroundClickClose"));
		}
		if (((HashMap)map).containsKey("fullScreen")) {
			builder.setFullScreen((Boolean)((HashMap)map).get("fullScreen"));
		}


		if (((HashMap)map).containsKey("immersiveTheme")) {
			builder.setImmersiveTheme((Boolean)((HashMap)map).get("immersiveTheme"));
		}



		if (((HashMap)map).containsKey("immersiveStatusTextColorBlack")) {
			builder.setImmersiveStatusTextColorBlack((Boolean)((HashMap)map).get("immersiveStatusTextColorBlack"));
		}




		//Dialog


		if (((HashMap)map).containsKey("dialogTheme")) {
			builder.setDialogTheme((Boolean)((HashMap)map).get("dialogTheme"));
		}



		if (((HashMap)map).containsKey("dialogAlignBottom")) {
			builder.setDialogAlignBottom((Boolean)((HashMap)map).get("dialogAlignBottom"));
		}



		if (((HashMap)map).containsKey("dialogOffsetX")) {
			builder.setDialogOffsetX((Integer)((HashMap)map).get("dialogOffsetX"));
		}



		if (((HashMap)map).containsKey("dialogOffsetY")) {
			builder.setDialogOffsetY((Integer)((HashMap)map).get("dialogOffsetY"));
		}



		if (((HashMap)map).containsKey("dialogWidth")) {
			builder.setDialogWidth((Integer)((HashMap)map).get("dialogWidth"));
		}



		if (((HashMap)map).containsKey("dialogHeight")) {
			builder.setDialogHeight((Integer)((HashMap)map).get("dialogHeight"));
		}

		if (((HashMap)map).containsKey("dialogBackground")) {
			builder.setDialogMaskBackground(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("dialogBackground")));
		}


		if (((HashMap)map).containsKey("dialogBackgroundClickClose")) {
			builder.setDialogMaskBackgroundClickClose((Boolean)((HashMap)map).get("dialogBackgroundClickClose"));
		}

		return builder.build();
	}

	public static LandUiSettings transferLandUiSetting(Context context, String landSettings){
		map = hashon.fromJson(landSettings);
		LandUiSettings.Builder builder= new LandUiSettings.Builder();
		if (((HashMap)map).containsKey("navColor")) {
			String navColor = (String)((HashMap)map).get("navColor");
			builder = builder.setNavColorId(Color.parseColor(navColor));
		}

		if (((HashMap)map).containsKey("navText")) {
			builder.setNavTextId((String)((HashMap)map).get("navText"));
		}

		if (((HashMap)map).containsKey("navTextColor")) {
			String navTextColor = (String)((HashMap)map).get("navTextColor");
			builder.setNavTextColorId(Color.parseColor(navTextColor));
		}

		if (((HashMap)map).containsKey("navCloseImg")) {
			builder.setNavCloseImgId(ResHelper.getBitmapRes(context, (String) ((HashMap) map).get("navCloseImg")));
		}

		if (((HashMap)map).containsKey("navHidden")) {
			builder.setNavHidden((Boolean)((HashMap)map).get("navHidden"));
		}


		if (((HashMap)map).containsKey("navTransparent")) {
			builder.setNavTransparent((Boolean)((HashMap)map).get("navTransparent"));
		}



		if (((HashMap)map).containsKey("navCloseImgHidden")) {
			builder.setNavCloseImgHidden((Boolean)((HashMap)map).get("navCloseImgHidden"));
		}

		if (((HashMap)map).containsKey("navTextBold")) {
			builder.setNavTextBold((Boolean)((HashMap)map).get("navTextBold"));
		}

		if (((HashMap)map).containsKey("navTextSize")) {
			builder.setNavTextSize((Integer)((HashMap)map).get("navTextSize"));
		}



		if (((HashMap)map).containsKey("navCloseImgWidth")) {
			builder.setNavCloseImgWidth((Integer)((HashMap)map).get("navCloseImgWidth"));
		}



		if (((HashMap)map).containsKey("navCloseImgHeight")) {
			builder.setNavCloseImgHeight((Integer)((HashMap)map).get("navCloseImgHeight"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetX")) {
			builder.setNavCloseImgOffsetX((Integer)((HashMap)map).get("navCloseImgOffsetX"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetRightX")) {
			builder.setNavCloseImgOffsetRightX((Integer)((HashMap)map).get("navCloseImgOffsetRightX"));
		}



		if (((HashMap)map).containsKey("navCloseImgOffsetY")) {
			builder.setNavCloseImgOffsetY((Integer)((HashMap)map).get("navCloseImgOffsetY"));
		}



//		if (((HashMap)map).containsKey("navCloseImgPath")) {
//			FileInputStream fis = null;
//			String path = (String)((HashMap)map).get("navCloseImgPath");
//			try {
//				fis = new FileInputStream(path);
//				BitmapFactory.Options options = new BitmapFactory.Options();
//				options.inSampleSize = 2;
//				Bitmap bitmap  = BitmapFactory.decodeStream(fis,null,options);
//				Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
//				builder.setNavCloseImgId(drawable);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Throwable throwable){
//				throwable.printStackTrace();
//			}
//
//
//		}

		if (((HashMap)map).containsKey("logoImg")) {
			builder.setLogoImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("logoImg")));

		}

		if (((HashMap)map).containsKey("logoWidth")) {
			builder.setLogoWidth((Integer)((HashMap)map).get("logoWidth"));
		}



		if (((HashMap)map).containsKey("logoHeight")) {
			builder.setLogoHeight((Integer)((HashMap)map).get("logoHeight"));
		}



		if (((HashMap)map).containsKey("logoOffsetX")) {
			builder.setLogoOffsetX((Integer)((HashMap)map).get("logoOffsetX"));
		}



		if (((HashMap)map).containsKey("logoOffsetY")) {
			builder.setLogoOffsetY((Integer)((HashMap)map).get("logoOffsetY"));
		}

		if (((HashMap)map).containsKey("logoHidden")) {
			builder.setLogoHidden((Boolean)((HashMap)map).get("logoHidden"));
		}

		if (((HashMap)map).containsKey("logoOffsetBottomY")) {
			builder.setLogoOffsetBottomY((Integer)((HashMap)map).get("logoOffsetBottomY"));
		}
		if (((HashMap)map).containsKey("logoOffsetRightX")) {
			builder.setLogoOffsetRightX((Integer)((HashMap)map).get("logoOffsetRightX"));
		}

		if (((HashMap)map).containsKey("logoAlignParentRight")) {
			builder.setLogoAlignParentRight((Boolean)((HashMap)map).get("logoAlignParentRight"));
		}

//		if (((HashMap)map).containsKey("logoImgPath")) {
//			FileInputStream fis = null;
//			String path = (String)((HashMap)map).get("logoImgPath");
//			try {
//				fis = new FileInputStream(path);
//				BitmapFactory.Options options = new BitmapFactory.Options();
//				options.inSampleSize = 2;
//				Bitmap bitmap  = BitmapFactory.decodeStream(fis,null,options);
//				Drawable drawable = new BitmapDrawable(context.getResources(),bitmap);
//				builder.setLogoImgId(drawable);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (Throwable throwable){
//				throwable.printStackTrace();
//			}
//
//		}


		if (((HashMap)map).containsKey("numberColor")) {
			String numberColor = (String)((HashMap)map).get("numberColor");
			builder.setNumberColorId(Color.parseColor(numberColor));
		}

		if (((HashMap)map).containsKey("numberSize")) {
			builder.setNumberSizeId((Integer)((HashMap)map).get("numberSize"));
		}

		if (((HashMap)map).containsKey("numberOffsetX")) {
			builder.setNumberOffsetX((Integer)((HashMap)map).get("numberOffsetX"));
		}



		if (((HashMap)map).containsKey("numberOffsetY")) {
			builder.setNumberOffsetY((Integer)((HashMap)map).get("numberOffsetY"));
		}


		if (((HashMap)map).containsKey("numberHidden")) {
			builder.setNumberHidden((Boolean)((HashMap)map).get("numberHidden"));
		}

		if (((HashMap)map).containsKey("numberOffsetBottomY")) {
			builder.setNumberOffsetBottomY((Integer)((HashMap)map).get("numberOffsetBottomY"));
		}


		if (((HashMap)map).containsKey("numberOffsetRightX")) {
			builder.setNumberOffsetRightX((Integer)((HashMap)map).get("numberOffsetRightX"));
		}



		if (((HashMap)map).containsKey("numberAlignParentRight")) {
			builder.setNumberAlignParentRight((Boolean)((HashMap)map).get("numberAlignParentRight"));
		}
		if (((HashMap)map).containsKey("numberBold")) {
			builder.setNumberBold((Boolean)((HashMap)map).get("numberBold"));
		}

		//切换登录



		if (((HashMap)map).containsKey("switchAccColor")) {
			String switchAccColor = (String)((HashMap)map).get("switchAccColor");
			builder.setSwitchAccColorId(Color.parseColor(switchAccColor));
		}


		if (((HashMap)map).containsKey("switchAccTextSize")) {
			builder.setSwitchAccTextSize((Integer)((HashMap)map).get("switchAccTextSize"));
		}



		if (((HashMap)map).containsKey("switchAccHidden")) {
			builder.setSwitchAccHidden((Boolean)((HashMap)map).get("switchAccHidden"));
		}

		if (((HashMap)map).containsKey("switchAccOffsetX")) {
			builder.setSwitchAccOffsetX((Integer)((HashMap)map).get("switchAccOffsetX"));
		}



		if (((HashMap)map).containsKey("switchAccOffsetY")) {
			builder.setSwitchAccOffsetY((Integer)((HashMap)map).get("switchAccOffsetY"));
		}

		if (((HashMap)map).containsKey("getSwitchAccText")) {
			builder.setSwitchAccText((String)((HashMap)map).get("getSwitchAccText"));
		}


		if (((HashMap)map).containsKey("switchAccOffsetBottomY")) {
			builder.setSwitchAccOffsetBottomY((Integer)((HashMap)map).get("switchAccOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("switchAccOffsetRightX")) {
			builder.setSwitchAccOffsetRightX((Integer)((HashMap)map).get("switchAccOffsetRightX"));
		}

		if (((HashMap)map).containsKey("switchAccAlignParentRight")) {
			builder.setSwitchAccAlignParentRight((Boolean)((HashMap)map).get("switchAccAlignParentRight"));
		}

		if (((HashMap)map).containsKey("switchAccTextBold")) {
			builder.setSwitchAccTextBold((Boolean)((HashMap)map).get("switchAccTextBold"));
		}

		// 复选框
		if (((HashMap)map).containsKey("checkboxImg")) {
			builder.setCheckboxImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("checkboxImg")));
		}

		if (((HashMap)map).containsKey("checkboxDefaultState")) {
			builder.setCheckboxDefaultState((Boolean)((HashMap)map).get("checkboxDefaultState"));
		}

		if (((HashMap)map).containsKey("checkboxHidden")) {
			builder.setCheckboxHidden((Boolean)((HashMap)map).get("checkboxHidden"));
		}

		if (((HashMap)map).containsKey("checkboxScale")) {
			double scale = (Double) ((HashMap)map).get("checkboxScale");
			builder.setCheckboxScaleX((float) scale);
			builder.setCheckboxScaleY((float) scale);
		}

		if (((HashMap)map).containsKey("checkboxOffsetX")) {
			builder.setCheckboxOffsetX((Integer) ((HashMap)map).get("checkboxOffsetX"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetRightX")) {
			builder.setCheckboxOffsetRightX((Integer) ((HashMap)map).get("checkboxOffsetRightX"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetY")) {
			builder.setCheckboxOffsetY((Integer) ((HashMap)map).get("checkboxOffsetY"));
		}

		if (((HashMap)map).containsKey("checkboxOffsetBottomY")) {
			builder.setCheckboxOffsetBottomY((Integer) ((HashMap)map).get("checkboxOffsetBottomY"));
		}

		//隐私协议

		if (((HashMap)map).containsKey("agreementColor")) {
			String agreementColor = (String)((HashMap)map).get("agreementColor");
			builder.setAgreementColorId(Color.parseColor(agreementColor));
		}


		if (((HashMap)map).containsKey("cusAgreementName1")) {
			builder.setCusAgreementNameId1((String)((HashMap)map).get("cusAgreementName1"));
		}



		if (((HashMap)map).containsKey("cusAgreementUrl1")) {
			builder.setCusAgreementUrl1((String)((HashMap)map).get("cusAgreementUrl1"));
		}



		if (((HashMap)map).containsKey("cusAgreementName2")) {
			builder.setCusAgreementNameId2((String)((HashMap)map).get("cusAgreementName2"));
		}

		if (((HashMap)map).containsKey("cusAgreementUrl2")) {
			builder.setCusAgreementUrl2((String)((HashMap)map).get("cusAgreementUrl2"));
		}

		if (((HashMap)map).containsKey("cusAgreementName3")) {
			builder.setCusAgreementNameId3((String)((HashMap)map).get("cusAgreementName3"));
		}



		if (((HashMap)map).containsKey("cusAgreementUrl3")) {
			builder.setCusAgreementUrl3((String)((HashMap)map).get("cusAgreementUrl3"));
		}

		if (((HashMap)map).containsKey("agreementOffsetX")) {
			builder.setAgreementOffsetX((Integer)((HashMap)map).get("agreementOffsetX"));
		}



		if (((HashMap)map).containsKey("agreementOffsetRightX")) {
			builder.setAgreementOffsetRightX((Integer)((HashMap)map).get("agreementOffsetRightX"));
		}



		if (((HashMap)map).containsKey("agreementOffsetY")) {
			builder.setAgreementOffsetY((Integer)((HashMap)map).get("agreementOffsetY"));
		}



		if (((HashMap)map).containsKey("agreementOffsetBottomY")) {
			builder.setAgreementOffsetBottomY((Integer)((HashMap)map).get("agreementOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("cusAgreementColor1")) {
			String cusAgreementColor1 = (String)((HashMap)map).get("cusAgreementColor1");
			builder.setCusAgreementColor1(Color.parseColor(cusAgreementColor1));
		}

//		if (((HashMap)map).containsKey("cusAgreementColor1")) {
//			builder.setCusAgreementColor1((Integer)((HashMap)map).get("cusAgreementColor1"));
//		}


		if (((HashMap)map).containsKey("cusAgreementColor2")) {
			String cusAgreementColor2 = (String)((HashMap)map).get("cusAgreementColor2");
			builder.setCusAgreementColor2(Color.parseColor(cusAgreementColor2));
		}

		if (((HashMap)map).containsKey("cusAgreementColor3")) {
			String cusAgreementColor3 = (String)((HashMap)map).get("cusAgreementColor3");
			builder.setCusAgreementColor3(Color.parseColor(cusAgreementColor3));
		}
//		if (((HashMap)map).containsKey("cusAgreementColor2")) {
//			builder.setCusAgreementColor2((Integer)((HashMap)map).get("cusAgreementColor2"));
//		}

		if (((HashMap)map).containsKey("agreementBaseTextColor")) {
			String agreementBaseTextColor = (String)((HashMap)map).get("agreementBaseTextColor");
			builder.setAgreementBaseTextColorId(Color.parseColor(agreementBaseTextColor));
		}
//		if (((HashMap)map).containsKey("agreementBaseTextColorId")) {
//			builder.setAgreementBaseTextColorId((Integer)((HashMap)map).get("agreementBaseTextColorId"));
//		}



		if (((HashMap)map).containsKey("agreementTextSize")) {
			builder.setAgreementTextSize((Integer)((HashMap)map).get("agreementTextSize"));
		}

		if (((HashMap)map).containsKey("agreementHidden")) {
			builder.setAgreementHidden((Boolean)((HashMap)map).get("agreementHidden"));
		}

		if (((HashMap)map).containsKey("agreementCmccText")) {
			builder.setAgreementCmccText((String) ((HashMap)map).get("agreementCmccText"));
		}



		if (((HashMap)map).containsKey("agreementCuccText")) {
			builder.setAgreementCuccText((String) ((HashMap)map).get("agreementCuccText"));
		}



		if (((HashMap)map).containsKey("agreementCtccText")) {
			builder.setAgreementCtccText((String) ((HashMap)map).get("agreementCtccText"));
		}



		if (((HashMap)map).containsKey("agreementTextStart")) {
			builder.setAgreementTextStart((String) ((HashMap)map).get("agreementTextStart"));
		}



		if (((HashMap)map).containsKey("agreementTextAnd1")) {
			builder.setAgreementTextAnd1((String) ((HashMap)map).get("agreementTextAnd1"));
		}



		if (((HashMap)map).containsKey("agreementTextAnd2")) {
			builder.setAgreementTextAnd2((String) ((HashMap)map).get("agreementTextAnd2"));
		}

		if (((HashMap)map).containsKey("agreementTextAnd3")) {
			builder.setAgreementTextAnd3((String) ((HashMap)map).get("agreementTextAnd3"));
		}



		if (((HashMap)map).containsKey("agreementTextEnd")) {
			builder.setAgreementTextEnd((String) ((HashMap)map).get("agreementTextEnd"));
		}

		if (((HashMap)map).containsKey("agreementAlignParentRight")) {
			builder.setAgreementAlignParentRight((Boolean)((HashMap)map).get("agreementAlignParentRight"));
		}

		if (((HashMap)map).containsKey("agreementTextBold")) {
			builder.setAgreementTextBold((Boolean)((HashMap)map).get("agreementTextBold"));
		}

		//登录按钮
		if (((HashMap)map).containsKey("loginBtnImg")) {
			builder.setLoginBtnImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("loginBtnImg")));
		}

		if (((HashMap)map).containsKey("loginBtnText")) {
			builder.setLoginBtnTextId((String)((HashMap)map).get("loginBtnText"));
		}

		if (((HashMap)map).containsKey("loginBtnTextColor")) {
			String loginBtnTextColor = (String)((HashMap)map).get("loginBtnTextColor");
			builder.setLoginBtnTextColorId(Color.parseColor(loginBtnTextColor));
		}

		if (((HashMap)map).containsKey("loginBtnTextSize")) {
			builder.setLoginBtnTextSize((Integer)((HashMap)map).get("loginBtnTextSize"));
		}



		if (((HashMap)map).containsKey("loginBtnWidth")) {
			builder.setLoginBtnWidth((Integer)((HashMap)map).get("loginBtnWidth"));
		}



		if (((HashMap)map).containsKey("loginBtnHeight")) {
			builder.setLoginBtnHeight((Integer)((HashMap)map).get("loginBtnHeight"));
		}



		if (((HashMap)map).containsKey("loginBtnOffsetX")) {
			builder.setLoginBtnOffsetX((Integer)((HashMap)map).get("loginBtnOffsetX"));
		}



		if (((HashMap)map).containsKey("loginBtnOffsetY")) {
			builder.setLoginBtnOffsetY((Integer)((HashMap)map).get("loginBtnOffsetY"));
		}

		if (((HashMap)map).containsKey("loginBtnHidden")) {
			builder.setLoginBtnHidden((Boolean)((HashMap)map).get("loginBtnHidden"));
		}

		if (((HashMap)map).containsKey("loginBtnOffsetBottomY")) {
			builder.setLoginBtnOffsetBottomY((Integer)((HashMap)map).get("loginBtnOffsetBottomY"));
		}

		if (((HashMap)map).containsKey("loginBtnOffsetRightX")) {
			builder.setLoginBtnOffsetRightX((Integer)((HashMap)map).get("loginBtnOffsetRightX"));
		}



		if (((HashMap)map).containsKey("loginBtnAlignParentRight")) {
			builder.setLoginBtnAlignParentRight((Boolean)((HashMap)map).get("loginBtnAlignParentRight"));
		}

		if (((HashMap)map).containsKey("loginBtnTextBold")) {
			builder.setLoginBtnTextBold((Boolean)((HashMap)map).get("loginBtnTextBold"));
		}


		//Slogan

		if (((HashMap)map).containsKey("sloganOffsetX")) {
			builder.setSloganOffsetX((Integer)((HashMap)map).get("sloganOffsetX"));
		}



		if (((HashMap)map).containsKey("sloganOffsetY")) {
			builder.setSloganOffsetY((Integer)((HashMap)map).get("sloganOffsetY"));
		}



		if (((HashMap)map).containsKey("sloganOffsetBottomY")) {
			builder.setSloganOffsetBottomY((Integer)((HashMap)map).get("sloganOffsetBottomY"));
		}



		if (((HashMap)map).containsKey("sloganTextSize")) {
			builder.setSloganTextSize((Integer)((HashMap)map).get("sloganTextSize"));
		}

		if (((HashMap)map).containsKey("sloganTextColor")) {
			String sloganTextColor = (String)((HashMap)map).get("sloganTextColor");
			builder.setSloganTextColor(Color.parseColor(sloganTextColor));
		}

//		if (((HashMap)map).containsKey("sloganTextColor")) {
//			builder.setSloganTextColor((Integer)((HashMap)map).get("sloganTextColor"));
//		}
		if (((HashMap)map).containsKey("sloganOffsetRightX")) {
			builder.setSloganOffsetRightX((Integer)((HashMap)map).get("sloganOffsetRightX"));
		}



		if (((HashMap)map).containsKey("sloganAlignParentRight")) {
			builder.setSloganAlignParentRight((Boolean)((HashMap)map).get("sloganAlignParentRight"));
		}
		if (((HashMap)map).containsKey("sloganTextBold")) {
			builder.setSloganTextBold((Boolean)((HashMap)map).get("sloganTextBold"));
		}

		if (((HashMap)map).containsKey("sloganHidden")) {
			builder.setSloganHidden((Boolean)((HashMap)map).get("sloganHidden"));
		}


		// 授权页面
		if (((HashMap)map).containsKey("backgroundImg")) {
			builder.setBackgroundImgId(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("backgroundImg")));
		}


		if (((HashMap)map).containsKey("backgroundClickClose")) {
			builder.setBackgroundClickClose((Boolean)((HashMap)map).get("backgroundClickClose"));
		}
		if (((HashMap)map).containsKey("fullScreen")) {
			builder.setFullScreen((Boolean)((HashMap)map).get("fullScreen"));
		}


		if (((HashMap)map).containsKey("immersiveTheme")) {
			builder.setImmersiveTheme((Boolean)((HashMap)map).get("immersiveTheme"));
		}



		if (((HashMap)map).containsKey("immersiveStatusTextColorBlack")) {
			builder.setImmersiveStatusTextColorBlack((Boolean)((HashMap)map).get("immersiveStatusTextColorBlack"));
		}


		//Dialog


		if (((HashMap)map).containsKey("dialogTheme")) {
			builder.setDialogTheme((Boolean)((HashMap)map).get("dialogTheme"));
		}



		if (((HashMap)map).containsKey("dialogAlignBottom")) {
			builder.setDialogAlignBottom((Boolean)((HashMap)map).get("dialogAlignBottom"));
		}



		if (((HashMap)map).containsKey("dialogOffsetX")) {
			builder.setDialogOffsetX((Integer)((HashMap)map).get("dialogOffsetX"));
		}



		if (((HashMap)map).containsKey("dialogOffsetY")) {
			builder.setDialogOffsetY((Integer)((HashMap)map).get("dialogOffsetY"));
		}



		if (((HashMap)map).containsKey("dialogWidth")) {
			builder.setDialogWidth((Integer)((HashMap)map).get("dialogWidth"));
		}



		if (((HashMap)map).containsKey("dialogHeight")) {
			builder.setDialogHeight((Integer)((HashMap)map).get("dialogHeight"));
		}

		if (((HashMap)map).containsKey("dialogBackground")) {
			builder.setDialogMaskBackground(ResHelper.getBitmapRes(context,(String)((HashMap)map).get("dialogBackground")));
		}


		if (((HashMap)map).containsKey("dialogBackgroundClickClose")) {
			builder.setDialogMaskBackgroundClickClose((Boolean)((HashMap)map).get("dialogBackgroundClickClose"));
		}

		return builder.build();
	}

}
