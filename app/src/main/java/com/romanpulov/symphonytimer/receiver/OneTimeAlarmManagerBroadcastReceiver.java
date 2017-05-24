package com.romanpulov.symphonytimer.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.romanpulov.symphonytimer.helper.ActivityWakeHelper;
import com.romanpulov.symphonytimer.helper.DateFormatterHelper;
import com.romanpulov.symphonytimer.helper.LoggerHelper;

public class OneTimeAlarmManagerBroadcastReceiver extends BroadcastReceiver {
    private static void logContext(Context context, String message) {
        LoggerHelper.logContext(context, "AlarmManagerReceiver", message);
    }

	@Override
	public void onReceive(Context context, Intent intent) {
        logContext(context, "onReceive");
        ActivityWakeHelper.wake(context);
	}
}