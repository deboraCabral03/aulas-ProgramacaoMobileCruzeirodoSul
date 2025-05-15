package com.example.atividade5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button bntT1Set;
    private TextInputEditText textT1Nome;
    private TextView campoResultado;
    private CheckBox cbCalamussa, cbMarguerita, cbQueijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bntT1Set = findViewById(R.id.btnT1Set);
        textT1Nome = findViewById(R.id.textT1Nome);
        campoResultado = findViewById(R.id.textT1Resultado);
        cbCalamussa = findViewById(R.id.cbCalamussa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbQueijo = findViewById(R.id.cbQueijo);

        // Chama a proxima tela + transfere valor (objeto):
        bntT1Set.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity2.class);
            String texto = " ";
            double valor = 0.0;
            if(cbCalamussa.isChecked()){
                String lanche = cbCalamussa.getText().toString();
                texto = lanche + " ";
                valor = 20.00;
            }
            if(cbMarguerita.isChecked()){
                String lanche = cbMarguerita.getText().toString();
                texto = texto + lanche + " ";
                valor = valor + 20.00;
            }
            if(cbQueijo.isChecked()){
                String lanche = cbQueijo.getText().toString();
                texto = texto + lanche + " ";
                valor = valor + 20.00;
            }

            String nome = textT1Nome.getText().toString();

            //Validação simples : Verifica se campos estão vazios & Processamento
            if (nome.isEmpty()) {
                campoResultado.setText("Preencha as informações necessárias!");
                return;
            }
            try {
                intent.putExtra("nome", nome);
                intent.putExtra("lanche", texto);
                intent.putExtra("valor", valor);

            }catch (NumberFormatException e) {
                campoResultado.setText("Entrada Inválida");
            }

            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}