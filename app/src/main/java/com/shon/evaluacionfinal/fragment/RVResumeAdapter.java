package com.shon.evaluacionfinal.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shon.evaluacionfinal.databinding.ItemShowResumeBinding;
import com.shon.evaluacionfinal.model.Simpsons;
import com.shon.evaluacionfinal.databinding.ItemShowResumeBinding;
import com.shon.evaluacionfinal.model.Simpsons;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class RVResumeAdapter  extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH> {
    private List<Simpsons> simpsons;


    public RVResumeAdapter(List<Simpsons> simpsons) {
        this.simpsons = simpsons;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(simpsons.get(position));
    }

    @Override
    public int getItemCount(){
        return simpsons.size();
    }



    class ResumeVH extends RecyclerView.ViewHolder{

        private ItemShowResumeBinding binding;
        public ResumeVH(ItemShowResumeBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Simpsons simpsons) {
            if(simpsons instanceof Simpsons){
                binding.txtTitle.setText(simpsons.getName());
                binding.txtFrase.setText(simpsons.getGenero());
            }

            ImageLoader imageLoader= Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(simpsons.getImagen())
                    .crossfade(true)
                    .target(binding.imgBanner)
                    .build();
            imageLoader.enqueue(request);

        }
    }
}