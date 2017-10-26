package bug.the.agenda.cadastroContatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Andre on 25/10/2017.
 */

public interface CadastroContatosView{
    public void abreCamera ();
    public void abreMapa ();
    public void startIntentCamera(Intent intentCamera);

    public void erroNome();
    public void erroMapa();
    public void erroTel();
}

