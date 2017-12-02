package com.example.jannu.artphoto.ui.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailFragment extends Fragment {
    // Communication interface.
    //Bind views
    @BindView(R.id.detail_fragment_imgDetail)
    ImageView detail_fragment_imgDetail;
    @BindView(R.id.detail_fragment_lblAuthor)
    TextView detail_fragment_lblAuthor;
    @BindView(R.id.detail_fragment_lblTitle)
    TextView detail_fragment_lblTitle;

    public interface Callback {
        void onDetailShown(int position);
    }

    public static final String EXTRA_ITEM = "EXTRA_ITEM";
    public static final String EXTRA_POSITION = "EXTRA_POSITION";

    private TextView lblItem;

    private int mPosition;
    private Callback mListener;

    public static DetailFragment newInstance(MangaBook item, int position) {
        DetailFragment fragment = new DetailFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_POSITION, position);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obtainArguments();
    }

    private void obtainArguments() {
        mPosition = getArguments().getInt(EXTRA_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (Callback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement fragment callback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(getView());
        showItem();
    }

    private void initViews(View view) {
        ButterKnife.bind(view);
    }

    private void showItem() {
        //todo mostrar imagen detalle pasando el res de la imagen
        //lblItem.setText(mItem);
        // Notify activity (needed in case of landscape configuration).
        if (mListener != null) {
            mListener.onDetailShown(mPosition);
        }
    }


}
