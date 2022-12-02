package br.edu.uniritter.mobile.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddListaActivity extends AppCompatActivity {
    private EditText edit_nome, edit_itens;
    private Button criar;
    String[] mensagens = {"Preencha todos os campos", "Lista criada"};
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lista);

        IniciarComponentes();

        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String itens = edit_itens.getText().toString();

                if(nome.isEmpty() || itens.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    CriarLista(v);
                    Intent intent = new Intent(AddListaActivity.this, ListasActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void CriarLista(View v){
        String nome = edit_nome.getText().toString();
        String itens = edit_itens.getText().toString();

        Map<String, Object> lista = new HashMap<>();
        lista.put("nome", nome);
        lista.put("ingredientes", itens);
        db.collection("listas").add(lista);

        Snackbar snackbar = Snackbar.make(v, mensagens[1],Snackbar.LENGTH_SHORT);

    }

    private void IniciarComponentes(){
        edit_nome = findViewById(R.id.edit_nome);
        edit_itens = findViewById(R.id.edit_itens);
        criar = findViewById(R.id.criar_lista);

    }


}