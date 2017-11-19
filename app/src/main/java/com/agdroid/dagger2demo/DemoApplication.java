package com.agdroid.dagger2demo;

import android.app.Application;

import com.agdroid.dagger2demo.data.DataManager;
import com.agdroid.dagger2demo.di.component.ApplicationComponent;
import com.agdroid.dagger2demo.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by andre on 19.11.2017.
 *
 * DemoApplication wird über die eigentliche Application gesetzt
 * -> in AndroidManifest.xml der App zugeordnet -> android:name=".DemoApplication"

 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataMenager;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
