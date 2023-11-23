/*package com.example.appderestaurante;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private EditText logEmail, logSenha;
    private ProgressBar bar;

    String[] mensagens = {"Preencha todos os campos", "Login efetuado com sucesso"};
    private TextView textCadastreSe;
    private ImageView irLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        IniciarComponentesLog();
        IniciarComponentesLogi();
        IniciarComponentesLogin();

        textCadastreSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,cadastro.class);
                startActivity(intent);
            }
        });

        irLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = logEmail.getText().toString();
                String senha = logSenha.getText().toString();

                if (email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else {
                    AutenticarUsuario(view);
                }
            }
        });
    }
    private void AutenticarUsuario(View view){
        String email = logEmail.getText().toString();
        String senha = logSenha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    bar.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TelaPrincipal();
                        }
                    }, 3000);
                } else {
                    String erro;

                    try {
                        throw task.getException();
                    } catch (Exception e) {
                        erro = "Erro ao logar usuário";
                    }
                    Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if(usuarioAtual != null){
            TelaPrincipal();
        }
    }
    private void TelaPrincipal(){
        Intent intent = new Intent(login.this,perfil.class);
        startActivity(intent);
        finish();
    }
    private void IniciarComponentesLogin(){
        logEmail = findViewById(R.id.logEmail);
        logSenha = findViewById(R.id.logSenha);
        bar = findViewById(R.id.bar);
    }
    private void IniciarComponentesLog(){
        textCadastreSe = findViewById(R.id.textCadastreSe);
    }
    private void IniciarComponentesLogi(){
        irLista = findViewById(R.id.irLista);
    }
}

 */