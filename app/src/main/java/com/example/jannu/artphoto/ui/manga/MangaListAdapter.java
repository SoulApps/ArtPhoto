package com.example.jannu.artphoto.ui.manga;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jannu.artphoto.R;
import com.example.jannu.artphoto.base.model.MangaBook;
import com.example.jannu.artphoto.ui.main.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jannu on 12/2/17.
 */

public class MangaListAdapter extends BaseAdapter {
    private final List<MangaBook> mData;
    private final LayoutInflater mLayoutInflater;

    public MangaListAdapter(Context context, @NonNull List<MangaBook> data) {
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.fragment_manga_item, parent, false);
            viewHolder = onCreateViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        onBindViewHolder(viewHolder, position);
        return convertView;
    }

    private ViewHolder onCreateViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    static class ViewHolder {
        @BindView(R.id.fragment_manga_lblAuthor)
        TextView frgMangaLblAuthor;
        @BindView(R.id.fragment_manga_lblTitle)
        TextView frgMangaLblTitle;
        @BindView(R.id.fragment_manga_lblYear)
        TextView frgMangaLblYear;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


        public void bind(final MangaBook mangaBook) {
            frgMangaLblAuthor.setText(mangaBook.getAuthor());
            frgMangaLblTitle.setText(mangaBook.getTitle());
            frgMangaLblYear.setText(String.valueOf(mangaBook.getYear()));
        }
    }
}
