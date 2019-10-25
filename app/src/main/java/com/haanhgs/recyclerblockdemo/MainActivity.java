package com.haanhgs.recyclerblockdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tbrMain = findViewById(R.id.tbrMain);
        setSupportActionBar(tbrMain);

        RecyclerView rvSong = findViewById(R.id.rvSong);
        rvSong.setLayoutManager(new LinearLayoutManager(this));
        rvSong.setItemAnimator(new DefaultItemAnimator());
        Adapter adapter = new Adapter(CreateSongList.getSongs());
        rvSong.setAdapter(adapter);
    }
}
