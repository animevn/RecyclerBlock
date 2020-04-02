package com.haanhgs.recyclerblock;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tbrMain)
    Toolbar tbrMain;
    @BindView(R.id.rvSong)
    RecyclerView rvSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(tbrMain);
        tbrMain.setTitle(getTitle());

        rvSong.setLayoutManager(new LinearLayoutManager(this));
        rvSong.setItemAnimator(new DefaultItemAnimator());
        rvSong.setAdapter(new Adapter(CreateSong.songs));
    }


}
