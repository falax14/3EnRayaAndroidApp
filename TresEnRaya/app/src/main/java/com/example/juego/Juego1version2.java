package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Juego1version2 extends AppCompatActivity {

    private final List<int[]> listacombinatoria = new ArrayList<>();

    private int [] posicionimagenes = {0,0,0,0,0,0,0,0,0};

    private int turnojugador = 1;

    private int totaldeimagenesselecionadas = 1;

    Button b;
    TextView nombrejugador1, nombrejugador2;
    LinearLayout layoutjugador1, layoutjugador2;
    ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9;
    final MediaPlayer[] mediaPlayer = {null};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego1version2);

        b=findViewById(R.id.buttonRetroceso);

        nombrejugador1 = findViewById(R.id.textojug1);
        nombrejugador2 = findViewById(R.id.textojug2);

        layoutjugador1 = findViewById(R.id.jugador1layout);
        layoutjugador2 = findViewById(R.id.jugador2layout);

        im1 = findViewById(R.id.imageView1);
        im2 = findViewById(R.id.imageView2);
        im3 = findViewById(R.id.imageView3);
        im4 = findViewById(R.id.imageView4);
        im5 = findViewById(R.id.imageView5);
        im6 = findViewById(R.id.imageView6);
        im7 = findViewById(R.id.imageView7);
        im8 = findViewById(R.id.imageView8);
        im9 = findViewById(R.id.imageView9);

        listacombinatoria.add(new int[]{0, 1, 2});
        listacombinatoria.add(new int[]{3, 4, 5});
        listacombinatoria.add(new int[]{6, 7, 8});
        listacombinatoria.add(new int[]{0, 3, 6});
        listacombinatoria.add(new int[]{1, 4, 7});
        listacombinatoria.add(new int[]{2, 5, 8});
        listacombinatoria.add(new int[]{2, 4, 6});
        listacombinatoria.add(new int[]{0, 4, 8});

        String getnombrejugador1 = getIntent().getStringExtra("Jugador 1"); // se pone el mismo nombre que el que hemos puesto en el intent.putExtra del ejercicio elecciony
        String getnombrejugador2 = getIntent().getStringExtra("Jugador 2"); // se pone el mismo nombre que el que hemos puesto en el intent.putExtra del ejercicio elecciony

        nombrejugador1.setText(getnombrejugador1);
        nombrejugador2.setText(getnombrejugador2);



        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(0)){

                    realizarunaaccion((ImageView) view, 0);

                }

            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(1)){

                    realizarunaaccion((ImageView) view, 1);

                }


            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(2)){

                    realizarunaaccion((ImageView) view, 2);

                }

            }
        });

        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(3)){

                    realizarunaaccion((ImageView) view, 3);

                }

            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(4)){

                    realizarunaaccion((ImageView) view, 4);

                }

            }
        });

        im6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(5)){

                    realizarunaaccion((ImageView) view, 5);

                }

            }
        });

        im7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(6)){

                    realizarunaaccion((ImageView) view, 6);

                }

            }
        });

        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(7)){

                    realizarunaaccion((ImageView) view, 7);

                }

            }
        });

        im9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estalaimagenselecionada(8)){

                    realizarunaaccion((ImageView) view, 8);

                }

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Juego1version2.this, elecciony.class));
            }
        });

    }

    private void realizarunaaccion(ImageView imageView, int posiciondeimagenselecionada){

        posicionimagenes[posiciondeimagenselecionada] = turnojugador;

        if(turnojugador == 1){

            imageView.setImageResource(R.drawable.aspa);

            if(chequearsijugadorgana()){

                mensajevictoria mensajevictoria = new mensajevictoria(Juego1version2.this, nombrejugador1.getText().toString() + " ¡¡HA GANADO!!", Juego1version2.this);
                mensajevictoria.setCancelable(false);
                mensajevictoria.show();

            }

            else if(totaldeimagenesselecionadas == 9){

                mensajevictoria mensajevictoria = new mensajevictoria(Juego1version2.this, "¡¡EMPATE!!", Juego1version2.this);
                mensajevictoria.setCancelable(false);
                mensajevictoria.show();

            }
            else{

                cambiarelturnodeljugador(2);

                totaldeimagenesselecionadas++;

            }



        }
        else{
            imageView.setImageResource(R.drawable.circulo2);

            if(chequearsijugadorgana()){

                mensajevictoria mensajevictoria = new mensajevictoria(Juego1version2.this, nombrejugador2.getText().toString() + " ¡¡HA GANADO!!", Juego1version2.this);
                mensajevictoria.setCancelable(false);
                mensajevictoria.show();

            }
            else if(posiciondeimagenselecionada == 9){

                mensajevictoria mensajevictoria = new mensajevictoria(Juego1version2.this, "¡¡EMPATE!!", Juego1version2.this);
                mensajevictoria.setCancelable(false);
                mensajevictoria.show();

            }

            else{

                cambiarelturnodeljugador(1);

                totaldeimagenesselecionadas++;

            }


        }

    }


    private void cambiarelturnodeljugador(int turnodeljugadoractual){

        turnojugador = turnodeljugadoractual;

        /*
        if(turnojugador == 1){
            layoutjugador1.setBackgroundResource(R.drawable.fondodelimagenview);
            layoutjugador2.setBackgroundResource(R.drawable.fondodelimagenview);
        }
        else{
            layoutjugador2.setBackgroundResource(R.drawable.fondodelimagenview);
            layoutjugador1.setBackgroundResource(R.drawable.fondodelimagenview);
        }
        */

    }


    private boolean chequearsijugadorgana(){

        boolean respuesta = false;

        for(int i=0; i<listacombinatoria.size(); i++){

            int[] combinacion = listacombinatoria.get(i);

            if(posicionimagenes[combinacion[0]] == turnojugador && posicionimagenes[combinacion[1]] == turnojugador && posicionimagenes[combinacion[2]]==turnojugador){
                respuesta = true;
            }

        }

        return respuesta;

    }

    private boolean estalaimagenselecionada(int posiciondelaimagen){

        boolean respuesta = false;

        if(posicionimagenes[posiciondelaimagen]==0){

            respuesta = true;
        }
        return respuesta;

    }

    public void reiniciarPartida(){

        posicionimagenes = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        turnojugador = 1;

        totaldeimagenesselecionadas = 1;

        im1.setImageResource(R.drawable.fondodelimagenview);
        im2.setImageResource(R.drawable.fondodelimagenview);
        im3.setImageResource(R.drawable.fondodelimagenview);
        im4.setImageResource(R.drawable.fondodelimagenview);
        im5.setImageResource(R.drawable.fondodelimagenview);
        im6.setImageResource(R.drawable.fondodelimagenview);
        im7.setImageResource(R.drawable.fondodelimagenview);
        im8.setImageResource(R.drawable.fondodelimagenview);
        im9.setImageResource(R.drawable.fondodelimagenview);


    }



}
