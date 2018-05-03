package com.example.sauceda.ideasapp.modelo;

import com.example.sauceda.ideasapp.adaptador.IdeaAdapter;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sauceda on 10/02/18.
 */

public class Idea extends RealmObject{

    @PrimaryKey
    private  int id;
    private String nombre;
    private  String descripcion;

    private RealmList<Tarea> tareas;

    public Idea(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Idea() {
        this.id = -1;
        this.nombre = "";
        this.descripcion = "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public RealmList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(RealmList<Tarea> tareas) {
        this.tareas = tareas;
    }
}
