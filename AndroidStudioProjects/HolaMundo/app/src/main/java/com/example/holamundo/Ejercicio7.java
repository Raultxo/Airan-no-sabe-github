package com.example.holamundo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio7 extends AppCompatActivity {

    private ImageView camara1, camara2, luz1, luz2, color;
    private boolean estadoCamara1 = false, estadoCamara2 = false, estadoLuz1 = false, estadoLuz2 = false;
    private EditText temperatura;
    private ImageView rojo1, rojo2, azul1, azul2, verde1, verde2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio7);

        camara1 = (ImageView) findViewById(R.id.camara1);
        camara2 = (ImageView) findViewById(R.id.camara2);
        luz1 = (ImageView) findViewById(R.id.luz1);
        luz2 = (ImageView) findViewById(R.id.luz2);
        temperatura = (EditText) findViewById(R.id.txtTemperatura);
        color = (ImageView) findViewById(R.id.color);
        rojo1 = (ImageView) findViewById(R.id.rgbRojo1);
        rojo2 = (ImageView) findViewById(R.id.rgbRojo2);
        azul1 = (ImageView) findViewById(R.id.rgbAzul1);
        azul2 = (ImageView) findViewById(R.id.rgbAzul2);
        verde1 = (ImageView) findViewById(R.id.rgbVerde1);
        verde1 = (ImageView) findViewById(R.id.rgbVerde2);

    }

    public void camara(View v) {
        if(v.equals(camara1)) {
           if(estadoCamara1) {
               camara1.setImageResource(R.drawable.camara_apagada);
               estadoCamara1 = false;
           }
           else {
               camara1.setImageResource(R.drawable.camara_encendida);
               estadoCamara1 = true;
           }
        }
        else {
            if(estadoCamara2) {
                camara2.setImageResource(R.drawable.camara_apagada);
                estadoCamara2 = false;
            }
            else {
                camara2.setImageResource(R.drawable.camara_encendida);
                estadoCamara2 = true;
            }
        }

    }

    public void luz(View v) {
        if(v.equals(luz1)) {
            if(estadoLuz1) {
                luz1.setImageResource(R.drawable.luz_apagada);
                luz1.setBackgroundColor(Color.WHITE);
                estadoLuz1 = false;
            }
            else {
                luz1.setImageResource(R.drawable.luz_encendida);
                estadoLuz1 = true;
            }
        }
        else {
            if(estadoLuz2) {
                luz2.setImageResource(R.drawable.luz_apagada);
                luz2.setBackgroundColor(Color.WHITE);
                estadoLuz2 = false;
            }
            else {
                luz2.setImageResource(R.drawable.luz_encendida);
                estadoLuz2 = true;
            }
        }

    }

    public void temperatura (View v) {
        if(Integer.parseInt(temperatura.getText().toString()) < 10) {
            color.setImageResource(R.drawable.azul);
        }
        else {
            if(Integer.parseInt(temperatura.getText().toString()) < 20) {
                color.setImageResource(R.drawable.verde);
            }
            else {
                if(Integer.parseInt(temperatura.getText().toString()) < 30) {
                    color.setImageResource(R.drawable.naranja);
                }
                else {
                    color.setImageResource(R.drawable.rojo);
                }
            }
        }
    }

    public void sumar(View v) {
        int valorActual = Integer.parseInt(temperatura.getText().toString());
        valorActual++;
        temperatura.setText("" + valorActual);
        temperatura(v);
    }

    public void restar(View v) {
        int valorActual = Integer.parseInt(temperatura.getText().toString());
        valorActual--;
        temperatura.setText("" + valorActual);
        temperatura(v);
    }

    public void cambiarColorLuz1(View v) {
        if(estadoLuz1) {
            if(v.equals(rojo1)) {
                luz1.setBackgroundColor(Color.RED);
            }
            else {
                if(v.equals(azul1)) {
                    luz1.setBackgroundColor(Color.BLUE);
                }
                else {
                    luz1.setBackgroundColor(Color.GREEN);
                }
            }
        }

    }

    public void cambiarColorLuz2(View v) {
        if(estadoLuz2) {
            if (v.equals(rojo2)) {
                luz2.setBackgroundColor(Color.RED);
            } else {
                if (v.equals(azul2)) {
                    luz2.setBackgroundColor(Color.BLUE);
                } else {
                    luz2.setBackgroundColor(Color.GREEN);
                }
            }
        }
    }



}
