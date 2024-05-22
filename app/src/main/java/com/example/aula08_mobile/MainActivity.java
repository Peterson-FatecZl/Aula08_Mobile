package com.example.aula08_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula08_mobile.model.Ingresso;
import com.example.aula08_mobile.model.IngressoVip;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbIngresso;
    private RadioButton rbIngressoVip;
    private EditText etCodigoIdentificador;
    private EditText etValorIngresso;
    private EditText etFuncaoDesempenhada;
    private Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbIngresso = findViewById(R.id.rbIngresso);
        rbIngresso.setChecked(true);
        rbIngressoVip = findViewById(R.id.rbIngressoVip);
        etCodigoIdentificador = findViewById(R.id.etCodigoIdentificador);
        etValorIngresso = findViewById(R.id.etValorIngresso);
        etFuncaoDesempenhada = findViewById(R.id.etFuncaoDesempenhada);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calcularValor());


    }

    private void calcularValor() {
        String tipo = "";
        if (rbIngresso.isChecked()) {
            String codigoIdentificador = etCodigoIdentificador.getText().toString();
            String valorIngresso = etValorIngresso.getText().toString();

            Ingresso ingresso = new Ingresso();
            ingresso.setValor(Float.parseFloat(valorIngresso));
            ingresso.setTaxa(0.02f);

            float valorFinal = ingresso.valorFinal();

            tipo = "ingresso";
            Bundle bundle = new Bundle();
            bundle.putString("codigo", codigoIdentificador);
            bundle.putFloat("valor", valorFinal);
            bundle.putString("tipo", tipo);

            troca(bundle);
        }
        if (rbIngressoVip.isChecked()) {
            String codigoIdentificador = etCodigoIdentificador.getText().toString();
            String valorIngresso = etValorIngresso.getText().toString();
            String funcaoDesempenhada = etFuncaoDesempenhada.getText().toString();

            IngressoVip ingressoVip = new IngressoVip();
            ingressoVip.setValor(Float.parseFloat(valorIngresso));

            float valorFinal = ingressoVip.valorFinal();

            tipo = "ingressoVip";
            Bundle bundle = new Bundle();
            bundle.putString("codigo", codigoIdentificador);
            bundle.putFloat("valor", valorFinal);
            bundle.putString("funcao", funcaoDesempenhada);
            bundle.putString("tipo", tipo);

            troca(bundle);
        }
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

}