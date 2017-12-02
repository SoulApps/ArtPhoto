package com.example.jannu.artphoto.ui.main;

import android.arch.lifecycle.ViewModel;
import android.widget.ImageView;

import com.example.jannu.artphoto.base.model.DataFiller;
import com.example.jannu.artphoto.base.model.MangaBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jannu on 12/2/17.
 */

@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends ViewModel {

    public static final int NO_ITEM_SELECTED = -1;

    private List<MangaBook> items;
    private int selectedItem = NO_ITEM_SELECTED;
    private ImageView img;


    public List<MangaBook> getItems() {
        if (items == null) {
            items = DataFiller.fillData();
        }
        return items;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void setImageSource(ImageView imgManga) {
        img = imgManga;
    }

    public ImageView getImage(){
        return img;
    }
}
