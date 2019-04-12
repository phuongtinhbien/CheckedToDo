package com.vuphu.checkedtodo.ultils;

import android.graphics.Canvas;
import android.view.View;

import com.vuphu.checkedtodo.domains.list.note.NoteViewHolder;
import com.vuphu.checkedtodo.models.Note;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private RecyclerItemTouchHelperListener listener;
    private boolean mSwipable = true;


    public SwipeToDeleteCallback(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }


    public SwipeToDeleteCallback(RecyclerItemTouchHelperListener listener) {
        super(0, ItemTouchHelper.LEFT);
        this.listener = listener;

    }


    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {
            View foregroundView = ((NoteViewHolder) viewHolder).itemView;
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((NoteViewHolder) viewHolder).itemView;
        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        View foregroundView = ((NoteViewHolder) viewHolder).itemView;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View foregroundView = ((NoteViewHolder) viewHolder).itemView;
        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (listener != null) {
            listener.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
        }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    public interface RecyclerItemTouchHelperListener {
        void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return mSwipable;
    }

    public void setmSwipable(boolean mSwipable) {
        this.mSwipable = mSwipable;
    }
}
