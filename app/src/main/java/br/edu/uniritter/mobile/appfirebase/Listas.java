package br.edu.uniritter.mobile.appfirebase;

import com.google.firebase.database.DatabaseReference;

public class Listas {
    public String nome;
    public String ingredientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes(){
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

}
