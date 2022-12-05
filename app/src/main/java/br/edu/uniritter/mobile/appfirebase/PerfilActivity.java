package br.edu.uniritter.mobile.appfirebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;


import br.edu.uniritter.mobile.appfirebase.Adapter.MyAdapter;

public class PerfilActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        myAdapter = new MyAdapter(PerfilActivity.this);

        recyclerView.setAdapter(myAdapter);

        EventChangeListener();
    }

    private void EventChangeListener() {

        db.collection("Users").orderBy("firstName", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(error != null){

                    Log.e("Firestore error", error.getMessage());
                    return;
                }

                for (DocumentChange dc : value.getDocumentChanges()){
                    if (dc.getType() == DocumentChange.Type.ADDED){

                        myAdapter.addItem(dc.getDocument().toObject(User.class));
                    }
                }
            }
        });
    }

    public void voltar_inicio(View v){
        Intent it_perfil = new Intent(this, InicioActivity.class);
        startActivity(it_perfil);
    }
}