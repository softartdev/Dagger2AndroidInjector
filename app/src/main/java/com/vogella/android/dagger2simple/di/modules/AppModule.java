package com.vogella.android.dagger2simple.di.modules;

import android.content.Context;

import com.vogella.android.dagger2simple.MyApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context provideContext(MyApplication application) {
        return application.getApplicationContext();
    }
}
