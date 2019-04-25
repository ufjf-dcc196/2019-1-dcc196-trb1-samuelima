package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisciplinasCursadasActivity extends AppCompatActivity {
    public static final int REQ_EDIT_DISC = 1;
    private Button b2;
    private TextView editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);

        b2 = findViewById(R.id.btn_volt_plan);
        editar = findViewById(R.id.btn_edit_disc);

        TextView titulo_pagina = findViewById(R.id.titulo_dc_cur);
        String titulo_old = titulo_pagina.getText().toString();
        String per = getIntent().getExtras().getString("periodo");

        titulo_pagina.setText(titulo_old + " " + per);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ed = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                startActivityForResult(ed,REQ_EDIT_DISC);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j2 = new Intent();
                setResult(PlanejamentosActivity.RESULT_OK, j2);
                finish();
            }
        });


    }
}
