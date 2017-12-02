package com.example.jannu.artphoto.ui.manga;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.main.MainActivityViewModel;
import com.example.jannu.artphoto.utils.ConfigurationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;


public class MangaFragment extends Fragment {
    //todo change methods
    //todo cargar fragmento en main
    //todo gestionar la interfaz del fragmento
    //todo mostrar la imagen de preview por defecto
    //todo gestionar los clicks
    //todo limpiar codigo

    //bindViews
    @BindView(R.id.fragment_manga_lstManga)
    ListView fragment_manga_lstManga;
    //vars
    private static final String STATE_SELECTED_ITEM = "STATE_SELECTED_ITEM";
    public static final int NO_ITEM_SELECTED = -1;
    private Callback mListener;
    private MainActivityViewModel mViewModel;
    private MangaListAdapter mAdapter;

    // Comunication interface with activity.
    public interface Callback {
        void onItemSelected(MangaBook item, int position);

        // When detail shown (even from backstack).
        void onDetailShown(int position);
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
        mListener.onItemSelected((MangaBook) fragment_manga_lstManga.getItemAtPosition(position), position);
    }

    public void selectItem(int position) {
        if (position >= 0) {
            fragment_manga_lstManga.setItemChecked(position, true);
            fragment_manga_lstManga.setSelection(position);
        }
        else {
            fragment_manga_lstManga.setItemChecked(mViewModel.getSelectedItem(), false);
            fragment_manga_lstManga.clearChoices();
        }
        mViewModel.setSelectedItem(position);
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mViewModel.setSelectedItem(savedInstanceState.getInt(STATE_SELECTED_ITEM));
        }
    }

    private void initViews(View view) {
        //todo mirar aqui
        ButterKnife.bind(this,view);
        /*int itemLayout = ConfigurationUtils.hasLandscapeOrientation(
                //empty view
                getActivity()) ? android.R.layout.activity_list_item : android.R.layout
                .simple_list_item_1;*/
        mAdapter = new MangaListAdapter(getContext(),mViewModel.getItems());
        fragment_manga_lstManga.setAdapter(mAdapter);
        //lstItems.setOnItemClickListener((adapterView, v, position, id) -> showItem(position));
    }
    @OnItemClick(R.id.fragment_manga_lstManga)
    void onMangaListItemClick(int position){
        showItem(position);
    }
    // Needed in case activity is destroy because of low memory.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_ITEM, mViewModel.getSelectedItem());
    }

}
