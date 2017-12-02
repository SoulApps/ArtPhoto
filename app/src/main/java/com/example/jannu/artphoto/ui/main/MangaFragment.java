package com.example.jannu.artphoto.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jannu.artphoto.R;


public class MangaFragment extends Fragment {
    //todo change methods
    //todo cargar fragmento en main
    //todo gestionar la interfaz del fragmento
    //todo mostrar la imagen de preview por defecto
    //todo gestionar los clicks
    //todo limpiar codigo
    // Objeto que será informado cuando se seleccione un elemento.
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    public MangaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MangaFragment newInstance(int columnCount) {
        MangaFragment fragment = new MangaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return the created fragment
        return inflater.inflate(R.layout.fragment_manga_list,container, false);
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
