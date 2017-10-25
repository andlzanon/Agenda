package bug.the.agenda.adicionarContatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import bug.the.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaContatos extends AppCompatActivity implements ContatosView {

    @BindView(R.id.lst_contatos)
    ListView lstContatos;

    ContatosPresenter contatosPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        ButterKnife.bind(this);

        contatosPresenter = new ContatosPresenter(this);
    }

    @OnClick(R.id.fab)
    public void criaContato() {
        Intent abrirCadastroContatos = new Intent(ListaContatos.this, addContato.class);
        startActivityForResult(abrirCadastroContatos, 123 );
    }

    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        contatosPresenter.addContatoInList(requestCode, resultCode, data);
    }

    public void updateList (List<String> contatosList) {
        ArrayAdapter<String> contatosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatosList);
        lstContatos.setAdapter(contatosAdapter);
    }

}
