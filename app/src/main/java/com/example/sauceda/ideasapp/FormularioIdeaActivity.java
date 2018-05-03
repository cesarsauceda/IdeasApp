package com.example.sauceda.ideasapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sauceda.ideasapp.modelo.Idea;
import com.example.sauceda.ideasapp.utils.App;
import com.example.sauceda.ideasapp.utils.ObtenerRealmID;
import com.google.gson.Gson;

public class FormularioIdeaActivity extends AppCompatActivity {

    EditText nombreIdea, descripcionIdea;
    Button btnAgregar;
    Idea idea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_idea);

        nombreIdea=findViewById(R.id.etNombre);
        descripcionIdea=findViewById(R.id.etDescripcion);
        btnAgregar=findViewById(R.id.btnAgregar);

        //Gson gson = new Gson();
        //String jsonObject=gson.toJson()

        //
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("idea",nombreIdea.getText().toString());
        editor.putString("descripcion",descripcionIdea.getText().toString());
        editor.commit();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=nombreIdea.getText().toString();
                String descripcion=descripcionIdea.getText().toString();

                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(FormularioIdeaActivity.this);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("idea",nombreIdea.getText().toString());
                editor.putString("descripcion",descripcionIdea.getText().toString());
                editor.commit();

                idea=new Idea();
                App.getRealm().beginTransaction();
                idea.setId(ObtenerRealmID.getIdIdea());
                idea.setNombre(nombre);
                idea.setDescripcion(descripcion);
                App.getRealm().copyToRealmOrUpdate(idea);
                App.getRealm().commitTransaction();
                startActivity(new Intent(FormularioIdeaActivity.this,MainActivity.class));
                finish();
            }
        });

    }
}
