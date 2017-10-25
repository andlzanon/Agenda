package bug.the.agenda.adicionarContatos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import bug.the.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class addContato extends AppCompatActivity {

    @BindView(R.id.edt_contato_nome)
    EditText contatoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_contato_adicionado)
    public void contatoAdicionado (){
        Intent resultIntent = new Intent();
        resultIntent.putExtra("contato_nome" , contatoNome.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

}
