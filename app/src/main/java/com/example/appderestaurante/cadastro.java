package com.example.appderestaurante;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class cadastro extends AppCompatActivity {

    private EditText cadasNome, cadasEmail, cadasSenha, cadasSenha2;
    String[] mensagens = {"Preencha todos os campos", "Cadastro realizado com sucesso"};
    String usuarioID;
    private TextView textFacaLogin;
    private ImageView irMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        IniciarComponentesCad();
        IniciarComponentesCada();
        IniciarComponentesCadas();

        textFacaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cadastro.this,perfil.class);
                startActivity(intent);
            }
        });

        irMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = cadasNome.getText().toString();
                String email = cadasEmail.getText().toString();
                String senha = cadasSenha.getText().toString();
                String senha2 = cadasSenha2.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || senha2.isEmpty()){
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    CadastrarUsuario(view);
                }

//             Intent intent = new Intent(cadastro.this,MainActivity.class);
//                startActivity(intent);
            }
        });
    }

    private void CadastrarUsuario(View view){
        String email = cadasEmail.getText().toString();
        String senha = cadasSenha.getText().toString();
        String senha2 = cadasSenha2.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword (email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    SalvarDadosUsuario();

                    Snackbar snackbar = Snackbar.make(view,mensagens[1],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    String erro;
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e){
                        erro = "Digite uma senha com no MÍNIMO 6 caracteres";
                    }catch (FirebaseAuthUserCollisionException e){
                        erro = "Esta conta JÁ FOI cadastrada";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erro = "E-mail INVÁLIDO";
                    }catch (Exception e){
                        erro = "Erro ao cadastrar usuário";
                    }

                    Snackbar snackbar = Snackbar.make(view,erro,Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }
    private void SalvarDadosUsuario(){
        String nome = cadasNome.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map <String,Object> usuarios = new HashMap<>();
        usuarios.put("nome", nome);

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(usuarioID);
        documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d("db","Sucesso ao salvar os dados");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_erro","Erro ao salvar os dados" + e.toString());
                    }
                });
    }

    private void IniciarComponentesCad(){ textFacaLogin = findViewById(R.id.textFacaLogin);}
    private void IniciarComponentesCada(){ irMain = findViewById(R.id.irMain);}
    private void IniciarComponentesCadas(){
        cadasNome = findViewById(R.id.cadasNome);
        cadasEmail = findViewById(R.id.cadasEmail);
        cadasSenha = findViewById(R.id.cadasSenha);
        cadasSenha2 = findViewById(R.id.cadasSenha2);

    }
}
