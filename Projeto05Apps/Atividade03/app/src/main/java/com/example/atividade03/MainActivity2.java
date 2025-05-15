package com.example.atividade03;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    private Button btnT2Set, btnT2Reset;
    private TextInputEditText textNome, textSenha, textEmail;
    private TextView campoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnT2Set = findViewById(R.id.btnT2Set);
        btnT2Reset = findViewById(R.id.btnT2Reset);
        textNome = findViewById(R.id.textT2Nome);
        textSenha = findViewById(R.id.textT2Senha);
        textEmail = findViewById(R.id.textT2Email);
        campoResultado = findViewById(R.id.textT2Resultado);

        btnT2Set.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity3.class);

            String email = textEmail.getText().toString();
            String nome = textNome.getText().toString();
            String senha = textSenha.getText().toString();

            //Validação simples : Verifica se campos estão vazios & Processamento
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                campoResultado.setText("Preencha as informações necessárias!");
                return;
            }
            try {
                intent.putExtra("nome", nome);

            }catch (NumberFormatException e) {
                campoResultado.setText("Entrada Inválida");
            }

            startActivity(intent);
        });

        btnT2Reset.setOnClickListener(view -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}