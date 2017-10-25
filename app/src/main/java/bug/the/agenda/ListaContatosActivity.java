package bug.the.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bug.the.agenda.cadastroContatos.CadastroContatosActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaContatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void criaContato() {
        Intent abrirCadastroContatos = new Intent(ListaContatosActivity.this, CadastroContatosActivity.class);
        startActivity(abrirCadastroContatos);
    }

}
