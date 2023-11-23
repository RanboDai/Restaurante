package com.example.appderestaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class inicio extends AppCompatActivity {

    private AppCompatButton button;
    private AppCompatButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        IniciarComponentesMa();
        IniciarComponentesMai();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inicio.this,perfil.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inicio.this,cadastro.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentesMa(){
        button = findViewById(R.id.button);
    }
    private void IniciarComponentesMai(){
        button2 = findViewById(R.id.button2);
    }
}