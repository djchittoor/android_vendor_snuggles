package com.snuggles.android.systemui.smartspace;

import android.content.Context;

import com.android.systemui.flags.FeatureFlags;

import dagger.internal.Factory;

import javax.inject.Provider;

public final class KeyguardSmartspaceController_Factory
        implements Factory<KeyguardSmartspaceController> {
    private final Provider<Context> contextProvider;
    private final Provider<FeatureFlags> featureFlagsProvider;
    private final Provider<KeyguardMediaViewController> mediaControllerProvider;
    private final Provider<KeyguardZenAlarmViewController> zenControllerProvider;

    public KeyguardSmartspaceController_Factory(
            Provider<Context> provider,
            Provider<FeatureFlags> provider2,
            Provider<KeyguardZenAlarmViewController> provider3,
            Provider<KeyguardMediaViewController> provider4) {
        contextProvider = provider;
        featureFlagsProvider = provider2;
        zenControllerProvider = provider3;
        mediaControllerProvider = provider4;
    }

    @Override
    public KeyguardSmartspaceController get() {
        return newInstance(
                contextProvider.get(),
                featureFlagsProvider.get(),
                zenControllerProvider.get(),
                mediaControllerProvider.get());
    }

    public static KeyguardSmartspaceController_Factory create(
            Provider<Context> provider,
            Provider<FeatureFlags> provider2,
            Provider<KeyguardZenAlarmViewController> provider3,
            Provider<KeyguardMediaViewController> provider4) {
        return new KeyguardSmartspaceController_Factory(provider, provider2, provider3, provider4);
    }

    public static KeyguardSmartspaceController newInstance(
            Context context,
            FeatureFlags featureFlags,
            KeyguardZenAlarmViewController keyguardZenAlarmViewController,
            KeyguardMediaViewController keyguardMediaViewController) {
        return new KeyguardSmartspaceController(
                context, featureFlags, keyguardZenAlarmViewController, keyguardMediaViewController);
    }
}
