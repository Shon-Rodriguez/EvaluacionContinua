package com.shon.evaluacionfinal.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.shon.evaluacionfinal.data.response.ShowResponse;
import com.shon.evaluacionfinal.data.retrofit.RetrofitHelper;
import com.shon.evaluacionfinal.databinding.FragmentHomeBinding;
import com.shon.evaluacionfinal.model.Simpsons;
import com.shon.evaluacionfinal.model.Shows;
import com.shon.evaluacionfinal.data.response.ShowResponse;
import com.shon.evaluacionfinal.model.Shows;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.banners.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL,false);
        binding.banners.setLayoutManager(layoutManager);

        RetrofitHelper.getService().getShows().enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    showMenus(response.body().getShowsList());
                }
            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

            }
        });
    }




    private void showMenus(List<Shows> showModelList) {
        RVShowAdapter adapter = new RVShowAdapter(showModelList);
        binding.show.setAdapter(adapter);
    }
        private List<Simpsons> getData(){
            List<Simpsons>simpsons = new ArrayList<>();
            simpsons.add(new Simpsons("", "", "https://ntvb.tmsimg.com/assets/p18722572_b_h8_ak.jpg?w=960&h=540"));
            simpsons.add(new Simpsons("", "", "https://variety.com/wp-content/uploads/2023/02/TheSimpsons_S32_4x3_21-lcr-res.jpg?w=1000"));
            simpsons.add(new Simpsons("", "", "https://imagenes.20minutos.es/files/image_990_v3/uploads/imagenes/2020/04/17/los-simpson.jpeg"));
            simpsons.add(new Simpsons("", "", "https://fotografias.larazon.es/clipping/cmsimages02/2018/09/07/387C6BA2-E1E0-43DB-B326-31CE9A1DCB8F/98.jpg?crop=1280,720,x0,y0&width=1900&height=1069&optimize=low&format=webply"));


            return simpsons;
        }
}