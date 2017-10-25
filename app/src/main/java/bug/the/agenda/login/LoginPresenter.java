package bug.the.agenda.login;

import android.text.TextUtils;

/**
 * Created by Rodrigo on 24/10/2017.
 */

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(String username, String password){
        if(TextUtils.isEmpty(username)){
            //Exibe mensagem de erro de usuário
            loginView.setErroUsuario();
        }
        else if(TextUtils.isEmpty(password)){
            //Exibe a mensagem de erro de senha
            loginView.setErroSenha();
        }
        else{
            //Abre a tela inicial de lista de contatos
            loginView.loginComSucesso();
        }
    }
}
