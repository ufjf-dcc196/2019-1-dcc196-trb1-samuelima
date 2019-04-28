package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NovaDisciplinaCursadaActivity extends AppCompatActivity {
    private Button bnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_disciplina_cursada);
        setTitle("Nova Disciplina");

        bnd = findViewById(R.id.btn_new_disc);

        /*BOTÃO CADASTRAR DISCIPLINA*/
        bnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jn = new Intent();
                setResult(DisciplinasCursadasActivity.RESULT_OK, jn);
                finish();
            }
        });

    }
}
