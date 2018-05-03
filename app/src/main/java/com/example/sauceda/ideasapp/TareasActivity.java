package com.example.sauceda.ideasapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sauceda.ideasapp.adaptador.TareaAdapter;
import com.example.sauceda.ideasapp.modelo.Idea;
import com.example.sauceda.ideasapp.modelo.Tarea;
import com.example.sauceda.ideasapp.utils.App;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmQuery;
import io.realm.RealmResults;

public class TareasActivity extends AppCompatActivity implements TareaAdapter.TareaAdapterItemCallBack {

    RecyclerView rvTareas;
    List<Tarea> tareaList;
    int id;
    Idea idea;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        rvTareas=findViewById(R.id.rvTareas);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String nombreIdea=sharedPreferences.getString("idea","");
        String descripcionIdea=sharedPreferences.getString("descripcion","");

        id = getIntent().getIntExtra("id",-1);
        idea=App.getRealm().where(Idea.class).equalTo("id",id).findFirst();
        tareaList = new ArrayList<>();

        for (int i=0;i<idea.getTareas().size();i++){
            Tarea tarea=idea.getTareas().get(i);
            tareaList.add(tarea);
        }

        RecyclerView.LayoutManager lym=new LinearLayoutManager(this);
        rvTareas.setLayoutManager(lym);
        TareaAdapter tareaAdapter=new TareaAdapter(tareaList,this);
        rvTareas.setAdapter(tareaAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TareasActivity.this,FormularioTareaActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_advertencia) {
            Toast.makeText(this, "Precionaste el botón", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onTareaItemSelected(int id) {

    }
}
