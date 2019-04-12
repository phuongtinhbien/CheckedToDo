package com.vuphu.checkedtodo;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.vuphu.checkedtodo.infrastructures.ApplicationComponent;
import com.vuphu.checkedtodo.infrastructures.ApplicationModule;
import com.vuphu.checkedtodo.infrastructures.DaggerApplicationComponent;


import org.androidannotations.annotations.EApplication;

import androidx.multidex.MultiDexApplication;

@EApplication
public class MainApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidThreeTen.init(this);
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this)).build();

        setApplicationComponent(DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build());
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

}
