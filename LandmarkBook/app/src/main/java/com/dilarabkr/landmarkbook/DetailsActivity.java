package com.dilarabkr.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.dilarabkr.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        ConstraintLayout view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        //casting
        Landmark selected = (Landmark) intent.getSerializableExtra("Landmark");

        binding.nameText.setText(selected.name);
        binding.countryText.setText(selected.country);
        binding.imageView.setImageResource(selected.image);

    }
}