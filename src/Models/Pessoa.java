package Models;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
  
    public Pessoa(){
    }
    
    private String nome;
    private String id;
    
    public Pessoa(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome=" + nome + ", id=" + id;
    }
}
