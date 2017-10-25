package bug.the.agenda;

import android.graphics.Bitmap;

/**
 * Created by Andre on 25/10/2017.
 */

public class Contato {
    private Bitmap fotoPerfil;
    private String nome;
    private String endereco;
    private String telefone;

    public Contato(Bitmap bitmap, String nome, String endereco, String telefone){
        this.fotoPerfil = bitmap;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Bitmap getFotoPerfil() {
        return fotoPerfil;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }
}
