package com.company.androidlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Figure> figureList = new ArrayList<>();
    private DialogFragment dialogFigureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        RecyclerView recyclerView = findViewById(R.id.figureList);
        FigureAdapter figureAdapter = new FigureAdapter(this, figureList);
        recyclerView.setAdapter(figureAdapter);

        figureList.add(new Figure(R.drawable.hexagon, "Hexagon"));
        figureList.add(new Figure(R.drawable.triangle, "Triangle"));
        figureList.add(new Figure(R.drawable.square, "Square"));
        figureList.add(new Figure(R.drawable.circle, "Circle"));
        figureList.add(new Figure(R.drawable.rectangle, "Rectangle"));
        figureList.add(new Figure(R.drawable.trapeze, "Trapeze"));
        figureList.add(new Figure(R.drawable.cone, "Cone"));
        figureList.add(new Figure(R.drawable.cylinder, "Cylinder"));

        dialogFigureFragment = new DialogFigureFragment();
    }
}