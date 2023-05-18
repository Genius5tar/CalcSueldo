package com.example.calcsueldo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText sueldo;
    private EditText nHrs;
    private RadioGroup radioGroup;
    private TextView miPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sueldo = findViewById(R.id.sueldo);
        nHrs = findViewById(R.id.nHrs);
        radioGroup = findViewById(R.id.radioGroup);
        miPago = findViewById(R.id.miPago);

        Button Rbutton = findViewById(R.id.Rbutton);
        Rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                int value=0;

                if (selectedId != -1) {
                    if (selectedId == R.id.radioButton1) {
                        value=1;
                    } else if (selectedId == R.id.radioButton2) {
                        value=0;
                    }
                }

                int salarioBase = Integer.parseInt(sueldo.getText().toString());
                int horas = Integer.parseInt(nHrs.getText().toString());
                int resultado = calculoSueldo(salarioBase, horas, value);
                miPago.setText(String.valueOf(resultado));
            }
        });
    }

    private int calculoSueldo(int salarioBase, int noHrs, int noBono) {
        // Defino variables para el cálculo
        int hora;
        double horasExtra;
        double bonos;
        double obligaciones;
        double sueldoTotal;
        int sueldoFinal;

        // Realizo los cálculos pertinentes según la lógica requerida
        obligaciones = salarioBase * 0.085;
        hora = salarioBase / 192;
        horasExtra = (hora * 0.25) * noHrs;
        bonos = (salarioBase * 0.05) * noBono;
        sueldoTotal = salarioBase + horasExtra + bonos;
        sueldoFinal = (int) Math.round(sueldoTotal - obligaciones);

        // Retorno el cálculo de todas las operaciones anteriores en formato int de la variable sueldoFinal
        return sueldoFinal;
    }
}
