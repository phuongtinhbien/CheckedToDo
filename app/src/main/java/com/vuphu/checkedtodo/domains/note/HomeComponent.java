package com.vuphu.checkedtodo.domains.note;


import com.vuphu.checkedtodo.infrastructures.ApplicationComponent;
import com.vuphu.checkedtodo.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class)
public abstract class HomeComponent {

    public abstract HomePresenter presenter();

    public abstract void inject(HomeFragment homeFragment);
}
