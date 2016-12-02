package com.m2sili.convertisseur;

/**
 * Created by android on 11/16/16.
 */

public class Devise {
    private String nom;
    private double value;

    public Devise(String nom, double value) {
        this.nom = nom;
        this.value = value;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
