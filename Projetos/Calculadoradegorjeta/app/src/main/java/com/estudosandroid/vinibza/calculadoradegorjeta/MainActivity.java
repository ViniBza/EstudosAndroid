package com.estudosandroid.vinibza.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private TextView textoSeek;
    private SeekBar seekPorcentagem;
    private TextView textoGorjeta, textoTotal;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor      = findViewById(R.id.txtInputValor);
        textoSeek       = findViewById(R.id.txtSeek);
        seekPorcentagem = findViewById(R.id.seekEscala);
        textoGorjeta    = findViewById(R.id.txtGorjeta);
        textoTotal      = findViewById(R.id.txtValorTotal);



        seekPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            porcentagem = progress;
            textoSeek.setText("%" + Math.round(porcentagem));
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void calcular (){
        Double valorDigitado, varGorjeta, totalPreco;
        String valorRecuperado = editValor.getText().toString();

        if ( valorRecuperado == null || valorRecuperado.equals("") ){
            Toast.makeText(getApplicationContext(),
                    "Por favor, digite um valor primeiro.",
                    Toast.LENGTH_SHORT).show();
        } else {
            valorDigitado = Double.parseDouble(valorRecuperado);
            varGorjeta = valorDigitado * ( porcentagem / 100 );
            totalPreco = valorDigitado + varGorjeta;
            textoGorjeta.setText("R$: " + Math.round(varGorjeta));
            textoTotal.setText("R$: " + totalPreco.toString());
        }
    }
}