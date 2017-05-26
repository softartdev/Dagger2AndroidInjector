package com.softartdev.android.dagger2simple.di.modules;

import android.content.Context;

import com.softartdev.android.dagger2simple.App;
import com.softartdev.android.dagger2simple.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(Context context) {
        return new DataManager(context);
    }
}
