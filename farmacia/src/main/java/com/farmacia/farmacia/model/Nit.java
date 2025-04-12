package com.farmacia.farmacia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Nits")
public class Nit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nitId;

    private String nitNom;
    private String nitDoc;
    private double nitCup;
    private int nitPla;

    public int getNitId() {
        return nitId;
    }

    public void setNitId(int nitId) {
        this.nitId = nitId;
    }

    public String getNitNom() {
        return nitNom;
    }

    public void setNitNom(String nitNom) {
        this.nitNom = nitNom;
    }

    public String getNitDoc() {
        return nitDoc;
    }

    public void setNitDoc(String nitDoc) {
        this.nitDoc = nitDoc;
    }

    public double getNitCup() {
        return nitCup;
    }

    public void setNitCup(double nitCup) {
        this.nitCup = nitCup;
    }

    public int getNitPla() {
        return nitPla;
    }

    public void setNitPla(int nitPla) {
        this.nitPla = nitPla;
    }
}
