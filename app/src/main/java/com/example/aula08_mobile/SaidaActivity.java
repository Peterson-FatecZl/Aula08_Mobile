package com.example.aula08_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula08_mobile.model.Ingresso;
import com.example.aula08_mobile.model.IngressoVip;

public class SaidaActivity extends AppCompatActivity {

    private Ingresso ingresso;
    private IngressoVip ingressoVip;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvSaida = findViewById(R.id.tvSaida);
        tvSaida.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String tipo = bundle.getString("tipo");
        if (tipo.equals("ingresso")) {
            Ingresso ingresso = new Ingresso();
            ingresso.setCodigoIdentificador(bundle.getString("codigo"));
            ingresso.setValor(bundle.getFloat("valor"));
            tvSaida.setText(ingresso.getCodigoIdentificador()+"\n"+ingresso.getValor());
        }
        if (tipo.equals("ingressoVip")) {
            ingressoVip = new IngressoVip();
            ingressoVip.setCodigoIdentificador(bundle.getString("codigo"));
            ingressoVip.setFuncaoExercidaPelaPessoa(bundle.getString("funcao"));
            ingressoVip.setValor(bundle.getFloat("valor"));
            tvSaida.setText(ingressoVip.getCodigoIdentificador()+"\n"+ingressoVip.getValor()+"\n"+ingressoVip.getFuncaoExercidaPelaPessoa());
        }

        btnVoltar.setOnClickListener(click -> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }

}