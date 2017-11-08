package bug.the.agenda.cadastroContatos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import bug.the.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

import static bug.the.agenda.cadastroContatos.ContatosRecyclerAdapter.CONTATO;
import static bug.the.agenda.cadastroContatos.ContatosRecyclerAdapter.INDEX;
import static bug.the.agenda.cadastroContatos.ListaContatosActivity.contatos;

public class CadastroContatosActivity extends AppCompatActivity implements CadastroContatosView {

    private static final int CAMERA_REQUEST = 1888;

    //atributos do objeto a ser adicionado no array list
    Bitmap imagem;
    int index;
    //declaracao do presenter
    CadastroContatosPresenter cadastroContatosPresenter;

    //definicao da imagem de perfil redonda
    @BindView(R.id.imagemPerfil) de.hdodenhof.circleimageview.CircleImageView imagePerfil;

    //declaracao dos campos de nome
    @BindView(R.id.edit_text_nome) TextInputEditText textoNome;
    @BindView(R.id.text_input_layout_nome) TextInputLayout layoutNome;

    //declaracao dos campos de email
    @BindView(R.id.edit_text_email) TextInputEditText textoEmail;
    @BindView(R.id.text_input_layout_email) TextInputLayout layoutEmail;

    //declaracao dos campos de endereco
    @BindView(R.id.edit_text_endereco) TextInputEditText textoEndereco;
    @BindView(R.id.text_input_layout_endereco) TextInputLayout layoutEndereco;

    //declaracao dos campos de telefone
    @BindView(R.id.edit_text_telefone) TextInputEditText textoTelefone;
    @BindView(R.id.text_input_layout_telefone) TextInputLayout layoutTel;

    //contato que pode ou nao ser recebido para a Activity
    Contato contato = null;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);

        ButterKnife.bind( this );
        cadastroContatosPresenter = new CadastroContatosPresenter(this, this);

        //seta imagem de perfil
        imagePerfil.setImageDrawable(getResources().getDrawable(R.drawable.ic_photo));
        //no comeco imagem da pessoa e a imagem defaut, ou seja, a camera
        imagem = BitmapFactory.decodeResource(getResources(), R.drawable.ic_photo);

        //verifica se um Contato foi passado para esta Activity, ou seja, se a activity foi aberta
        //por meio de um click na Recycler View
        Intent intent = getIntent();
        contato = intent.getParcelableExtra(CONTATO);
        index = intent.getIntExtra(INDEX, -1);

        //verifica se o contato e null. Se nao for, seta as informacoes conforme o objeto passado como Extra
        cadastroContatosPresenter.verificaSeContatoENull(contato);

        //cria a toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //adciona titulo e define o botao <- na toolbar
        if(contato == null)
            getSupportActionBar().setTitle(R.string.novo_contato);
        else
            getSupportActionBar().setTitle(R.string.contato);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //coloca o texto de cadastrar na toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        cadastroContatosPresenter.editouOuCadastrou(item.getItemId(), contato);
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
            imagem = squareBitmap;
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

    @Override
    public void erroEndereco(){
        layoutEndereco.setErrorEnabled( true );
        layoutEndereco.setError(getString(R.string.invalid_username));
    }

    @Override
    public void erroEmail(){
        layoutEmail.setErrorEnabled( true );
        layoutEmail.setError(getString(R.string.invalid_username));
    }

    @Override
    public void cadastroComSucesso(String nome, String endereco, String telefone, String email){
        contatos.add(new Contato(imagem, nome, endereco, telefone, email));
        Log.d("CADASTRO: ", "COM SUCESSO " +contatos.size());
        Intent intent = new Intent(this, ListaContatosActivity.class);
        startActivity(intent);
    }

    @Override
    public void contatoNaoNull(){
        imagePerfil.setImageBitmap(contato.getFotoPerfil());
        textoNome.setText(contato.getNome());
        textoTelefone.setText(contato.getTelefone());
        textoEndereco.setText(contato.getEndereco());
        textoEmail.setText(contato.getEmail());
    }

    @Override
    public void editouContato(Bitmap bitmap, String nome, String endereco, String telefone, String email){
        contatos.remove(index);
        contatos.add(index, new Contato(bitmap, nome, endereco, telefone, email));
        Intent intent = new Intent(this, ListaContatosActivity.class);
        startActivity(intent);
    }

    @Override
    public void tentaCadastro(){
        cadastroContatosPresenter.cadastro(textoNome.getText().toString(), textoEndereco.getText().toString(),
                textoTelefone.getText().toString(), textoEmail.getText().toString());
    }

    @Override
    public void editouContatoPresenter(){
        editouContato(imagem, textoNome.getText().toString(), textoEndereco.getText().toString(),
                textoTelefone.getText().toString(), textoEmail.getText().toString());
    }
}
