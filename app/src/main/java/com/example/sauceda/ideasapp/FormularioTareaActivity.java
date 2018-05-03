package com.example.sauceda.ideasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sauceda.ideasapp.modelo.Idea;
import com.example.sauceda.ideasapp.modelo.Tarea;
import com.example.sauceda.ideasapp.utils.App;
import com.example.sauceda.ideasapp.utils.ObtenerRealmID;


public class FormularioTareaActivity extends AppCompatActivity {

    EditText edtNombreTarea,edtDescripcionTarea;
    Button btnAgregar;
    Idea idea;
    int id;
    Tarea tarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_tarea);

        id=getIntent().getIntExtra("id",-1);
        idea=App.getRealm().where(Idea.class).equalTo("id",id).findFirst();

        edtNombreTarea=findViewById(R.id.etxNombreTarea);
        edtDescripcionTarea=findViewById(R.id.etxDescripcionTarea);
        btnAgregar=findViewById(R.id.btnAgregarTarea);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agregarTarea();


            }
        });
    }

    private void agregarTarea() {
        String nombreTarea=edtNombreTarea.getText().toString();
        String descripcionTarea=edtDescripcionTarea.getText().toString();

        tarea=new Tarea();
        App.getRealm().beginTransaction();
        tarea.setId(ObtenerRealmID.getIdTarea());
        tarea.setNombre(nombreTarea);
        tarea.setDescripcion(descripcionTarea);
        tarea.setStatus(false);
        App.getRealm().copyToRealmOrUpdate(tarea);
        idea.getTareas().add(tarea);
        App.getRealm().commitTransaction();
        startActivity(new Intent(FormularioTareaActivity.this,MainActivity.class));
        finish();


    }
}
