package br.com.unicsul.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int pontosUsuario = 0;
    int pontosPC = 0;
    private TextView textPlacar;
    private TextView textResultado;
    private ImageView imgResultado;
    TextView textResultado;
    TextView ganhador;
    ImageView imgResultado;

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


        textResultado = findViewById(R.id.textResultado);
        ganhador = findViewById(R.id.ganhador);
        imgResultado = findViewById(R.id.imgResultado);
        textPlacar = findViewById(R.id.textPlacar);
        textResultado = findViewById(R.id.textResultado);

    }

    public void selectPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selectTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void selectPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void opcaoSelecionada(String opcaoUser) {

        // Escolha do PC
        String[] opcoes = {"pedra", "tesoura", "papel"};
        String opcaoPC = opcoes[new Random().nextInt(3)];
    
        // Atualiza imagem
        switch (opcaoPC) {
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }
    
        // Verifica resultado
        String resultado;
        if ((opcaoPC.equals("tesoura") && opcaoUser.equals("papel")) ||
            (opcaoPC.equals("papel") && opcaoUser.equals("pedra")) ||
            (opcaoPC.equals("pedra") && opcaoUser.equals("tesoura"))) {
    
            resultado = "PC WIN!";
            pontosPC++;
    
        } else if ((opcaoUser.equals("tesoura") && opcaoPC.equals("papel")) ||
                   (opcaoUser.equals("papel") && opcaoPC.equals("pedra")) ||
                   (opcaoUser.equals("pedra") && opcaoPC.equals("tesoura"))) {
    
            resultado = "YOU WIN!";
            pontosUser++;
    
        } else {
            resultado = "EMPATOU!";
        }
    
        // Atualiza placar
        textPlacar.setText("Você: " + pontosUser + "  |  PC: " + pontosPC);
        textResultado.setText(resultado);
    
        // Verifica se alguém venceu o jogo
        if (pontosUser == 5 || pontosPC == 5) {
            String vencedor = pontosUser == 5 ? "Parabéns, você venceu!" : "O computador venceu!";
            textResultado.setText(vencedor);
        }
    }
    public void resetGame(View view) {
        pontosUser = 0;
        pontosPC = 0;
        textPlacar.setText("Você: 0  |  PC: 0");
        textResultado.setText(getString(R.string.appResultado));
        imgResultado.setImageResource(R.drawable.padrao);
    }    