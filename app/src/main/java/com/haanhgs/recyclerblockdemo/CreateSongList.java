package com.haanhgs.recyclerblockdemo;

import java.util.ArrayList;
import java.util.List;

public class CreateSongList {

    public static List<Song> songs = new ArrayList<>();
    private static final int COUNT = 7;

    private static void addSong(Song song){
        songs.add(song);
    }

    private static Song createSongAtPostion(int position){
        String title;
        String detail;
        switch (position){
            case 0:
                title = App.context().getResources().getString(R.string.title0);
                detail = App.context().getResources().getString(R.string.detail0);
                break;
            case 1:
                title = App.context().getResources().getString(R.string.title1);
                detail = App.context().getResources().getString(R.string.detail1);
                break;
            case 2:
                title = App.context().getResources().getString(R.string.title2);
                detail = App.context().getResources().getString(R.string.detail2);
                break;
            case 3:
                title = App.context().getResources().getString(R.string.title3);
                detail = App.context().getResources().getString(R.string.detail3);
                break;
            case 4:
                title = App.context().getResources().getString(R.string.title4);
                detail = App.context().getResources().getString(R.string.detail4);
                break;
            case 5:
                title = App.context().getResources().getString(R.string.title5);
                detail = App.context().getResources().getString(R.string.detail5);
                break;
            default:
                title = App.context().getResources().getString(R.string.title6);
                detail = App.context().getResources().getString(R.string.detail6);
                break;
        }
        return new Song(title, detail);
    }

    static {
        for (int i = 0; i < COUNT; ++i){
            addSong(createSongAtPostion(i));
        }
    }

}
