package com.vuphu.checkedtodo.domains.list.note;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.vuphu.checkedtodo.domains.main.ScrollingActivity;
import com.vuphu.checkedtodo.models.Note;
import com.vuphu.checkedtodo.R;

import java.util.Calendar;
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
        snoozeClick(holder);
        editCLick(holder);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void removeItem(int adapterPosition) {
        postList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    private void snoozeClick ( NoteViewHolder holder){
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        holder.snooze.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                    (view, hourOfDay, minute) -> {}, mHour, mMinute, false);
            timePickerDialog.show();
        });

    }

    private void editCLick (NoteViewHolder holder){
        holder.itemView.setOnLongClickListener(v -> {
            ((ScrollingActivity) context).getSheetBehavior().setState(BottomSheetBehavior.STATE_EXPANDED);
            return true;
        });
    }
}
