package bug.the.agenda.cadastroContatos;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import bug.the.agenda.Contato;
import bug.the.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;

public class CadastroContatosActivity extends AppCompatActivity implements CadastroContatosView {

    private static final int CAMERA_REQUEST = 1888;

    //lista de Contatos
    public static ArrayList<Contato> contatos = new ArrayList<>();

    //declaracao do presenter
    CadastroContatosPresenter cadastroContatosPresenter;

    //definicao da imagem de perfil redonda
    @BindView(R.id.imagemPerfil) de.hdodenhof.circleimageview.CircleImageView imagePerfil;

    //declaracao dos campos de nome
    @BindView(R.id.edit_text_nome) TextInputEditText textoNome;
    @BindView(R.id.text_input_layout_nome) TextInputLayout layoutNome;

    //declaracao dos campos de endereco
    @BindView(R.id.edit_text_endereco) TextInputEditText textoEndereco;
    @BindView(R.id.text_input_layout_endereco) TextInputLayout layoutEndereco;

    //declaracao dos campos de telefone
    @BindView(R.id.edit_text_telefone) TextInputEditText textoTelefone;
    @BindView(R.id.text_input_layout_telefone) TextInputLayout layoutTel;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);

        //cria a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adciona titulo e define o botao <- na toolbar
        getSupportActionBar().setTitle(R.string.novo_contato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ButterKnife.bind( this );
        cadastroContatosPresenter = new CadastroContatosPresenter(this, this);

        //seta imagem de perfil
        imagePerfil.setImageDrawable(getResources().getDrawable(R.drawable.ic_photo));
    }

    //coloca o texto de cadastrar na toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.buttonCadastro){
            //contatos.add(new Contato())
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //inicia intent da camera no Presenter
    @OnClick(R.id.imagemPerfil)
    public void abreCamera (){
        cadastroContatosPresenter.intentCamera();
    }

    //inicia intent do mapa no Presenter
    @OnClick(R.id.edit_text_endereco)
    public void abreMapa(){
        cadastroContatosPresenter.intentMapa(textoEndereco.getText().toString());
    }

    //presenter chama este método para inicio de intent coom resultado
    @Override
    public void startIntentCamera(Intent intentCamera) {
        startActivityForResult(intentCamera, CAMERA_REQUEST);
    }

    //obtem o resultado da intent e define a imagem
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bitmap squareBitmap =  (Bitmap) data.getExtras().get("data");
            imagePerfil.setImageBitmap(squareBitmap);
        }
    }


    @OnTextChanged(R.id.edit_text_nome)
    public void validaNome (){
        layoutNome.setErrorEnabled(false);
        layoutNome.setError( "" );
    }

    @OnTextChanged (R.id.edit_text_endereco)
    public void validaEndereco (){
        layoutEndereco.setErrorEnabled( false );
        layoutEndereco.setError( "" );
    }

    @OnTextChanged(R.id.edit_text_telefone)
    public void validaTel (){
        layoutTel.setErrorEnabled(false);
        layoutTel.setError( "" );
    }

    @Override
    public void erroNome() {
        layoutNome.setErrorEnabled( true );
        layoutNome.setError(getString(R.string.invalid_username));
    }

    @Override
    public void erroMapa() {
        layoutEndereco.setErrorEnabled( true );
        layoutEndereco.setError(getString(R.string.invalid_username));
    }

    @Override
    public void erroTel() {
        layoutTel.setErrorEnabled( true );
        layoutTel.setError(getString(R.string.invalid_username));
    }
}
