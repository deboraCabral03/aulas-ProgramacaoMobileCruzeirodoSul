package com.example.atividade04;

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

public class MainActivity2 extends AppCompatActivity {
    private Button btnT2Set, btnT2Reset;
    private TextInputEditText textNome;
    private CheckBox cbBurger, cbSalada, cbBacon, cbTudo, cbBatata, cbRefri;
    private TextView campoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        btnT2Set = findViewById(R.id.btnT2Set);
        btnT2Reset = findViewById(R.id.btnT2Reset);
        textNome = findViewById(R.id.textT2Nome);
        cbBurger = findViewById(R.id.cbBurger);
        cbSalada = findViewById(R.id.cbSalada);
        cbBacon = findViewById(R.id.cbBacon);
        cbBatata = findViewById(R.id.cbBatata);
        cbTudo = findViewById(R.id.cbTudo);
        cbRefri = findViewById(R.id.cbRefri);
        campoResultado = findViewById(R.id.textT2Resultado);


        btnT2Set.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity3.class);
            String texto = " ";
            if(cbBurger.isChecked()){
                String lanche = cbBurger.getText().toString();
                texto = "1x " + lanche;
            }
            if(cbSalada.isChecked()){
                String lanche = cbSalada.getText().toString();
                texto = texto + "\n" + "1x " + lanche;
            }
            if(cbBacon.isChecked()){
                String lanche = cbBacon.getText().toString();
                texto = texto + "\n" + "1x " + lanche;
            }
            if(cbTudo.isChecked()){
                String lanche = cbTudo.getText().toString();
                texto = texto + "\n" + "1x " + lanche;
            }
            if(cbBatata.isChecked()){
                String lanche = cbBatata.getText().toString();
                texto = texto +  "\n" + "1x " + lanche;
            }
            if(cbRefri.isChecked()){
                String lanche = cbRefri.getText().toString();
                texto = texto +  "\n" + "1x " + lanche + " ";
            }

            boolean cbcBurger = cbBurger.isChecked();
            boolean cbcSalada = cbSalada.isChecked();
            boolean cbcTudo = cbTudo.isChecked();
            boolean cbcBacon = cbBacon.isChecked();
            boolean cbcRefri = cbRefri.isChecked();
            boolean cbcBatata = cbBatata.isChecked();
            String nome = textNome.getText().toString();


            if (nome.isEmpty()) {
                campoResultado.setText("Preencha as informações necessárias!");
                return;
            } if (!cbcBatata && (!cbcBacon && !cbcRefri && !cbcBurger && !cbcSalada && !cbcTudo)) {
                campoResultado.setText("Selecione pelo menos uma das opções acima!");
            }

            if (!nome.isEmpty() && (cbcBatata || cbcBacon || cbcRefri || cbcBurger || cbcSalada || cbcTudo)) {
                intent.putExtra("nome", nome);
                intent.putExtra("lanche", texto);
                startActivity(intent);
            }
        });

        btnT2Reset.setOnClickListener(view -> finish());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}
