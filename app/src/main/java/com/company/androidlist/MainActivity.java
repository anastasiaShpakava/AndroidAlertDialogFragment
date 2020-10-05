package com.company.androidlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<Figure> figureList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        RecyclerView recyclerView = findViewById(R.id.figureList);
        FigureAdapter figureAdapter = new FigureAdapter(this, figureList);
        recyclerView.setAdapter(figureAdapter);

        figureList.add(new Figure(R.drawable.hexagon, "Hexagon"));
    }
}