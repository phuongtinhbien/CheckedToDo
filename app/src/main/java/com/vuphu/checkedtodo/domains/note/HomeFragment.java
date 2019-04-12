package com.vuphu.checkedtodo.domains.note;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.vuphu.checkedtodo.MainApplication;
import com.vuphu.checkedtodo.R;
import com.vuphu.checkedtodo.domains.base.BaseFragment;
import com.vuphu.checkedtodo.domains.list.note.NoteAdapter;
import com.vuphu.checkedtodo.models.Note;
import com.vuphu.checkedtodo.ultils.SwipeToDeleteCallback;


import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

@EFragment(R.layout.fragment_note)
public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    @App
    MainApplication application;
    @Inject
    HomePresenter presenter;

    @ViewById(R.id.fragment_note_lv_notes)
    RecyclerView noteList;

    private NoteAdapter noteAdapter;

    private List<Note> note;

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallback;

    private SwipeToDeleteCallback.RecyclerItemTouchHelperListener listener;


    @AfterInject
    void inject() {
        DaggerHomeComponent.builder()
                .applicationComponent(application.getApplicationComponent())
                .build()
                .inject(this);


    }

    @AfterViews
    void init() {
        presenter.initNotes();
    }

    @Override
    public MvpPresenter createPresenter() {
        return this.presenter;
    }

    @Override
    public void notes(List<Note> notes) {
        this.note = notes;
        noteAdapter = new NoteAdapter(getActivity(), notes);
        noteList.setAdapter(noteAdapter);
        updateUI();

    }

    private void updateUI() {
        int direc = getArguments().getInt("DIRECTION");
        if (note != null && note.size() != 0) {
            listener = (viewHolder, direction, position) -> {

                final Note deletedItem = note.get(viewHolder.getAdapterPosition());
                noteAdapter.removeItem(viewHolder.getAdapterPosition());
                this.note.remove(deletedItem);
            };
            itemTouchHelperCallback = new SwipeToDeleteCallback(0, direc, listener);
            new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(noteList);
        } else {
            if (itemTouchHelperCallback != null) {
                ((SwipeToDeleteCallback) itemTouchHelperCallback).setmSwipable(false);
            }
        }
    }



}
