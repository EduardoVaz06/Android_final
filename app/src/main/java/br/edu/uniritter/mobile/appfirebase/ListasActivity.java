package br.edu.uniritter.mobile.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.uniritter.mobile.appfirebase.Adapter.ListaAdapter;

public class ListasActivity extends AppCompatActivity {
    private final String TAG = "ListasActivity";
    private RecyclerView recycler;
    private ListaAdapter adapter;
    private ArrayList<Listas> listas;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        recycler = findViewById(R.id.recycler);

        listas = new ArrayList<Listas>();
        //listas.add(new Listas("Eduardo", "Banana, maça"));
        //listas.add(new Listas("Jean", "Arroz, feijao"));
        listas.add(new Listas("Jean"));
        listas.add(new Listas("Eduardo"));
        listas.add(new Listas("Fulano"));

        adapter = new ListaAdapter(ListasActivity.this, listas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListasActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);


        //mapeando uma lista de ingredientes

        //Map<Integer, Ingrediente> lista = new HashMap<>();
        //lista.put(l.getId(). l):
        //lista.get(12) indice 12

        //mapeando uma lista de ingredientes

       // Map<String, Object> lista = new HashMap<>();
        //lista.put("nome", "Fulano");
       // lista.put("ingredientes", "Arroz, Feijao");
        //db.collection("listas").add(lista);

        db.collection("listas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                Log.d(TAG, "onComplete: "+task.getResult());
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }

        });

    }
    public void abrir_add_lista(View v){
        Intent it_add_lista = new Intent(this,AddListaActivity.class);
        startActivity(it_add_lista);
    }

    public void abrir_perfil(View v){
        Intent it_perfil = new Intent(this, PerfilActivity.class);
        startActivity(it_perfil);
    }
}