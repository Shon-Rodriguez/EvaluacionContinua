package com.shon.evaluacionfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shon.evaluacionfinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //private Button btnGetStarted; Activar el Binding en el build.gradle
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGetStarted.setOnClickListener(view ->{
            //Toast.makeText(this, "Comenzar", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();

        });

        //binding.txtMoviewPhrase.setText("Mira tu Pelicula \n Favorita");
        binding.txtMoviewPhrase.setText(R.string.get_started_title);
    }
}