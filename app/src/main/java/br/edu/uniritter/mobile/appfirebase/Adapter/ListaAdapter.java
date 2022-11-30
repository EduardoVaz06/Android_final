package br.edu.uniritter.mobile.appfirebase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.uniritter.mobile.appfirebase.Listas;
import br.edu.uniritter.mobile.appfirebase.Adapter.ListaViewHolder;
import br.edu.uniritter.mobile.appfirebase.R;

public class ListaAdapter extends RecyclerView.Adapter<ListaViewHolder>{

    private Context context;
    private ArrayList<Listas> listas;

    public ListaAdapter(Context context, ArrayList<Listas> listas) {
        this.context = context;
        this.listas = listas;
    }

    @NonNull
    @Override
    public ListaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_item, parent, false);
        ListaViewHolder viewHolder = new ListaViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ListaViewHolder ListaViewHolder, int position) {
        Listas lista = listas.get(position);
        ListaViewHolder.nome.setText(lista.getNome());
        //onclick listener
    }

    @Override
    public int getItemCount() {
        return listas.size();
    }
}
