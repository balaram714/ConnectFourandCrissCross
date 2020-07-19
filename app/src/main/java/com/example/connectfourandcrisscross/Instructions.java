package com.example.connectfourandcrisscross;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Instructions extends RecyclerView.Adapter<Instructions.ListItemHolder> {
    private List<Game> mNoteList;
    private Main5Activity mMainActivity;

    public Instructions(Main5Activity mainActivity,
                        List<Game> noteList) {
        mMainActivity = mainActivity;
        mNoteList = noteList;

    }

    @NonNull
    @Override
    public Instructions.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);
        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Instructions.ListItemHolder holder, int position) {
        Game note = mNoteList.get(position);
        holder.mTitle.setText(note.getText());
        holder.image.setImageResource(note.getImg());
    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }
    public class ListItemHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener
             {
        TextView mTitle;
        ImageView image;
        public ListItemHolder(View view) {
            super(view);
            mTitle = (TextView)
                    view.findViewById(R.id.textView9);
             image=(ImageView)view.findViewById(R.id.imageView5);
            view.setClickable(true);
            view.setOnClickListener(this);
        }
                 @Override
                 public void onClick(View view) {

                      mMainActivity.abc();
                 }
    }
}
