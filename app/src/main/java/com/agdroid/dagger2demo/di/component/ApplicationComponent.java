package com.agdroid.dagger2demo.di.component;

import android.app.Application;
import android.content.Context;

import com.agdroid.dagger2demo.DemoApplication;
import com.agdroid.dagger2demo.data.DataManager;
import com.agdroid.dagger2demo.data.DbHelper;
import com.agdroid.dagger2demo.data.SharedPrefsHelper;
import com.agdroid.dagger2demo.di.ApplicationContext;
import com.agdroid.dagger2demo.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andre on 19.11.2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();
}
