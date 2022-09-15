package com.snuggles.android.systemui.smartspace.dagger;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Handler;

import com.android.keyguard.KeyguardUpdateMonitor;
import com.android.systemui.broadcast.BroadcastDispatcher;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.qualifiers.Main;
import com.android.systemui.dump.DumpManager;
import com.android.systemui.flags.FeatureFlags;
import com.android.systemui.plugins.BcSmartspaceDataPlugin;
import com.android.systemui.statusbar.NotificationMediaManager;
import com.android.systemui.statusbar.policy.NextAlarmController;
import com.android.systemui.statusbar.policy.ZenModeController;
import com.android.systemui.util.concurrency.DelayableExecutor;

import com.google.android.systemui.smartspace.BcSmartspaceDataProvider;
import com.snuggles.android.systemui.smartspace.KeyguardMediaViewController;
import com.snuggles.android.systemui.smartspace.KeyguardSmartspaceController;
import com.snuggles.android.systemui.smartspace.KeyguardZenAlarmViewController;
import com.snuggles.android.systemui.smartspace.SmartSpaceController;

import dagger.Module;
import dagger.Provides;

@Module
public interface SmartspaceSnugglesModule {

    @Provides
    @SysUISingleton
    static SmartSpaceController provideSmartSpaceController(
            Context context,
            KeyguardUpdateMonitor updateMonitor,
            Handler handler,
            AlarmManager am,
            DumpManager dm) {
        return new SmartSpaceController(context, updateMonitor, handler, am, dm);
    }

    @Provides
    @SysUISingleton
    static KeyguardSmartspaceController provideKeyguardSmartspaceController(
            Context context,
            FeatureFlags featureFlags,
            KeyguardZenAlarmViewController keyguardZenAlarmViewController,
            KeyguardMediaViewController keyguardMediaViewController) {
        return new KeyguardSmartspaceController(
                context, featureFlags, keyguardZenAlarmViewController, keyguardMediaViewController);
    }

    @Provides
    @SysUISingleton
    static KeyguardZenAlarmViewController provideKeyguardZenAlarmViewController(
            Context context,
            BcSmartspaceDataPlugin bcSmartspaceDataPlugin,
            ZenModeController zenModeController,
            AlarmManager alarmManager,
            NextAlarmController nextAlarmController,
            Handler handler) {
        return new KeyguardZenAlarmViewController(
                context,
                bcSmartspaceDataPlugin,
                zenModeController,
                alarmManager,
                nextAlarmController,
                handler);
    }

    @Provides
    @SysUISingleton
    static KeyguardMediaViewController provideKeyguardMediaViewController(
            Context context,
            BcSmartspaceDataPlugin bcSmartspaceDataPlugin,
            @Main DelayableExecutor delayableExecutor,
            NotificationMediaManager notificationMediaManager,
            BroadcastDispatcher broadcastDispatcher) {
        return new KeyguardMediaViewController(
                context,
                bcSmartspaceDataPlugin,
                delayableExecutor,
                notificationMediaManager,
                broadcastDispatcher);
    }

    @Provides
    @SysUISingleton
    static BcSmartspaceDataPlugin provideBcSmartspaceDataPlugin() {
        return new BcSmartspaceDataProvider();
    }
}
