package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class tela2 extends AppCompatActivity {

    private TextView dataPagamento;
    private TextView parcela1;
    private TextView parcela2;
    private TextView parcela3;

    public tela2(TextView parcela1, TextView parcela2, TextView parcela3) {
        this.parcela1 = parcela1;
        this.parcela2 = parcela2;
        this.parcela3 = parcela3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tela2 );

        dataPagamento = findViewById(R.id.dataPagamento);

        Bundle bundle = getIntent().getExtras();

        dataPagamento.setText(bundle.getString("dataPAgamento"));
        parcela1.setText("R$" + bundle.getString("1 parcela"));
        parcela2.setText("R$" + bundle.getString("2 parcela"));
        parcela3.setText("R$" + bundle.getString("3 parcela"));

    }

    public void onClickVoltar(View view){
        finish();
    }
}
