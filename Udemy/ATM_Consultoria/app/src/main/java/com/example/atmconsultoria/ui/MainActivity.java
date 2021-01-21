package com.example.atmconsultoria.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.atmconsultoria.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Barra superior
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Botão flutuante de email
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 enviarEmail();

            }
        });

        // Drawer toda a tela
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

       // Configura os botões de navegações
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato,   R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        NavigationUI.setupWithNavController(navigationView, navController);
    }

// Método de enviar email
    public void enviarEmail(){

        // Definimos uma ação de share, compartilhamento
        Intent intent = new Intent( Intent.ACTION_SEND);


        // Definindo o email, podendo inserir mais de 1
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});

        //Definindo o assunto do email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato via App - ATM Consultoria");

        // Definindo a mensagem padrão do conteúdo do email
        intent.putExtra(Intent.EXTRA_TEXT,  " Insira sua mensagem aqui.  :) ");


        // Definindo o tipo de dado que vai ser compartilhado com base no mime type
        intent.setType("message/rfc22");


        //CreateChoose escolhe apartir da intent os app que podem atender a intent
        startActivity( Intent.createChooser(intent, "Compartilhar") );


    }


// Método que chama as opções de menu
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}