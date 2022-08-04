package com.dilarabkr.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.dilarabkr.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        ConstraintLayout view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        //data
        Landmark pisa = new Landmark("Pisa", "Italy",R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.colosseum);
        Landmark mTower = new Landmark("Maiden's Tower","Turkey",R.drawable.kizkulesi);


        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(mTower);

        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(this)); //nasıl sıralanmasını istiyoruz
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.RecyclerView.setAdapter(landmarkAdapter);



/*
        //adapter: veri kaynağımızla XML'i ve listViewı birbirine bağlayan yapı
        //Listview: daha verimsiz

        //mapping: dönüştürmede kullanıyoruz. biz landmark arraylist içindeki yapıyı sadece isimlere dönüştürmek için kullanacağız
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landmarkArrayList.get(i).name,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("Landmark",landmarkArrayList.get(i));
                startActivity(intent);

            }
        });
*/

    }
}