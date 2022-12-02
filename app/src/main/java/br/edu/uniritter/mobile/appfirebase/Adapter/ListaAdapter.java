package br.edu.uniritter.mobile.appfirebase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.appfirebase.Listas;
import br.edu.uniritter.mobile.appfirebase.R;


public class ListaAdapter extends RecyclerView.Adapter{

    List<Listas> listas;

    public ListaAdapter(List<Listas> listas) {
        this.listas = listas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
       ViewHolderClass vhClass = new ViewHolderClass(view);
       return vhClass;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass vhClass = (ViewHolderClass) holder;
        Listas lista = listas.get(position);
        vhClass.nomelista.setText(lista.getNome());
        vhClass.itenslista.setText(lista.getItens());

    }

    @Override
    public int getItemCount(){
        return listas.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView nomelista;
        TextView itenslista;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            nomelista = itemView.findViewById(R.id.nomelista);
            itenslista = itemView.findViewById(R.id.itenslista);
        }
    }
}
