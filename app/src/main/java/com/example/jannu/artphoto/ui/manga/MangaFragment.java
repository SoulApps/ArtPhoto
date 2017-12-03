package com.example.jannu.artphoto.ui.manga;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.main.MainActivityViewModel;
import com.example.jannu.artphoto.utils.ConfigurationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;


public class MangaFragment extends Fragment {

    //bindViews
    @BindView(R.id.fragment_manga_lstManga)
    ListView lstManga;
    @BindView(R.id.fragment_manga_imgMangaPreview)
    ImageView imgPreview;
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
        //select the item, place the new image and inform the listener
        MangaBook manga = (MangaBook) lstManga.getItemAtPosition(position);
        imgPreview.setImageResource(manga.getImageResId());
        mListener.onItemSelected((MangaBook) lstManga.getItemAtPosition(position), position);
    }

    public void selectItem(int position) {
        if (position >= 0) {
            lstManga.setItemChecked(position, true);
            lstManga.setSelection(position);
        } else {
            lstManga.setItemChecked(mViewModel.getSelectedItem(), false);
            lstManga.clearChoices();
        }
        mViewModel.setSelectedItem(position);
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mViewModel.setSelectedItem(savedInstanceState.getInt(STATE_SELECTED_ITEM));
        }
    }

    private void initViews(View view) {
        ButterKnife.bind(this, view);
        mAdapter = new MangaListAdapter(getContext(), mViewModel.getItems());
        lstManga.setAdapter(mAdapter);
        //lstItems.setOnItemClickListener((adapterView, v, position, id) -> showItem(position));
    }
    //on item click we show the new activity and select the item.
    @OnItemClick(R.id.fragment_manga_lstManga)
    void onMangaListItemClick(AdapterView<?> parent, View view, int position, long id){
        //change the color of the actual item
        if(mViewModel.getSelectedItem() != -1){
            mAdapter.getView(mViewModel.getSelectedItem(), view, parent).setBackgroundColor(Color.MAGENTA);
        }
        showItem(position);
        setColor(view, position);
    }

    private void setColor(View view, int position) {
        view.setBackgroundColor(Color.GRAY);
        mAdapter.notifyDataSetChanged();
    }

    // Needed in case activity is destroy because of low memory.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_ITEM, mViewModel.getSelectedItem());
    }

}
