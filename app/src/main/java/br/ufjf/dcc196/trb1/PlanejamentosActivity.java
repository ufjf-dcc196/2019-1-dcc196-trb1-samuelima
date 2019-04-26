package br.ufjf.dcc196.trb1;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PlanejamentosActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int REQ_NOVO_PLANEJ = 2;
    public static final int REQ_DISC_CURS = 3;
    private TextView novo_planej,ls_1,ls_2,ls_3,ls_4;

   // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planejamentos);
        setTitle("Planejamento de Estudos");

        novo_planej = findViewById(R.id.btn_novo_planejamento);
        ls_1 = findViewById(R.id.edit_ls_1);
        ls_2 = findViewById(R.id.edit_ls_2);
        ls_3 = findViewById(R.id.edit_ls_3);
        ls_4 = findViewById(R.id.edit_ls_4);

        /*BOTÃO NOVO PLANEJAMENTO*/
        novo_planej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlanejamentosActivity.this, NovoPlanejamentoActivity.class);
                startActivityForResult(i, REQ_NOVO_PLANEJ);
            }
        });

        /*LINHAS TABELA*/
        ls_1.setOnClickListener(this);
        ls_2.setOnClickListener(this);
        ls_3.setOnClickListener(this);
        ls_4.setOnClickListener(this);
    }

    /*RETORNO DA TELA - NOVO PLANEJAMENTO*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQ_NOVO_PLANEJ && resultCode==RESULT_OK){
            if(data!=null){
                Toast.makeText(this, "Novo Planejamento Criado!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /*ABRINDO TELA DO PERÍODO*/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_ls_1:
                Intent i1 = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                TextView d1 = findViewById(R.id.pdc1);
                i1.putExtra("periodo", d1.getText().toString());
                startActivityForResult(i1, REQ_DISC_CURS);
                break;

            case R.id.edit_ls_2:
                Intent i2 = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                TextView d2 = findViewById(R.id.pdc2);
                i2.putExtra("periodo", d2.getText().toString());
                startActivityForResult(i2, REQ_DISC_CURS);
                break;

            case R.id.edit_ls_3:
                Intent i3 = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                TextView d3 = findViewById(R.id.pdc3);
                i3.putExtra("periodo", d3.getText().toString());
                startActivityForResult(i3, REQ_DISC_CURS);
                break;

            case R.id.edit_ls_4:
                Intent i4 = new Intent(PlanejamentosActivity.this, DisciplinasCursadasActivity.class);
                TextView d4 = findViewById(R.id.pdc4);
                i4.putExtra("periodo", d4.getText().toString());
                startActivityForResult(i4, REQ_DISC_CURS);
                break;
        }
    }
}
