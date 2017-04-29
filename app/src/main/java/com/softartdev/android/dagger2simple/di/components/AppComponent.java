package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.App;
import com.softartdev.android.dagger2simple.di.modules.ActivityModule;
import com.softartdev.android.dagger2simple.di.modules.AppModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, ActivityModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }

    void inject(App application);
}
