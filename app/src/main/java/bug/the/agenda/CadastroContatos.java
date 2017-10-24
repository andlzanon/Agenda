package bug.the.agenda;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static bug.the.agenda.R.string.endereco;

public class CadastroContatos extends AppCompatActivity {

    Button botaoCadastrar;
    Button botaoAbrirCamera;
    Button botaoAbrirMapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);

        botaoCadastrar = (Button) findViewById(R.id.button_cadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast toast = Toast. makeText(CadastroContatos.this, "Cadastro realizado", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        botaoAbrirCamera = (Button) findViewById(R.id.button_abrirCamera);
        botaoAbrirCamera.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intentCamera = new Intent(MediaStore. ACTION_IMAGE_CAPTURE);
                if(intentCamera.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentCamera);
                }else {
                    Toast toast = Toast. makeText(CadastroContatos.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
                            toast.show();
                }
            }
        });

        botaoAbrirMapa = (Button) findViewById(R.id.button_abrirMapa);
        botaoAbrirMapa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intentMapa = new Intent(Intent. ACTION_VIEW);
                intentMapa.setData(Uri.parse("geo:0,0?q=" + endereco));
                if(intentMapa.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMapa);
                }else {
                    Toast toast = Toast. makeText(CadastroContatos.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
                            toast.show();
                }
            }
        });

    }
}
