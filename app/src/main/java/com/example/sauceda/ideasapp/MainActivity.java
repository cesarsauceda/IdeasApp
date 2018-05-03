package com.example.sauceda.ideasapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sauceda.ideasapp.adaptador.IdeaAdapter;
import com.example.sauceda.ideasapp.modelo.Idea;
import com.example.sauceda.ideasapp.utils.App;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements IdeaAdapter.IdeaAdapterItemCallBack{

    RecyclerView rvIdeas;
    List<Idea> ideaList;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        rvIdeas=findViewById(R.id.rvIdeas);
        ideaList=new ArrayList<>();
        RecyclerView.LayoutManager lym=new LinearLayoutManager(this);
        rvIdeas.setLayoutManager(lym);
        IdeaAdapter ideaAdapter=new IdeaAdapter(ideaList,this);
        rvIdeas.setAdapter(ideaAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(MainActivity.this,FormularioIdeaActivity.class));
            }
        });

        getAllIdeas();

    }

    public int getAllIdeas() {
        RealmQuery<Idea> query= App.getRealm().where(Idea.class);
        RealmResults<Idea> results=query.findAll();

        for (int i=0;i<results.size();i++){
            Idea idea =results.get(i);
            App.getRealm().beginTransaction();
            App.getRealm().copyToRealmOrUpdate(idea);
            App.getRealm().commitTransaction();
            ideaList.add(idea);
        }

        return results.size();

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
    public void onIdeaItemSelected(int id) {
        Intent intent= new Intent(MainActivity.this,TareasActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
