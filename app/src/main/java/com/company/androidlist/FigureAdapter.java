package com.company.androidlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FigureAdapter extends RecyclerView.Adapter<FigureAdapter.ViewHolderFigure> {
    private LayoutInflater layoutInflater;
    private List<Figure> figureList;
    private Context context;


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
    public void onBindViewHolder(@NonNull FigureAdapter.ViewHolderFigure holder, int position) {
        final Figure figure = figureList.get(position);
        holder.imageViewFigure.setImageResource(figure.getImage());
        holder.nameViewFigure.setText(figure.getText());
        holder.imageViewFigure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFigureFragment dialogFigureFragment = new DialogFigureFragment();
                dialogFigureFragment.show(((AppCompatActivity) context).getSupportFragmentManager(), "Fragment");
            }
        });
    }


    @Override
    public int getItemCount() {
        return figureList.size();
    }

    public static class ViewHolderFigure extends RecyclerView.ViewHolder {
        final ImageView imageViewFigure;
        final TextView nameViewFigure;

        ViewHolderFigure(View view) {
            super(view);
            imageViewFigure = view.findViewById(R.id.imageFigure);
            nameViewFigure = view.findViewById(R.id.nameFigure);
        }
    }
}
