package bug.the.agenda.adicionarContatos;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 24/10/2017.
 */

public class ContatosPresenter {
    ContatosView contatosView;
    List<String> contatosList = new ArrayList<>();

    public ContatosPresenter (ContatosView contatosView){
        this.contatosView = contatosView;
    }

    protected void addContatoInList ( int requestCode, int resultCode, Intent data){
        if (requestCode == 123 && resultCode == Activity.RESULT_OK){
            String contatoNome = data.getStringExtra( "contato_nome" );
        //adiciona novo item na lista
            contatosList.add(contatoNome);
            contatosView.updateList(contatosList);
        }
    }
}
