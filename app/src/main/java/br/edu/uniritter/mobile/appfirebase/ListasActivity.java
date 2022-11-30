package br.edu.uniritter.mobile.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class ListasActivity extends AppCompatActivity {
    private final String TAG = "ListasActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //mapeando uma lista de ingredientes

        //Map<Integer, Ingrediente> lista = new HashMap<>();
        //lista.put(l.getId(). l):
        //lista.get(12) indice 12

        //mapeando uma lista de ingredientes

        //Map<String, Object> lista = new HashMap<>();
        //lista.put("nome", "Eduardo");
        //lista.put("ingredientes", "Banana");
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
}