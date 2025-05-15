package com.example.atividade5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity2 extends AppCompatActivity {
    private Button btnT2Set, btnT2Reset;
    private RadioGroup radioGroup;
    private TextView textT2Titulo, textT2SubTitulo;
    private RadioButton rbPequena, rbMedia, rbGrande, rbPix, rbDebito, rbCredito;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnT2Set = findViewById(R.id.btnT2Set);
        btnT2Reset = findViewById(R.id.btnT2Reset);
        Resultado = findViewById(R.id.textT2Resultado);
        textT2Titulo = findViewById(R.id.textT2Titulo);
        textT2SubTitulo = findViewById(R.id.textT2SubTitulo);
        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);
        rbPix = findViewById(R.id.rbPix);
        rbDebito = findViewById(R.id.rbDebito);
        rbCredito = findViewById(R.id.rbCredito);

        btnT2Set.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity3.class);

            String tamanho = " ";
            double total = 0.0;
            if (rbPequena.isChecked()){
                tamanho = "4 fatias";
                total += 15.90;
            }
            else if (rbMedia.isChecked()){
                tamanho = "8 fatias";
                total += 25.90;
            }
            else if (rbGrande.isChecked()) {
                tamanho = "12 fatias";
                total += 35.90;
            }

            String pagamento = " ";
            if (rbPix.isChecked()){
                pagamento = "PIX";
            } else if (rbDebito.isChecked()) {
                pagamento = "Débito";
            } else if (rbCredito.isChecked()){
                pagamento = "Crédito";
            }

            Bundle bundle = getIntent().getExtras();

            String nome = bundle.getString("nome");
            double valor = bundle.getDouble("valor");
            String lanche = bundle.getString("lanche");



            total = total + valor;

            // Enviando dados para a próxima activity
            intent.putExtra("nome", nome);
            intent.putExtra("lanche", lanche);
            intent.putExtra("tamanho", tamanho);
            intent.putExtra("pagamento", pagamento);
            intent.putExtra("total", total);
            startActivity(intent);
        });

        btnT2Reset.setOnClickListener(view -> {
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}