package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NovoPlanejamentoActivity extends AppCompatActivity {
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_planejamento);
        setTitle("Novo Planejamento");

        b1 = findViewById(R.id.btn_cad_plan);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent();
                setResult(PlanejamentosActivity.RESULT_OK, j);
                finish();
            }
        });
    }
}
