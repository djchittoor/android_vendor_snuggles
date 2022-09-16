package com.snuggles.android.systemui.dagger;

import com.android.systemui.dagger.DefaultComponentBinder;
import com.android.systemui.dagger.DependencyProvider;
import com.android.systemui.dagger.SysUIComponent;
import com.android.systemui.dagger.SysUISingleton;
import com.android.systemui.dagger.SystemUIBinder;
import com.android.systemui.dagger.SystemUICoreStartableModule;
import com.android.systemui.dagger.SystemUIModule;

import com.snuggles.android.systemui.keyguard.KeyguardSliceProviderSnuggles;
import com.snuggles.android.systemui.smartspace.KeyguardSmartspaceController;

import dagger.Subcomponent;

@SysUISingleton
@Subcomponent(
        modules = {
            DefaultComponentBinder.class,
            DependencyProvider.class,
            SystemUIBinder.class,
            SystemUIModule.class,
            SystemUICoreStartableModule.class,
            SnugglesSystemUIModule.class
        })
public interface SysUIComponentSnuggles extends SysUIComponent {
    @SysUISingleton
    @Subcomponent.Builder
    interface Builder extends SysUIComponent.Builder {
        SysUIComponentSnuggles build();
    }

    void inject(KeyguardSliceProviderSnuggles keyguardSliceProviderSnuggles);

    @SysUISingleton
    KeyguardSmartspaceController createKeyguardSmartspaceController();
}
