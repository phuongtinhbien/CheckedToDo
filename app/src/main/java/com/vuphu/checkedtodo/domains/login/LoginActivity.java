package com.vuphu.checkedtodo.domains.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.vuphu.checkedtodo.MainApplication;
import com.vuphu.checkedtodo.R;
import com.vuphu.checkedtodo.domains.base.BaseActivity;
import com.vuphu.checkedtodo.domains.main.DaggerMainComponent;
import com.vuphu.checkedtodo.domains.main.MainPresenter;
import com.vuphu.checkedtodo.domains.main.MainView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity<LoginView, LoginPresenter> implements LoginView{

    @App
    MainApplication application;
    @Inject
    LoginPresenter presenter;



    @AfterInject
    void inject() {
        DaggerLoginComponent.builder()
                .applicationComponent(application.getApplicationComponent())
                .build()
                .inject(this);

    }

    @SuppressLint("ClickableViewAccessibility")
    @AfterViews
    void init() {

    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return presenter;
    }
}
