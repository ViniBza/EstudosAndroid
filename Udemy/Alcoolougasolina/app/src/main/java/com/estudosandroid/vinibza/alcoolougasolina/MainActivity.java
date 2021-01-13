package com.estudosandroid.vinibza.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
//Componentes de tela
    private TextInputEditText editAlcool, editGasolina;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool    = findViewById(R.id.editAlcool);
        editGasolina  = findViewById(R.id.editGasolina);
        calcular  = findViewById(R.id.btnCalcular);
        resultado = findViewById(R.id.txtResultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        //Validar campos
        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados == true){
            // Converter String para Double
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultadoValores = valorAlcool / valorGasolina;

          if (resultadoValores >= 0.7){
              resultado.setText("A Gasolina é a melhor opção ");
             }else {
               resultado.setText("O Alcool é a melhor opção. "); }
        }else {
            resultado.setText("Por favor, insira o valor nos campos.");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){
         Boolean camposValidados = true;
         /*
         * Realizamos uma validação de null caso não conseguimos recuperar o valor que o usuario digitar
         * ou então não configurasemos o pAlcool por exemplo. E o Equal verifica se a condição é verdadeira
         * ou falsa, nesse caso se o campo estiver vazio.
         * */
         if (pAlcool == null || pAlcool.equals("")){
             camposValidados = false;
         }
         else if(pGasolina == null || pGasolina.equals("")){
             camposValidados = false;
         }
         return camposValidados;
    }

}