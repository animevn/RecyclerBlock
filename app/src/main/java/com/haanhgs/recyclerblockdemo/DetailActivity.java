package com.haanhgs.recyclerblockdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.tbrDetail);
        setSupportActionBar(toolbar);

        //set this so when click back arrow in action bar will return to main activity
        //should set parent activity to be mainactivity
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", 0);
        TextView tvDetail = findViewById(R.id.tvDetail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            tvDetail.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }
        tvDetail.setText(CreateSongList.getSongs().get(id).getDetail());

    }

}
