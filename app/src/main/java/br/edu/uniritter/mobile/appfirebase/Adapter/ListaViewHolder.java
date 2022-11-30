package br.edu.uniritter.mobile.appfirebase.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.uniritter.mobile.appfirebase.R;

public class ListaViewHolder extends RecyclerView.ViewHolder {

    TextView nome;

    public ListaViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.nome);
        //produto = itemView.findViewById(R.id.produto);
    }
}
