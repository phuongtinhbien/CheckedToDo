package com.vuphu.checkedtodo.domains.note;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.vuphu.checkedtodo.models.Note;

import java.util.List;

public interface HomeView extends MvpView {

    void notes(List<Note> notes);
}
