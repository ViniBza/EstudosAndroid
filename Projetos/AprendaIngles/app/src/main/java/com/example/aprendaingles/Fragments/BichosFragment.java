package com.example.aprendaingles.Fragments;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.aprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener{

    private ImageView btnCao, btnGato, btnLeao,
                        btnMacaco, btnOvelha, btnVaca;

    MediaPlayer mediaPlayer;
    public BichosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Acessando a view do fragments para capturar os elementos da tela
        View view = inflater.inflate(R.layout.fragment_bichos,
                container, false);

        btnCao    = view.findViewById(R.id.imgCao);
        btnGato   = view.findViewById(R.id.imgGato);
        btnLeao   = view.findViewById(R.id.imgLeao);
        btnMacaco = view.findViewById(R.id.imgMacaco);
        btnOvelha = view.findViewById(R.id.imgOvelha);
        btnVaca   = view.findViewById(R.id.imgVaca);


// Capturando os Ids dos elementos clicados para enviar para o OnClick
       btnCao.setOnClickListener(this);
       btnGato.setOnClickListener(this);
       btnLeao.setOnClickListener(this);
       btnMacaco.setOnClickListener(this);
       btnOvelha.setOnClickListener(this);
       btnVaca.setOnClickListener(this  );
        return view;
    }



//Capturando os elementos clicado
    @Override
    public void onClick(View v) {
     /* Informando no log os ids dos elementos clicados
        Log.i("Elemento clicado", "Item: " + getId());
      */


        switch (v.getId()) {
            case R.id.imgCao:
     //Capturando a Activiti principal com o get, não podemos usar o fragment direto
               mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
               tocarSom();
               break;


            case R.id.imgGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;


            case R.id.imgLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;


            case R.id.imgMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;


            case R.id.imgOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;


            case R.id.imgVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }



    public void tocarSom(){
        if ( mediaPlayer != null){
            mediaPlayer.start();

    // setOnCompletion podemos adicionar um evento quando a música terminar
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
    //após o usuário executar a música vamos sempre liberar os recursos
                    mediaPlayer.release();
                }
            });
        }
    }

  // Liberando espaços de memória
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.release(); // libera espaços de memória do android/recursos
            mediaPlayer = null; //libera espaço de memória do próprio mediaPlayer
        }
    }
}