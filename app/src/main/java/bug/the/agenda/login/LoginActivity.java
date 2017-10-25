package bug.the.agenda.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bug.the.agenda.adicionarContatos.ListaContatos;
import bug.the.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView (R.id.text_input_layout_username) TextInputLayout usernameTextInputLayout;
    @BindView (R.id.edit_text_username) TextInputEditText usernameEditText;
    @BindView (R.id.text_input_layout_password) TextInputLayout passwordTextInputLayout;
    @BindView (R.id.edit_text_password) TextInputEditText passwordEditText;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind( this );

        loginPresenter = new LoginPresenter(LoginActivity.this);
    }

    public void setErroUsuario(){
        usernameTextInputLayout.setErrorEnabled(true);
        usernameTextInputLayout.setError(getString(R.string.invalid_username));
    }

    public void setErroSenha(){
        passwordTextInputLayout.setErrorEnabled(true);
        passwordTextInputLayout.setError(getString(R.string.invalid_password));
    }

    public void loginComSucesso(){
        Intent abrirListaContatos = new Intent(LoginActivity.this , ListaContatos.class);
        startActivity(abrirListaContatos);
    }

    @OnClick (R.id.button_login)
    public void fazLogin (){
        loginPresenter.login(
                usernameEditText.getText().toString(),
                passwordEditText.getText().toString()
        );
    }

}

