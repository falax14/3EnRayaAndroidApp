package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class elecciony extends AppCompatActivity {

    //ImageButton ib;
    EditText ed1, ed2;
    Button b, b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleciony);

        ed1 = findViewById(R.id.edittext1);
        ed2 = findViewById(R.id.edittext2);
        b = findViewById(R.id.button15);
        b1 = findViewById(R.id.buttonRetroceso1);
        //ib = findViewById(R.id.imageButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String primernombre = ed1.getText().toString();
                final String segundonombre = ed2.getText().toString();

                if(primernombre.isEmpty() || segundonombre.isEmpty()){

                    Toast.makeText(elecciony.this, "Por favor ingresa un nombre para los jugadores", Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(elecciony.this, Juego1version2.class);
                    intent.putExtra("Jugador 1", primernombre);
                    intent.putExtra("Jugador 2", segundonombre);
                    startActivity(intent);
                }


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(elecciony.this, juegoplantilla.class));
            }
        });

    }



}