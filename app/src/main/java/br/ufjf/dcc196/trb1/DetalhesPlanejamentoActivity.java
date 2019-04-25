package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);
        Button bd1 = findViewById(R.id.btn_cad_plan);
        bd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e1 = new Intent();
                setResult(DisciplinasCursadasActivity.RESULT_OK, e1);
                finish();
            }
        });
    }
}
