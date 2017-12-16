package bug.the.agenda.splashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bug.the.agenda.R;
import bug.the.agenda.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 2 seconds
                Intent abreLogin = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(abreLogin);
                finish();
            }
        }, 2000);
    }

}
