package com.softartdev.android.dagger2simple.di.components;

import com.softartdev.android.dagger2simple.ui.bottom.fragments.notifications.NotificationsFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface NotificationsFragmentSubcomponent extends AndroidInjector<NotificationsFragment> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<NotificationsFragment> {}
}
