package com.example.atividade03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        // Mostrar os dados:
        String resultado = "\n" + "Bem-vindo(a) " + nome + ", seu cadastro foi realizado com sucesso!" + "\n";


        textT3Resultado.setText(resultado);

        btnT3Reset.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}
