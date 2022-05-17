package com.EditorImage.edity.tools;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.EditorImage.edity.R;

import java.util.ArrayList;
import java.util.List;

public class EditingToolsAdapter extends RecyclerView.Adapter<EditingToolsAdapter.ViewHolder> {

    private List<ToolModel> ToolList = new ArrayList<>();
    private OnItemSelected OnItemSelected;

    public EditingToolsAdapter(OnItemSelected onItemSelected) {
        OnItemSelected = onItemSelected;
        ToolList.add(new ToolModel("Vẽ", R.drawable.ic_brush, ToolType.BRUSH));
        ToolList.add(new ToolModel("Text", R.drawable.ic_text, ToolType.TEXT));
        ToolList.add(new ToolModel("Cục tẩy", R.drawable.ic_eraser, ToolType.ERASER));
        ToolList.add(new ToolModel("Filter", R.drawable.ic_photo_filter, ToolType.FILTER));
        ToolList.add(new ToolModel("Emoji", R.drawable.ic_insert_emoticon, ToolType.EMOJI));
        ToolList.add(new ToolModel("Sticker", R.drawable.ic_sticker, ToolType.STICKER));
    }

    @Override
    public int getItemCount() {
        return ToolList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ToolModel item = ToolList.get(position);
        holder.txtTool.setText(item.ToolName);
        holder.imgToolIcon.setImageResource(item.ToolIcon);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_editing_tools, parent, false);
        return new ViewHolder(view);
    }

    public interface OnItemSelected {
        void onToolSelected(ToolType toolType);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgToolIcon;
        TextView txtTool;

        ViewHolder(View itemView) {
            super(itemView);
            imgToolIcon = itemView.findViewById(R.id.imgToolIcon);
            txtTool = itemView.findViewById(R.id.txtTool);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemSelected.onToolSelected(ToolList.get(getLayoutPosition()).ToolType);
                }
            });
        }
    }

    class ToolModel {
        private String ToolName;
        private int ToolIcon;
        private ToolType ToolType;

        ToolModel(String toolName, int toolIcon, ToolType toolType) {
            ToolName = toolName;
            ToolIcon = toolIcon;
            ToolType = toolType;
        }
    }

}
