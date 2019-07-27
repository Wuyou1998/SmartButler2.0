package com.wy.smartbutler.base;

import android.app.Application;

import com.wy.smartbutler.utils.Constant;

import cn.bmob.v3.Bmob;

/* 名称: SmartButler2.0.com.wy.smartbutler.application.BaseApplication
 * 用户: _VIEW
 * 时间: 2019/7/27,13:50
 * 描述: 一些初始化工作
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.BMOB_APP_ID);
    }
}
