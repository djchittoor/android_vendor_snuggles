package com.snuggles.android.systemui.smartspace;

import android.content.ComponentName;
import android.content.Context;

import com.android.systemui.flags.FeatureFlags;
import com.android.systemui.flags.Flags;

import kotlin.jvm.internal.Intrinsics;

public final class KeyguardSmartspaceController {
    private final Context context;
    private final FeatureFlags featureFlags;
    private final KeyguardMediaViewController mediaController;
    private final KeyguardZenAlarmViewController zenController;

    public KeyguardSmartspaceController(
            Context context,
            FeatureFlags featureFlags,
            KeyguardZenAlarmViewController zenController,
            KeyguardMediaViewController mediaController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
        Intrinsics.checkNotNullParameter(zenController, "zenController");
        Intrinsics.checkNotNullParameter(mediaController, "mediaController");
        this.context = context;
        this.featureFlags = featureFlags;
        this.zenController = zenController;
        this.mediaController = mediaController;
        if (!featureFlags.isEnabled(Flags.SMARTSPACE)) {
            context.getPackageManager()
                    .setComponentEnabledSetting(
                            new ComponentName(
                                    "com.android.systemui",
                                    "com.google.android.systemui.keyguard.KeyguardSliceProviderGoogle"),
                            1,
                            1);
            return;
        }
        zenController.init();
        mediaController.init();
    }
}
