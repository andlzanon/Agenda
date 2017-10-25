package bug.the.agenda.cadastroContatos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import static bug.the.agenda.R.string.endereco;

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
            context.startActivity(intentCamera);
        }else {
            Toast toast = Toast. makeText(context, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void intentMapa() {
        Intent intentMapa = new Intent(Intent. ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
        if(intentMapa.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intentMapa);
        }else {
            Toast toast = Toast. makeText(context, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
