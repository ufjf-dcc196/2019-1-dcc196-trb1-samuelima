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
    private TextView editar, dc_1, dc_2, dc_3, dc_4, d,h,a, d1,h1,a1, d2,h2,a2, d3,h3,a3, d4,h4,a4;
    private String id_ret;


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
                Bundle bn = data.getExtras();
                assert bn != null;
                id_ret = bn.getString("new_id");

                assert id_ret != null;
                switch (id_ret) {
                    case "1":
                        d1.setText(bn.getString("new_disciplina"));
                        h1.setText(bn.getString("new_horas"));
                        a1.setText(bn.getString("new_areas"));
                        break;
                    case "2":
                        d2.setText(bn.getString("new_disciplina"));
                        h2.setText(bn.getString("new_horas"));
                        a2.setText(bn.getString("new_areas"));
                        break;
                    case "3":
                        d3.setText(bn.getString("new_disciplina"));
                        h3.setText(bn.getString("new_horas"));
                        a3.setText(bn.getString("new_areas"));
                        break;
                    case "4":
                        d4.setText(bn.getString("new_disciplina"));
                        h4.setText(bn.getString("new_horas"));
                        a4.setText(bn.getString("new_areas"));
                        break;
                }

                Toast.makeText(this, "Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_dc1:
                Intent i = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d1 = findViewById(R.id.id_dc1);
                h1 = findViewById(R.id.id_hr1);
                a1 = findViewById(R.id.id_ar1);

                i.putExtra("id","1");
                i.putExtra("disciplina", d1.getText().toString());
                i.putExtra("horas", h1.getText().toString());
                i.putExtra("area", a1.getText().toString());
                startActivityForResult(i, REQ_EDIT_DISC);
                break;

            case R.id.list_dc2:
                Intent i2 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d2 = findViewById(R.id.id_dc2);
                h2 = findViewById(R.id.id_hr2);
                a2 = findViewById(R.id.id_ar2);

                i2.putExtra("id","2");
                i2.putExtra("disciplina", d2.getText().toString());
                i2.putExtra("horas", h2.getText().toString());
                i2.putExtra("area", a2.getText().toString());
                startActivityForResult(i2, REQ_EDIT_DISC);
                break;

            case R.id.list_dc3:
                Intent i3 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d3 = findViewById(R.id.id_dc3);
                h3 = findViewById(R.id.id_hr3);
                a3 = findViewById(R.id.id_ar3);

                i3.putExtra("id","3");
                i3.putExtra("disciplina", d3.getText().toString());
                i3.putExtra("horas", h3.getText().toString());
                i3.putExtra("area", a3.getText().toString());
                startActivityForResult(i3, REQ_EDIT_DISC);
                break;

            case R.id.list_dc4:
                Intent i4 = new Intent(DisciplinasCursadasActivity.this, DetalhesPlanejamentoActivity.class);
                d4 = findViewById(R.id.id_dc4);
                h4 = findViewById(R.id.id_hr4);
                a4 = findViewById(R.id.id_ar4);

                i4.putExtra("id","4");
                i4.putExtra("disciplina", d4.getText().toString());
                i4.putExtra("horas", h4.getText().toString());
                i4.putExtra("area", a4.getText().toString());
                startActivityForResult(i4, REQ_EDIT_DISC);
                break;
        }
    }

}
