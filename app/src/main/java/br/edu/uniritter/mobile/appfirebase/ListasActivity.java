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

import br.edu.uniritter.mobile.appfirebase.Adapter.ListaAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
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

    RecyclerView recyclerView;
    ListaAdapter myAdapter;
    FirebaseFirestore db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        myAdapter = new ListaAdapter(ListasActivity.this);

        recyclerView.setAdapter(myAdapter);

        EventChangeListener();
    }

    private void EventChangeListener(){

        db.collection("listas").orderBy("nome", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>(){

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(error != null){

                    Log.e("Firestore error", error.getMessage());
                    return;
                }

                for (DocumentChange dc : value.getDocumentChanges()){
                    if (dc.getType() == DocumentChange.Type.ADDED){

                        myAdapter.addItem(dc.getDocument().toObject(Listas.class));
                    }

                    myAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    public void abrir_add_lista(View v){
        Intent it_add_lista = new Intent(this,AddListaActivity.class);
        startActivity(it_add_lista);
    }

    public void voltar_inicio(View v){
        Intent it_perfil = new Intent(this, InicioActivity.class);
        startActivity(it_perfil);
    }

}