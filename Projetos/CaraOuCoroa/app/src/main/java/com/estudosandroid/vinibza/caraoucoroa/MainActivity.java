package com.estudosandroid.vinibza.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogar = findViewById(R.id.btnJogar);
    }

    public void iniciarJogo(View view){
        Intent intentJogada = new Intent(getApplicationContext(),
                ActivityJogada.class);
        // gerar número randomico
        int numero = new Random().nextInt(2);

        intentJogada.putExtra("numeroRando", numero);
        startActivity(intentJogada);
    }
}