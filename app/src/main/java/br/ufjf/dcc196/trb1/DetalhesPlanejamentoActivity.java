package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetalhesPlanejamentoActivity extends AppCompatActivity {
    private Button salva_disc;
    private TextView txt_disc, txt_hrs, txt_area;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_planejamento);
        setTitle("Editar Disciplinas");

        txt_disc = findViewById(R.id.txt_disc);
        txt_hrs = findViewById(R.id.txt_hr);
        txt_area = findViewById(R.id.txt_area);


        String dsc = getIntent().getExtras().getString("disciplina");
        String hrs = getIntent().getExtras().getString("horas");
        String are = getIntent().getExtras().getString("area");
        id = getIntent().getExtras().getString("id");

        txt_disc.setText(dsc);
        txt_hrs.setText(hrs);
        txt_area.setText(are);

        salva_disc = findViewById(R.id.btn_salva_disc);
        salva_disc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dp = new Intent();

                dp.putExtra("new_id",id);
                dp.putExtra("new_disciplina",txt_disc.getText().toString());
                dp.putExtra("new_horas",txt_hrs.getText().toString());
                dp.putExtra("new_areas",txt_area.getText().toString());

                setResult(DisciplinasCursadasActivity.RESULT_OK, dp);
                finish();
            }
        });


    }
}
