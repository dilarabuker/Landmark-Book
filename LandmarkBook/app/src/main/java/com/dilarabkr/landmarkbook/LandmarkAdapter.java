package com.dilarabkr.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dilarabkr.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    } //XML'i bağlama işlemi burada yapılacak

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.recyclerText.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("Landmark", landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    } //ViweHolder sınıfı bağlandığında ne olacağını yazacağımız metod

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    } //XML'in kaç kere oluşturulacağını söyleyecek

    //görünümlerimizi tutan yardımcı sınıf
    //adapterı yazmamızın sebebi layoutla burdaki kodları birbirine bağlayıp kullanıcıya göstermek
    public class LandmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public LandmarkHolder(@NonNull RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
