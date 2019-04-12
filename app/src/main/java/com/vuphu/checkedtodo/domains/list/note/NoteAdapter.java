package com.vuphu.checkedtodo.domains.list.note;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vuphu.checkedtodo.models.Note;
import com.vuphu.checkedtodo.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private Context context;
    private List<Note> postList;

    public NoteAdapter(Context context, List<Note> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void removeItem(int adapterPosition) {
        postList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }
}
