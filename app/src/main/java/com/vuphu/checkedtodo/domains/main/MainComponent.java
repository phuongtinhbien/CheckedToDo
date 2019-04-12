package com.vuphu.checkedtodo.domains.main;


import com.vuphu.checkedtodo.infrastructures.ApplicationComponent;
import com.vuphu.checkedtodo.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class)
public abstract class MainComponent {

    public abstract MainPresenter presenter();

    public abstract void inject(ScrollingActivity mainActivity);
}
