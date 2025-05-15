package com.example.atividade02;

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

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private RadioGroup radioGroup;
    private RadioButton rbPorc50, rbPorc45, rbPorc40;
    private EditText editTextSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        rbPorc40 = findViewById(R.id.rbPorc40);
        rbPorc45 = findViewById(R.id.rbPorc45);
        rbPorc50 = findViewById(R.id.rbPorc50);
        radioGroup = findViewById(R.id.radioGroup);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void enviar(View view) {
        radioButton();

    }

    public void radioButton() {
        double porcentagem = 0;
        EditText editText = findViewById(R.id.editTextSalario);
        String textSalario = editText.getText().toString();
        double salario = Double.parseDouble(textSalario);
        if (rbPorc40.isChecked()) {
            porcentagem = 0.40;
        }
        if (rbPorc45.isChecked()) {
            porcentagem = 0.45;
        }
        if (rbPorc50.isChecked()) {
            porcentagem = 0.50;

        }
        double resultado = salario + (salario * porcentagem);
        textResultado.setText(String.format("Seu novo salário será de: R$%.2f", resultado));
}
}