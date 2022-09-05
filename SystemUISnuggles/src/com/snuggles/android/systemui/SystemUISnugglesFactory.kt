package com.snuggles.android.systemui

import android.content.Context

import com.snuggles.android.systemui.dagger.DaggerGlobalRootComponentSnuggles
import com.snuggles.android.systemui.dagger.GlobalRootComponentSnuggles

import com.android.systemui.SystemUIFactory
import com.android.systemui.dagger.GlobalRootComponent

public class SystemUISnugglesFactory : SystemUIFactory() {
    override fun buildGlobalRootComponent(context: Context) : GlobalRootComponent {
        return DaggerGlobalRootComponentSnuggles.builder()
                .context(context)
                .build()
    }
}
