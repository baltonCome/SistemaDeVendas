package Models;

import java.io.Serializable;

public class Gestor extends Pessoa implements Serializable{
    
    private String perfil;
    private String senha;
    
    public Gestor(){      
    }

    public Gestor(String perfil, String senha, String nome, String id) {
        super(nome, id);
        this.perfil = perfil;
        this.senha = senha;
    }
    
    public void setPerfil(String perfil){
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getPerfil(){
        return perfil;
    }

    @Override
    public String toString() {
        return "perfil=" + perfil + ", senha=" + senha +","+ super.toString()+"\n";
    }
}
