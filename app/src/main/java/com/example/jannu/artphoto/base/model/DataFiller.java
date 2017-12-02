package com.example.jannu.artphoto.base.model;

import com.example.jannu.artphoto.R;

import java.util.ArrayList;

/**
 * Created by jannu on 12/2/17.
 */

public class DataFiller {

    private DataFiller(){}

    public static ArrayList<MangaBook> fillData() {
        //create data
        ArrayList<MangaBook> mangaBookList = new ArrayList<>();
        //fill data
        mangaBookList.add(new MangaBook("Tite Kubo",2001,"Bleach", R.drawable.bleach));
        mangaBookList.add(new MangaBook("Kazue Katō",2009,"Ao no Exorcist ", R.drawable.aoexorcist));
        mangaBookList.add(new MangaBook("Yuyuko Takemiya",2006,"Toradora", R.drawable.toradora));
        mangaBookList.add(new MangaBook("Tsugumi Ohba",2003,"Death Note", R.drawable.deathnote));
        mangaBookList.add(new MangaBook("Sakae Esuno",2006,"Mirai Nikki", R.drawable.mirainikki));
        mangaBookList.add(new MangaBook("Sui Ishida",2011,"Tokyo Ghoul", R.drawable.tokyoghoul));
        mangaBookList.add(new MangaBook("Naoshi Arakawa",2011,"Shigatsu wa Kimi no Uso", R.drawable.shigatsu));
        mangaBookList.add(new MangaBook("Hajime Isayama",2009,"Shingeki no Kyojin", R.drawable.shingeki));
        mangaBookList.add(new MangaBook("Tappei Nagatsuki",2012,"Re:Zero kara Hajimeru Isekai Seikatsu", R.drawable.rezero));
        mangaBookList.add(new MangaBook("Yūto Tsukuda",2012,"Shokugeki no Sōma", R.drawable.shokugeninosoma));
        //return arrayList
        return mangaBookList;
    }
}
