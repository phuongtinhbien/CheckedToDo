package com.vuphu.checkedtodo.domains.list.note;

import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.vuphu.checkedtodo.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    MaterialButton snooze;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        snooze = itemView.findViewById(R.id.item_note_btn_snooze);

    }
}
