package com.example.juego;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

    public class mensajevictoria extends Dialog {
        TextView textovictoria;
        Button botonreinicio;

        private final String mensaje;
        private final Juego1version2 juego1version2;


        public mensajevictoria(@NonNull Context context, String mensaje, Juego1version2 juego1version2) {
            super(context);
            this.mensaje=mensaje;
            this.juego1version2=juego1version2;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialogodevictoria);

            textovictoria = findViewById(R.id.textodialogovictoria);
            botonreinicio = findViewById(R.id.botonreinicio);

            textovictoria.setText(mensaje);

            botonreinicio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    juego1version2.reiniciarPartida();
                    dismiss();

                }
            });
        }
    }
