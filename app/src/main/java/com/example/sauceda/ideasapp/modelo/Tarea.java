package com.example.sauceda.ideasapp.modelo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sauceda on 10/02/18.
 */

public class Tarea extends RealmObject {

    @PrimaryKey
    private int id;
    private String nombre;
    private String descripcion;
    private boolean status;

    public Tarea(int id, String nombre, String descripcion, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.status = status;
    }

    public Tarea() {
        this.id = -1;
        this.nombre = "";
        this.descripcion = "";
        this.status = false;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
