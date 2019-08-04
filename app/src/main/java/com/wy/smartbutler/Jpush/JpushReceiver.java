package com.wy.smartbutler.Jpush;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

/* 名称: SmartButler2.0.com.wy.smartbutler.Jpush.JpushReciver
 * 用户: _VIEW
 * 时间: 2019/8/4,18:37
 * 描述: 极光推送receiver
 */
public class JpushReceiver extends JPushMessageReceiver {
    //有消息来了
    @Override
    public void onNotifyMessageArrived(final Context context, final NotificationMessage notificationMessage) {
        super.onNotifyMessageArrived(context, notificationMessage);
        new Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, notificationMessage.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //自定义消息来了
    @Override
    public void onMessage(final Context context, final CustomMessage customMessage) {
        super.onMessage(context, customMessage);
        new Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, customMessage.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    //对应的消息被点击了
    @Override
    public void onNotifyMessageOpened(final Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageOpened(context, notificationMessage);
        new Handler(context.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "消息打开了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
