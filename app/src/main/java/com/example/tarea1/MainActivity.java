package com.example.tarea1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= findViewById(R.id.textView);
    }
public void btEnviar(View View){
    EditText Ncedula= findViewById( R.id.edTxNucedula);
    EditText Usuario= findViewById( R.id.edTexTexNombre);
    Usuario.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
    EditText Email= findViewById( R.id.editTexEmail);
    EditText Ciudad= findViewById( R.id.edTextCiudad);
    Ciudad.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
    RadioButton Genero= findViewById( R.id.rbFemenino);
    EditText Ntelefono= findViewById( R.id.editTextTelefono);
    String varCedula,varUsuario,varEmail,varGenero,
            varCiudad,varTelefono;

    varGenero=Genero.isChecked()?"ESTIMADA":"ESTIMADO";
    varCedula=Ncedula.getText().toString();
    varUsuario=Usuario.getText().toString();
    varCiudad=Ciudad.getText().toString();
    varEmail=Email.getText().toString();
    varTelefono=Ntelefono.getText().toString();
    Intent intent= new Intent(MainActivity.this,MainActivity2.class);

    Bundle b= new Bundle();
    b.putString("CEDULA",varCedula);
    b.putString("NOMBRE",varUsuario);
    b.putString("CUIDAD",varCiudad);
    b.putString("GENERO",varGenero);
    b.putString("CORREO",varEmail);
    b.putString("TELEFONO",varTelefono);
    intent.putExtras(b);
    startActivity(intent);


}
public void abrirCalendario(View view){
    Calendar calen= Calendar.getInstance();
    int año= calen.get(Calendar.YEAR);
    int mes= calen.get(Calendar.MONTH);
    int dia= calen.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog dpd= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Bundle b= new Bundle();
            String varFnacimi;
            TextView tvi= findViewById(R.id.btCalendar);
            String fecha= dayOfMonth + "/" + month + "/" + year;
            varFnacimi=tvi.getText().toString();
            b.putString("NACIMIENTO",varFnacimi);
            tv.setText(fecha);


        }
    },año,mes,dia);
    dpd.show();
}
public void limpiar (View view){
        Intent intent= new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
}
}