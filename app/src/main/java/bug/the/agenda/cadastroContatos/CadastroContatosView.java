package bug.the.agenda.cadastroContatos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Andre on 25/10/2017.
 */

public interface CadastroContatosView{
    public void abreCamera ();
    public void abreMapa ();
    public void startIntentCamera(Intent intentCamera);
    public void contatoNaoNull();
    public void editouContato(Bitmap bitmap, String nome, String endereco, String telefone, String email);
    public void editouContatoPresenter();

    public void erroNome();
    public void erroMapa();
    public void erroTel();
    public void erroEndereco();
    public void erroEmail();
    public void tentaCadastro();

    public void cadastroComSucesso(String nome, String endereco, String telefone, String email);
}

