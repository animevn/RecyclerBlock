package com.haanhgs.recyclerblockdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Song> songList;


    Adapter(List<Song> songList) {
        this.songList = songList;
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
        Song song = songList.get(position);
        holder.tvID.setText(String.format("%s", position + 1));
        holder.tvSong.setText(song.getDetail());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvID)
        TextView tvID;
        @BindView(R.id.tvSong)
        TextView tvSong;

        protected ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(App.appContext(), SongDetailActivity.class);
                intent.putExtra("ID", getAdapterPosition());

                //when open activity ouside of activity, need this
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                App.appContext().startActivity(intent);
            });
        }
    }
}
