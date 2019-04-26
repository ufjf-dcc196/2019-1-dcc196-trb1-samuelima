package br.ufjf.dcc196.trb1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisciplinasCursadasActivity extends AppCompatActivity implements OnClickListener{
    public static final int REQ_EDIT_DISC = 1;
    private Button b2;
    private TextView editar, dc_1, dc_2, dc_3, dc_4, d,h,a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas_cursadas);
        /*ALTERA TÍTULO DA TELA*/
        String per = getIntent().getExtras().getString("periodo");
        setTitle("Lista Disciplinas " + per);

        dc_1 = findViewById(R.id.list_dc1);
        dc_2 = findViewById(R.id.list_dc2);
        dc_3 = findViewById(R.id.list_dc3);
        dc_4 = findViewById(R.id.list_dc4);
        b2 = findViewById(R.id.btn_volt_plan);

        editar = findViewById(R.id.btn_edit_disc);

        /*BOTÃO VOLTAR*/
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j2 = new Intent();
                setResult(PlanejamentosActivity.RESULT_OK, j2);
                finish();
            }
        });

        /*LINHAS TABELA*/
        dc_1.setOnClickListener(this);
        dc_2.setOnClickListener(this);
        dc_3.setOnClickListener(this);
        dc_4.setOnClickListener(this);

        /*BOTÃO EDITAR*/
        editar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ed = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                startActivityForResult(ed, REQ_EDIT_DISC);
            }
        });
    }

    /*RETORNO DA TELA - NOVO PLANEJAMENTO*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQ_EDIT_DISC && resultCode==RESULT_OK){
            if(data!=null){
                Bundle b = data.getExtras();

                d.setText(b.getString("new_disciplina"));
                h.setText(b.getString("new_horas"));
                a.setText(b.getString("new_areas"));

                Toast.makeText(this, "Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_dc1:
                Intent i = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d = findViewById(R.id.id_dc1);
                h = findViewById(R.id.id_hr1);
                a = findViewById(R.id.id_ar1);
                //L1 = "1";
                i.putExtra("disciplina", d.getText().toString());
                i.putExtra("horas", h.getText().toString());
                i.putExtra("area", a.getText().toString());
                startActivityForResult(i, REQ_EDIT_DISC);
                break;

            case R.id.list_dc2:
                Intent i2 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d = findViewById(R.id.id_dc2);
                h = findViewById(R.id.id_hr2);
                a = findViewById(R.id.id_ar2);
                //L1 = "2";
                i2.putExtra("disciplina", d.getText().toString());
                i2.putExtra("horas", h.getText().toString());
                i2.putExtra("area", a.getText().toString());
                startActivityForResult(i2, REQ_EDIT_DISC);
                break;

            case R.id.list_dc3:
                Intent i3 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d = findViewById(R.id.id_dc3);
                h = findViewById(R.id.id_hr3);
                a = findViewById(R.id.id_ar3);
                //L3 = "3";
                i3.putExtra("disciplina", d.getText().toString());
                i3.putExtra("horas", h.getText().toString());
                i3.putExtra("area", a.getText().toString());
                startActivityForResult(i3, REQ_EDIT_DISC);
                break;

            case R.id.list_dc4:
                Intent i4 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d = findViewById(R.id.id_dc4);
                h = findViewById(R.id.id_hr4);
                a = findViewById(R.id.id_ar4);
                i4.putExtra("disciplina", d.getText().toString());
                i4.putExtra("horas", h.getText().toString());
                i4.putExtra("area", a.getText().toString());
                startActivityForResult(i4, REQ_EDIT_DISC);
                break;
        }
    }

}
