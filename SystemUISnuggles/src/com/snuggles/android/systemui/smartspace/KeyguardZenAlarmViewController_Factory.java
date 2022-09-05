package com.snuggles.android.systemui.smartspace;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Handler;

import com.android.systemui.plugins.BcSmartspaceDataPlugin;
import com.android.systemui.statusbar.policy.NextAlarmController;
import com.android.systemui.statusbar.policy.ZenModeController;

import dagger.internal.Factory;

import javax.inject.Provider;

public final class KeyguardZenAlarmViewController_Factory
        implements Factory<KeyguardZenAlarmViewController> {
    private final Provider<AlarmManager> alarmManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<Handler> handlerProvider;
    private final Provider<NextAlarmController> nextAlarmControllerProvider;
    private final Provider<BcSmartspaceDataPlugin> pluginProvider;
    private final Provider<ZenModeController> zenModeControllerProvider;

    public KeyguardZenAlarmViewController_Factory(
            Provider<Context> provider,
            Provider<BcSmartspaceDataPlugin> provider2,
            Provider<ZenModeController> provider3,
            Provider<AlarmManager> provider4,
            Provider<NextAlarmController> provider5,
            Provider<Handler> provider6) {
        contextProvider = provider;
        pluginProvider = provider2;
        zenModeControllerProvider = provider3;
        alarmManagerProvider = provider4;
        nextAlarmControllerProvider = provider5;
        handlerProvider = provider6;
    }

    @Override
    public KeyguardZenAlarmViewController get() {
        return newInstance(
                contextProvider.get(),
                pluginProvider.get(),
                zenModeControllerProvider.get(),
                alarmManagerProvider.get(),
                nextAlarmControllerProvider.get(),
                handlerProvider.get());
    }

    public static KeyguardZenAlarmViewController_Factory create(
            Provider<Context> provider,
            Provider<BcSmartspaceDataPlugin> provider2,
            Provider<ZenModeController> provider3,
            Provider<AlarmManager> provider4,
            Provider<NextAlarmController> provider5,
            Provider<Handler> provider6) {
        return new KeyguardZenAlarmViewController_Factory(
                provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static KeyguardZenAlarmViewController newInstance(
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
}
