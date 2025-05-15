package com.example.atividade5;

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

public class MainActivity3 extends AppCompatActivity {

    private Button btnT3Reset;
    private TextView textT3Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        textT3Resultado = findViewById(R.id.textT3Resultado);
        btnT3Reset = findViewById(R.id.btnT3Reset);

        // Receber os dados:
        Bundle bundle = getIntent().getExtras();

        String nome = bundle.getString("nome");
        String lanche = bundle.getString("lanche");
        double total = bundle.getDouble("total");
        String tamanho = bundle.getString("tamanho");
        String pagamento = bundle.getString("pagamento");

        // Mostrar os dados:
        String resultado = "\n" + "Resumo da Compra: " +
                "\n" + "Cliente - " + nome +
                "\n" + "Sabor da Pizza: " + lanche +
                "\n" + "Tamanho: " + tamanho +
                "\n" + "Forma de Pagamento: " + pagamento +
                "\n" + "\n" + "O valor total será R$" + total + "\n";


        textT3Resultado.setText(resultado);

        btnT3Reset.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}