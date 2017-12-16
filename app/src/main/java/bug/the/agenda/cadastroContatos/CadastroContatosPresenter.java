package bug.the.agenda.cadastroContatos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;

import bug.the.agenda.Entity.Contato;
import bug.the.agenda.R;

/**
 * Created by Andre on 25/10/2017.
 */

public class CadastroContatosPresenter {

    CadastroContatosView cadastroContatosView;
    Context context;

    public CadastroContatosPresenter(CadastroContatosView cadastroContatoView, Context context){
        this.cadastroContatosView = cadastroContatoView;
        this.context = context;
    }

    public void intentCamera() {
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(context.getPackageManager()) != null) {
            cadastroContatosView.startIntentCamera(intentCamera);
        }else {
            Toast toast = Toast. makeText(context, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void intentMapa(String endereco) {
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        if(TextUtils.isEmpty(endereco)){
            cadastroContatosView.erroMapa();
        }
        else{
            intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
            if(intentMapa.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intentMapa);
            }else {
                Toast toast = Toast. makeText(context, "Impossível abrir o recurso", Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

    public void cadastro(String nome, String endereco, String telefone, String email) {
        if (TextUtils.isEmpty(nome))
            cadastroContatosView.erroNome();
        else if (TextUtils.isEmpty(endereco))
            cadastroContatosView.erroEndereco();
        else if (TextUtils.isEmpty(telefone))
            cadastroContatosView.erroTel();
        else if(TextUtils.isEmpty(email))
            cadastroContatosView.erroEmail();
        else
            cadastroContatosView.cadastroComSucesso(nome, endereco, telefone, email);
    }

    public void verificaSeContatoENull(Contato contato){
        if(contato != null)
            cadastroContatosView.contatoNaoNull();
    }

    public boolean editouOuCadastrou(int itemId, Contato contato){
        if(itemId == R.id.buttonCadastro && contato == null){
            cadastroContatosView.tentaCadastro();
            return true;
        }

        else if(itemId == R.id.buttonCadastro && contato != null){
            cadastroContatosView.editouContatoPresenter();
            return true;
        }

        else
            return true;
    }
}
