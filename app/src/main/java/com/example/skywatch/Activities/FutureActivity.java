package com.example.skywatch.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skywatch.Adapters.FutureAdapter;
import com.example.skywatch.Domains.FutureDomain;
import com.example.skywatch.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        ConstraintLayout backbtn = findViewById(R.id.backBtn);
        backbtn.setOnClickListener(view -> startActivity(new Intent(FutureActivity.this, MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();
        items.add(new FutureDomain("Sat", "storm", "Storm", 25, 12));
        items.add(new FutureDomain("Sun", "cloudy", "Cloudy", 24, 14));
        items.add(new FutureDomain("Mon", "windy", "Windy", 29, 15));
        items.add(new FutureDomain("Tue", "sunny", "Sunny", 25, 16));
        items.add(new FutureDomain("Wed", "cloudy_sunny", "Cloudy Sunny", 22, 13));
        items.add(new FutureDomain("Thu", "rainy", "Rainy", 28, 11));
        items.add(new FutureDomain("Fri", "windy", "Windy", 23, 13));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}