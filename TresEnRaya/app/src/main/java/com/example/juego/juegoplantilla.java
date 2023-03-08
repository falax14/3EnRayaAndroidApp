package com.example.juego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class juegoplantilla extends AppCompatActivity {

    /*
    Button b;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juegoplantilla);

       /* b = findViewById(R.id.button);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);
        b3 = findViewById(R.id.button4);
        b4= findViewById(R.id.button5);
        */

    }


        public void presionaratras(View view) {
            startActivity(new Intent(juegoplantilla.this, MainActivity.class));
        }

        public void presionarprimerjuego(View view) {
        startActivity(new Intent(juegoplantilla.this, elecciony.class));
        }


}
