package com.example.eider.basededatossqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCodigo, etCurso, etCarrera;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo=(EditText)findViewById(R.id.etCodigo);
        etCurso=(EditText)findViewById(R.id.etCurso);
        etCarrera=(EditText)findViewById(R.id.etCarrera);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);

        final Mantenimiento mantenimiento=new Mantenimiento(getApplicationContext());

        btnAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mantenimiento.agregarCursos(etCodigo.getText().toString(),etCurso.getText().toString(),etCarrera.getText().toString());
                Toast.makeText(getApplicationContext(),"REGISTRADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
                etCodigo.setText("");
                etCurso.setText("");
                etCarrera.setText("");
            }
        });
    }

}
