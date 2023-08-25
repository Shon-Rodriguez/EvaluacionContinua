package com.shon.evaluacionfinal.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shon.evaluacionfinal.databinding.ItemShowmenuBinding;
import com.shon.evaluacionfinal.model.Shows;

import java.util.List;

public class RVShowAdapter extends RecyclerView.Adapter<RVShowAdapter.ShowViewHolder> {
    private List<Shows> shows;

    public RVShowAdapter(List<Shows> shows) {
        this.shows = shows;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowmenuBinding binding = ItemShowmenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.bind(shows.get(position));
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder{

        private ItemShowmenuBinding binding;
        public ShowViewHolder(@NonNull ItemShowmenuBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Shows shows) {
            binding.titulo.setText(shows.getName());
            binding.titulo2.setText(shows.getGenero());
            Glide.with(itemView.getContext())
                    .load(shows.getImagen())
                    .into(binding.imagen);
        }
    }

}
