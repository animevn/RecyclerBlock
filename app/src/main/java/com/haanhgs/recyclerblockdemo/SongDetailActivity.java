package com.haanhgs.recyclerblockdemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDetailActivity extends AppCompatActivity {

    @BindView(R.id.tbrDetail)
    Toolbar tbrDetail;
    @BindView(R.id.tvDetail)
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        //Setup Toolbar
        setSupportActionBar(tbrDetail);

        //Setup action so click back or the back arrow in actionbar will
        //bring your back to home
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Song song = CreateSong.songs.get(getIntent().getIntExtra("ID", 0));
        if (song != null) {
            ((TextView) findViewById(R.id.tvDetail)).setText(song.getDetail());
        }
    }
}
