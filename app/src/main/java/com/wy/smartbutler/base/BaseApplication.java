package com.wy.smartbutler.base;

import android.app.Application;

import com.wy.smartbutler.utils.Constant;

import java.util.HashSet;
import java.util.Set;

import cn.bmob.v3.Bmob;
import cn.jpush.android.api.JPushInterface;

/* 名称: SmartButler2.0.com.wy.smartbutler.application.BaseApplication
 * 用户: _VIEW
 * 时间: 2019/7/27,13:50
 * 描述: 一些初始化工作
 */
public class BaseApplication extends Application {
    public static BaseApplication mApplication = null;

    public static BaseApplication getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK();
    }

    private void initSDK() {
        mApplication = this;
        Bmob.initialize(this, Constant.BMOB_APP_ID);
        //初始化sdk
        JPushInterface.setDebugMode(true);//正式版的时候设置false，关闭调试
        JPushInterface.init(this);
        //0添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("andfixdemo");//名字任意，可多添加几个
        JPushInterface.setTags(this, set, null);//设置标签
    }
}
