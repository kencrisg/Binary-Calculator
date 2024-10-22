package com.example.calculadorabinaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int numero1, numero2;
    TextView txtNumber1, txtNumber2, lblResultado;
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision;


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

        txtNumber1 = findViewById(R.id.txtNumber1);
        txtNumber2 = findViewById(R.id.txtNumber2);
        lblResultado =  findViewById(R.id.lblResultado);

        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);

    }

    public void asignarNumeros(){
         numero1 = Integer.parseInt(txtNumber1.getText().toString(), 2);
         numero2 = Integer.parseInt(txtNumber2.getText().toString(), 2);
    }
    public void realizarSuma(View v) {
        try {
            asignarNumeros();
            int resultado = numero1 + numero2;
            lblResultado.setText(Integer.toBinaryString(resultado));
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Números no válidos");
        }
    }

    public void realizarResta(View v) {
        try {
            asignarNumeros();
            int resultado = numero1 - numero2;
            lblResultado.setText(Integer.toBinaryString(resultado));
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Números no válidos");
        }
    }

    public void realizarMultiplicacion(View v) {
        try {
            asignarNumeros();
            int resultado = numero1 * numero2;
            lblResultado.setText(Integer.toBinaryString(resultado));
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Números no válidos");
        }
    }

    public void realizarDivision(View v) {
        try {
            asignarNumeros();
            if (numero2 != 0) {
                int resultado = numero1 / numero2;
                lblResultado.setText(Integer.toBinaryString(resultado));
            } else {
                lblResultado.setText("Error: No se puede dividir para 0");
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: Números no válidos");
        }
    }

}