package com.vuphu.checkedtodo.domains.note;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.vuphu.checkedtodo.models.Note;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomePresenter extends MvpBasePresenter<HomeView> {

    @Inject
    public HomePresenter() {
    }

    protected void initNotes(){
        List<Note> notes = new ArrayList<>();
        for (int i = 0; i<5;i++)
            notes.add(new Note());

        getView().notes(notes);
    }
}
