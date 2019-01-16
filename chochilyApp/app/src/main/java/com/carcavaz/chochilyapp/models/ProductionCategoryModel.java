package com.carcavaz.chochilyapp.models;

import android.support.annotation.ColorInt;

public class ProductionCategoryModel {

    private String Id;
    private String ImageSrc;
    private String Nombre;
    private Long Creacion;
    private boolean Activa;
    private String color;

    public ProductionCategoryModel() {

    }

    public ProductionCategoryModel(String id, String imageSrc, String nombre, Long creacion, boolean activa, String color) {
        Id = id;
        ImageSrc = imageSrc;
        Nombre = nombre;
        Creacion = creacion;
        Activa = activa;
        this.color = color;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getImageSrc() {
        return ImageSrc;
    }

    public void setImageSrc(String imageSrc) {
        ImageSrc = imageSrc;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Long getCreacion() {
        return Creacion;
    }

    public void setCreacion(Long creacion) {
        Creacion = creacion;
    }

    public boolean isActiva() {
        return Activa;
    }

    public void setActiva(boolean activa) {
        Activa = activa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
