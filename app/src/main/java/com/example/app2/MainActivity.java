package com.example.app2;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;


public class MainActivity<year, month, day, dataNascimento> extends AppCompatActivity {

    private TextView txtcpf;
    private TextView dataNascimento;
    private Button btnLimpar;
    private Button btnContinuar;

    private String dataSelFormatada;
    private String dataPagamentoFormatada;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private EditText txtCpf;
    private char[] qntParcelas;
    private Fragment numeroParcelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        txtCpf = (EditText) findViewById(R.id.txtCpf);
        dataNascimento = (TextView) findViewById((R.id.dataNascimento));
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {

            }

                public void onDateSet(int year, int monthOfYear, int dayOfMonth, dataNascimento) {
                    Calendar calendar = null;
                    calendar.set(year, monthOfYear, dayOfMonth);
                                dataSelFormatada = sdf.format(calendar.getTime());
                                dataNascimento.setText(dataSelFormatada);
                            }

        });

        btnContinuar = (Button) findViewById(R.id.btnContinuar);
    }

    public void onClickContinuar(View view, Object calendar) throws ParseException {
        if (calendar == null){
            Toast.makeText(MainActivity.this, "Selecione sua Data de Nascimento", Toast.LENGTH_LONG).show();
            return;
        }

        if (!validarCamposNulos()){
            Toast.makeText(MainActivity.this, "Todos os campos devem ser PREENCHIDOS", Toast.LENGTH_LONG).show();
            return;
        }


        Calendar calendarPagamento = Calendar.getInstance();
        calendarPagamento.add(Calendar.DAY_OF_MONTH, 20);

        dataPagamentoFormatada = sdf.format(calendarPagamento.getTime());


        goToNewActivity();
        limpar();
    }

    private Boolean validarCamposNulos(){

        Fragment qntParcelas;
        if (TextUtils.isEmpty(txtCpf.getText().toString()) ||
                TextUtils.isEmpty(numeroParcelas.getText().toString()))
        {
            return false;
        }
        return true;
    }


    private void limpar(){
        txtCpf.setText("");
        dataNascimento.setText("");
    }

    private void goToNewActivity() {
        Intent intent = new Intent(MainActivity.this, tela2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("dataPAgamento", dataPagamentoFormatada);
        bundle.putString("qntParcelas", String.valueOf(qntParcelas));

        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    private class tela2Activity {
    }
}
