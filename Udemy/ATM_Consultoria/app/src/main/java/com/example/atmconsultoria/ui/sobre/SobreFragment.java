package com.example.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    String descricao = "A ATM consultoria tem como missão apoiar organizações que desejam alcançar "+
            "o sucesso através da excelência em gestão e da busca pela qualidade.";

    //Definindo a versão do app
        Element versao =  new Element();
        versao.setTitle("Versão 1.0");

// Atribuindo a view paginaSobre com a biblioteca aboutPage e acessando o fragmento com o getActivity
        View paginaSobre = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@Atmconsultoria.com.br" ,
                          "Envie um email")
                .addWebsite("","Acesse nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("vinibza", "Facebook")
                .addInstagram("vinibza", "Instagram")
                .addGitHub("vinibza", "Github")
                .addPlayStore("com.facebook.katana", "Download APP")

                .addItem(versao)

                .create();

        return paginaSobre;

       // return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}