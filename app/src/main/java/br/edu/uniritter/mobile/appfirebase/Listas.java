package br.edu.uniritter.mobile.appfirebase;

import br.edu.uniritter.mobile.appfirebase.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class Listas {
    private String id;
    private String nome;
    private String itens;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getItens(){
        return itens;
    }

    public void setItens(String itens) { this.itens = itens; }

    public void salvarDados(){
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("listas").child(this.id).setValue(this);
    }
}
