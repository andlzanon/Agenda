package bug.the.agenda.main;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;

import bug.the.agenda.R;
import butterknife.BindView;

/**
 * Created by Andre on 25/10/2017.
 */

public class MainPresenter {
    MainView mainView;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
    }

    public void login(String username, String password){
        if (TextUtils.isEmpty(username)) {
            mainView.erroUsuario();
        }
        else if (TextUtils.isEmpty(password)) {
            mainView.erroSenha();
        }
        else{
            mainView.loginComSucesso();
        }
    }
}
