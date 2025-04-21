package com.farmacia.farmacia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artId;

    private String artCod;
    private String artNom;
    private String artLab;
    private int artSal;
    private double artCos;
    private double artPre;

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getArtCod() {
        return artCod;
    }

    public void setArtCod(String artCod) {
        this.artCod = artCod;
    }

    public String getArtNom() {
        return artNom;
    }

    public void setArtNom(String artNom) {
        this.artNom = artNom;
    }

    public String getArtLab() {
        return artLab;
    }

    public void setArtLab(String artLab) {
        this.artLab = artLab;
    }

    public int getArtSal() {
        return artSal;
    }

    public void setArtSal(int artSal) {
        this.artSal = artSal;
    }

    public double getArtCos() {
        return artCos;
    }

    public void setArtCos(double artCos) {
        this.artCos = artCos;
    }

    public double getArtPre() {
        return artPre;
    }

    public void setArtPre(double artPre) {
        this.artPre = artPre;
    }
}
