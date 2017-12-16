package bug.the.agenda.login;

import android.text.TextUtils;

/**
 * Created by Andre on 25/10/2017.
 */

public class LoginPresenter {
    LoginView loginView;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }

    public void login(String username, String password){
        if (TextUtils.isEmpty(username)) {
            loginView.erroUsuario();
        }
        else if (TextUtils.isEmpty(password)) {
            loginView.erroSenha();
        }
        else{
            loginView.loginComSucesso();
        }
    }
}
