package br.edu.uniritter.mobile.appfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Button button = findViewById(R.id.sharebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Te convido ao meu churrasco! Baixe o app em 'playstore.com/listaodoracha' ");
                intent.setType("text/plain");

                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.verlistas).setOnClickListener((view)->{
            Intent intent = new Intent(this, ListasActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.addlista).setOnClickListener((view)->{
            Intent intent = new Intent(this, AddListaActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.listapresenca).setOnClickListener((view)->{
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);
        });
    }

}