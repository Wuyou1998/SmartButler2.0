package com.wy.smartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 项目名: SmartButler.com.wy.com.smartButler.utils.ShareUtils
 * 创建者:  VIEW
 * 日期:  2019/2/5,19:49
 * 描述:   SharedPreference封装
 */
public class ShareUtils {
    private static final String name="config";

    public static void putString(Context mContext, String key, String value){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }
    public static String getString(Context mContext, String key, String defvalue){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key,defvalue);
    }

    public static void putInt(Context mContext, String key, int value){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }
    public static int getInt(Context mContext, String key, int defvalue){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key,defvalue);
    }

    public static void putBoolean(Context mContext, String key, boolean value){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }
    public static boolean getBoolean(Context mContext, String key, boolean defvalue){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key,defvalue);
    }
    //删除单个
    public static void delShare(Context mContext, String key){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }
    //删全部
    public static void delAllShare(Context mContext){
        SharedPreferences sp=mContext.getSharedPreferences(name, Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }
    //保存图片到shareUtils
    public static void putImageToShare(Context mContext, ImageView imageView) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        //第一步：将Bitmap压缩成字节数组输出流
        ByteArrayOutputStream byStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byStream);
        //第二步：利用Base64将我们的字节数组输出流转换成String
        byte[] byteArray = byStream.toByteArray();
        String imgString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        //第三步：将String保存shareUtils
        putString(mContext, "image_title", imgString);
    }

    //读取图片
    public static void getImageToShare(Context mContext, ImageView imageView) {
        //1.拿到string
        String imgString = getString(mContext, "image_title", "");
        if (!imgString.equals("")) {
            //2.利用Base64将我们string转换
            byte[] byteArray = Base64.decode(imgString, Base64.DEFAULT);
            ByteArrayInputStream byStream = new ByteArrayInputStream(byteArray);
            //3.生成bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(byStream);
            imageView.setImageBitmap(bitmap);
        }
    }
}
