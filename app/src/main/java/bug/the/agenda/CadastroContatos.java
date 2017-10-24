package bug.the.agenda;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static bug.the.agenda.R.string.endereco;

public class CadastroContatos extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);
        ButterKnife.bind( this );
    }

    @OnClick (R.id.button_cadastrar)
    public void fazCadastro (){
        Toast toast = Toast. makeText(CadastroContatos.this, "Cadastro realizado", Toast.LENGTH_LONG);
        toast.show();
    }

    @OnClick (R.id.button_abrirCamera)
    public void abreCamera (){
        Intent intentCamera = new Intent(MediaStore. ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(getPackageManager()) != null) {
            startActivity(intentCamera);
        }else {
            Toast toast = Toast. makeText(CadastroContatos.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @OnClick (R.id.button_abrirMapa)
    public void abreMapa (){
        Intent intentMapa = new Intent(Intent. ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
        if(intentMapa.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMapa);
        }else {
            Toast toast = Toast. makeText(CadastroContatos.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
