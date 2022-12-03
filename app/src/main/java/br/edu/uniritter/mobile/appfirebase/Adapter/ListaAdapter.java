package br.edu.uniritter.mobile.appfirebase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.appfirebase.Listas;
import br.edu.uniritter.mobile.appfirebase.R;


public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.MyViewHolder>{

    Context context;
    ArrayList<Listas> listas;

    public ListaAdapter(Context context) {
        this.context = context;
        this.listas = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(context).inflate(R.layout.lista_item, parent, false);

       return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ListaAdapter.MyViewHolder holder, int position) {

        Listas lista = listas.get(position);

        holder.nome.setText(lista.nome);
        holder.ingredientes.setText(lista.ingredientes);

    }

    @Override
    public int getItemCount(){
        return listas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome, ingredientes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nomelista);
            ingredientes = itemView.findViewById(R.id.itenslista);
        }
    }
    public void addItem(Listas lista){
        listas.add(lista);
        this.notifyDataSetChanged();
    }
}
