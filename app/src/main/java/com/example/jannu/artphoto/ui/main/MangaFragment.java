package com.example.jannu.artphoto.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.utils.ConfigurationUtils;


public class MangaFragment extends Fragment {
    //todo change methods
    //todo cargar fragmento en main
    //todo gestionar la interfaz del fragmento
    //todo mostrar la imagen de preview por defecto
    //todo gestionar los clicks
    //todo limpiar codigo
    //vars
    private static final String STATE_SELECTED_ITEM = "STATE_SELECTED_ITEM";
    public static final int NO_ITEM_SELECTED = -1;
    private ListView lstItems;
    private Callback mListener;
    private MainActivityViewModel mViewModel;

    // Comunication interface with activity.
    public interface Callback {
        void onItemSelected(String item, int position);
    }

    public MangaFragment() {
    }

    @SuppressWarnings("unused")
    public static MangaFragment newInstance() {
        //return the new fragment
        return new MangaFragment();
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
        return inflater.inflate(R.layout.fragment_manga_list, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (Callback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement fragment callback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //unlink the listener
        mListener = null;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        restoreInstanceState(savedInstanceState);
        initViews(getView());
        // If item selected.
        if (mViewModel.getSelectedItem() >= 0) {
            if (ConfigurationUtils.hasLandscapeOrientation(getActivity())) {
                showItem(mViewModel.getSelectedItem());
            } else {
                selectItem(mViewModel.getSelectedItem());
            }
        }
    }

    private void showItem(int position) {
        selectItem(position);
        mListener.onItemSelected((String) lstItems.getItemAtPosition(position), position);
    }

    private void selectItem(int position) {
        if (position >= 0) {
            lstItems.setItemChecked(position, true);
            lstItems.setSelection(position);
        }
        else {
            lstItems.setItemChecked(mViewModel.getSelectedItem(), false);
            lstItems.clearChoices();
        }
        mViewModel.setSelectedItem(position);
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mViewModel.setSelectedItem(savedInstanceState.getInt(STATE_SELECTED_ITEM));
        }
    }

    private void initViews(View view) {

    }

    // Needed in case activity is destroy because of low memory.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_ITEM, mViewModel.getSelectedItem());
    }

}
