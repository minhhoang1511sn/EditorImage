package com.EditorImage.edity.filters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.EditorImage.edity.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import ja.burhanrashid52.photoeditor.PhotoFilter;

public class FilterViewAdapter extends RecyclerView.Adapter<FilterViewAdapter.ViewHolder> {

    private FilterListener FilterListener;
    private List<Pair<String, PhotoFilter>> PairList = new ArrayList<>();

    public FilterViewAdapter(FilterListener filterListener) {
        FilterListener = filterListener;
        setupFilters();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_filter_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pair<String, PhotoFilter> filterPair = PairList.get(position);
        Bitmap fromAsset = getBitmapFromAsset(holder.itemView.getContext(), filterPair.first);
        holder.mImageFilterView.setImageBitmap(fromAsset);
        holder.mTxtFilterName.setText(filterPair.second.name().replace("_", " "));
    }

    @Override
    public int getItemCount() {
        return PairList.size();
    }

    private Bitmap getBitmapFromAsset(Context context, String strName) {
        AssetManager assetManager = context.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
            return BitmapFactory.decodeStream(istr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void setupFilters() {
        PairList.add(new Pair<>("filters/original.png", PhotoFilter.NONE));
        PairList.add(new Pair<>("filters/auto_fix.png", PhotoFilter.AUTO_FIX));
        PairList.add(new Pair<>("filters/brightness.png", PhotoFilter.BRIGHTNESS));
        PairList.add(new Pair<>("filters/contrast.png", PhotoFilter.CONTRAST));
        PairList.add(new Pair<>("filters/documentary.png", PhotoFilter.DOCUMENTARY));
        PairList.add(new Pair<>("filters/dual_tone.png", PhotoFilter.DUE_TONE));
        PairList.add(new Pair<>("filters/fill_light.png", PhotoFilter.FILL_LIGHT));
        PairList.add(new Pair<>("filters/fish_eye.png", PhotoFilter.FISH_EYE));
        PairList.add(new Pair<>("filters/grain.png", PhotoFilter.GRAIN));
        PairList.add(new Pair<>("filters/gray_scale.png", PhotoFilter.GRAY_SCALE));
        PairList.add(new Pair<>("filters/lomish.png", PhotoFilter.LOMISH));
        PairList.add(new Pair<>("filters/negative.png", PhotoFilter.NEGATIVE));
        PairList.add(new Pair<>("filters/posterize.png", PhotoFilter.POSTERIZE));
        PairList.add(new Pair<>("filters/saturate.png", PhotoFilter.SATURATE));
        PairList.add(new Pair<>("filters/sepia.png", PhotoFilter.SEPIA));
        PairList.add(new Pair<>("filters/sharpen.png", PhotoFilter.SHARPEN));
        PairList.add(new Pair<>("filters/temprature.png", PhotoFilter.TEMPERATURE));
        PairList.add(new Pair<>("filters/tint.png", PhotoFilter.TINT));
        PairList.add(new Pair<>("filters/vignette.png", PhotoFilter.VIGNETTE));
        PairList.add(new Pair<>("filters/cross_process.png", PhotoFilter.CROSS_PROCESS));
        PairList.add(new Pair<>("filters/b_n_w.png", PhotoFilter.BLACK_WHITE));
        PairList.add(new Pair<>("filters/flip_horizental.png", PhotoFilter.FLIP_HORIZONTAL));
        PairList.add(new Pair<>("filters/flip_vertical.png", PhotoFilter.FLIP_VERTICAL));
        PairList.add(new Pair<>("filters/rotate.png", PhotoFilter.ROTATE));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageFilterView;
        TextView mTxtFilterName;

        ViewHolder(View itemView) {
            super(itemView);
            mImageFilterView = itemView.findViewById(R.id.imgFilterView);
            mTxtFilterName = itemView.findViewById(R.id.txtFilterName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FilterListener.onFilterSelected(PairList.get(getLayoutPosition()).second);
                }
            });
        }
    }
}
