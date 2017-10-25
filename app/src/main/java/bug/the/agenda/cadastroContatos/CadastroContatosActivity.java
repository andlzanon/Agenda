package bug.the.agenda.cadastroContatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import bug.the.agenda.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroContatosActivity extends AppCompatActivity implements CadastroContatosView {

    CadastroContatosPresenter cadastroContatosPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);
        ButterKnife.bind( this );
        cadastroContatosPresenter = new CadastroContatosPresenter(this, this);
    }

    @OnClick (R.id.button_cadastrar)
    public void fazCadastro (){
        Toast toast = Toast. makeText(CadastroContatosActivity.this, "Cadastro realizado", Toast.LENGTH_LONG);
        toast.show();
    }

    @OnClick (R.id.button_abrirCamera)
    public void abreCamera (){
        cadastroContatosPresenter.intentCamera();
    }

    @OnClick (R.id.button_abrirMapa)
    public void abreMapa (){
        cadastroContatosPresenter.intentMapa();
    }
}
