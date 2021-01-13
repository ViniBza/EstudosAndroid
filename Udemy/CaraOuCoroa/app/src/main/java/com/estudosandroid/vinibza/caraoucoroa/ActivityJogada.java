package com.estudosandroid.vinibza.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActivityJogada extends AppCompatActivity {

    private Button voltar;
    private ImageView moedaResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogada);
        voltar = findViewById(R.id.btnVoltar);
        moedaResultado = findViewById(R.id.imgMoeda);

        Bundle recuperarNumero = getIntent().getExtras();
        int numero = recuperarNumero.getInt("numeroRando");

        // Escolha Vencedora
        if (numero == 0 ){
            moedaResultado.setImageResource(R.drawable.moeda_cara);
        }
        // Escolha Coroa Vencedora
        else{
            moedaResultado.setImageResource(R.drawable.moeda_coroa);
        }
    }

//Voltar ao início do jogo
    public void voltarJogo(View view){
        finish();
    }


}