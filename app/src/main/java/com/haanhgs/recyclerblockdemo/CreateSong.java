package com.haanhgs.recyclerblockdemo;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CreateSong {

    public static final List<Song> songs = new ArrayList<>();
    private static final int COUNT = 7;

    private  static void addSong(Song song){
        songs.add(song);
    }

    private static Song addSongAtPosition(int position){
        String newTitle;
        String newDetail;
        Context context = App.appContext();
        switch (position) {
            case 0:
                newTitle = context.getResources().getString(R.string.title0);
                newDetail = context.getResources().getString(R.string.detail0);
                break;
            case 1:
                newTitle = context.getResources().getString(R.string.title1);
                newDetail = context.getResources().getString(R.string.detail1);
                break;
            case 2:
                newTitle = context.getResources().getString(R.string.title2);
                newDetail = context.getResources().getString(R.string.detail2);
                break;
            case 3:
                newTitle = context.getResources().getString(R.string.title3);
                newDetail = context.getResources().getString(R.string.detail3);
                break;
            case 4:
                newTitle = context.getResources().getString(R.string.title4);
                newDetail = context.getResources().getString(R.string.detail4);
                break;
            case 5:
                newTitle = context.getResources().getString(R.string.title5);
                newDetail = context.getResources().getString(R.string.detail5);
                break;
            default:
                newTitle = context.getResources().getString(R.string.title6);
                newDetail = context.getResources().getString(R.string.detail6);
                break;
        }
        return new Song(newTitle, newDetail);
    }

    static {
        for (int i = 0; i < COUNT; i++){
            addSong(addSongAtPosition(i));
        }
    }

}
