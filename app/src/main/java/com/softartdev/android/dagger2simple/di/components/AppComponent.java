package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.App;
import com.softartdev.android.dagger2simple.di.modules.ActivityModule;
import com.softartdev.android.dagger2simple.di.modules.AppModule;
import com.softartdev.android.dagger2simple.di.modules.FragmentModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, ActivityModule.class, FragmentModule.class, AndroidSupportInjectionModule.class})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }

    void inject(App application);
}
