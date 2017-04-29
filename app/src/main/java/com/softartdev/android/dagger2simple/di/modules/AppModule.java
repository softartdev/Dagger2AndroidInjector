package com.softartdev.android.dagger2simple.di.modules;

import android.content.Context;

import com.softartdev.android.dagger2simple.App;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
}
