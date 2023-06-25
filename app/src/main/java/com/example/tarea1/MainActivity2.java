package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

      TextView datosingre= (TextView) findViewById(R.id.textDatos);
      Bundle bundle= this.getIntent().getExtras();

        datosingre.setText("HOLA! "+bundle.getString("GENERO") + "\n" + "SU NOMBRE ES=" + "  "
                + bundle.getString("NOMBRE" )+ "\n"
                + "Número de cédula:= " + " "+ bundle.getString("CEDULA")+ "\n"
                + "Fecha de nacimiento:= " + " "+ bundle.getString("FNACIMIENTO") + "\n"
                + "Ciudad de residencia: = "+ " "+ bundle.getString("CUIDAD")+ "\n"
                + "Correo:= "+ " "+ bundle.getString("CORREO")+ "\n"
                + "Telefono:= "+ " "+ bundle.getString("TELEFONO"));


    }
}