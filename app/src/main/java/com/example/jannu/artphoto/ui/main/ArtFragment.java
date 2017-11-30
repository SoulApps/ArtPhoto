package com.example.jannu.artphoto.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jannu.artphoto.R;


public class ArtFragment extends Fragment {
    //todo change methods
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public ArtFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ArtFragment newInstance(int columnCount) {
        ArtFragment fragment = new ArtFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return null;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //todo fill this
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //todo fill this
    }

}
