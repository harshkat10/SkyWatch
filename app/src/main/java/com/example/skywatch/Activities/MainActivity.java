package com.example.skywatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skywatch.Adapters.HourlyAdapters;
import com.example.skywatch.Domains.Hourly;
import com.example.skywatch.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView n7dayBtn = findViewById(R.id.nextBtn);
        n7dayBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",30,"sunny"));
        items.add(new Hourly("12 am",27,"wind"));
        items.add(new Hourly("1 am",25,"rainy"));
        items.add(new Hourly("2 am",28,"storm"));
        items.add(new Hourly("3 am",23,"storm"));
        items.add(new Hourly("4 am",25,"rainy"));
        items.add(new Hourly("5 am",26,"wind"));
        items.add(new Hourly("6 am",27,"rainy"));
        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
}