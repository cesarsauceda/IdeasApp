package com.example.sauceda.ideasapp.utils;

import com.example.sauceda.ideasapp.modelo.Idea;
import com.example.sauceda.ideasapp.modelo.Tarea;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by sauceda on 10/02/18.
 */

public class ObtenerRealmID {

    public static int getIdIdea(){

        int idInc=0;
        RealmQuery<Idea>query=App.getRealm().where(Idea.class);
        RealmResults<Idea>results=query.findAllSorted("id", Sort.DESCENDING);

        for(int i=0;i<results.size();i++){
            Idea idea=results.get(i);
            idInc=idea.getId()+1;
            break;
        }
        return idInc;
    }
    public static int getIdTarea(){

        int idInc=0;
        RealmQuery<Tarea>query=App.getRealm().where(Tarea.class);
        RealmResults<Tarea>results=query.findAllSorted("id", Sort.DESCENDING);

        for(int i=0;i<results.size();i++){
            Tarea tarea=results.get(i);
            idInc=tarea.getId()+1;
            break;
        }
        return idInc;
    }

}
