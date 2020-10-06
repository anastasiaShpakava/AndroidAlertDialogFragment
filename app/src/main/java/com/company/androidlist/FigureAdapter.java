package com.company.androidlist;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FigureAdapter extends RecyclerView.Adapter<FigureAdapter.ViewHolderFigure> {
    private LayoutInflater layoutInflater;
    private List<Figure> figureList;
    private Context context;
    private Dialog myDialog;


    public FigureAdapter(Context context, List<Figure> figureList) {
        this.context = context;
        this.figureList = figureList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FigureAdapter.ViewHolderFigure onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.figure_item, parent, false);
        return new ViewHolderFigure(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final FigureAdapter.ViewHolderFigure holder, int position) {
        final Figure figure = figureList.get(position);
        holder.imageViewFigure.setImageResource(figure.getImage());
        holder.nameViewFigure.setText(figure.getText());
        holder.imageViewFigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new Dialog(context);
                myDialog.setContentView(R.layout.dialog_fragmet);
                TextView figureInfo = myDialog.findViewById(R.id.figureInfoText);
                ImageView figureImage = myDialog.findViewById(R.id.infoImage);
                figureInfo.setText(figureList.get(holder.getAdapterPosition()).getText());
                figureImage.setImageResource(figureList.get(holder.getAdapterPosition()).getImage());
                myDialog.setCanceledOnTouchOutside(true);
                myDialog.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return figureList.size();
    }

    public static class ViewHolderFigure extends RecyclerView.ViewHolder {
        private ImageView imageViewFigure;
        private TextView nameViewFigure;
        private LinearLayout item_info;

        ViewHolderFigure(View view) {
            super(view);
            imageViewFigure = view.findViewById(R.id.imageFigure);
            nameViewFigure = view.findViewById(R.id.nameFigure);
            item_info = view.findViewById(R.id.figure_item);
        }
    }
}
