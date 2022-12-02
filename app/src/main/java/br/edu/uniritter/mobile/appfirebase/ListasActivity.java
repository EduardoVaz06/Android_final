package br.edu.uniritter.mobile.appfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import br.edu.uniritter.mobile.appfirebase.config.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.DocumentReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.uniritter.mobile.appfirebase.Adapter.ListaAdapter;

public class ListasActivity extends AppCompatActivity {
    private final String TAG = "ListasActivity";

    List<Listas> lists;
    RecyclerView recyclerView;
    ListaAdapter listaAdapter;
    DatabaseReference databaseReference;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lists = new ArrayList<>();
        databaseReference = ConfiguracaoFirebase.getFirebaseDatabase();
        databaseReference.child("listas").addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dn:snapshot.getChildren()){
                    Listas u = dn.getValue(Listas.class);
                    lists.add(u);
                }
                listaAdapter = new ListaAdapter(lists);
                recyclerView.setAdapter(listaAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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