package com.snuggles.android.systemui.dagger;


import com.android.systemui.dagger.GlobalModule;
import com.android.systemui.dagger.GlobalRootComponent;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {GlobalModule.class})
public interface GlobalRootComponentSnuggles extends GlobalRootComponent {

    @Component.Builder
    interface Builder extends GlobalRootComponent.Builder {
        GlobalRootComponentSnuggles build();
    }

    @Override
    SysUIComponentSnuggles.Builder getSysUIComponent();
}
