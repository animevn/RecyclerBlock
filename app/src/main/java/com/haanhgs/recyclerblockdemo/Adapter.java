package com.haanhgs.recyclerblockdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Song> songs;

    public Adapter(List<Song> songs){
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.tvID.setText(String.format("%s", position + 1));
        holder.tvSong.setText(song.getDetail());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            holder.tvSong.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvID;
        private final TextView tvSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvSong = itemView.findViewById(R.id.tvSong);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(App.context(), DetailActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("ID", getAdapterPosition());
                    App.context().startActivity(intent);
                }
            });
        }
    }
}
