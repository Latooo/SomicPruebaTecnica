package com.farmacia.farmacia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Facturakardex")
public class FacturaKardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fakId;

    @ManyToOne
    @JoinColumn(name = "FakFac")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "FakArt")
    private Articulo articulo;

    private String fakNat;
    private int fakUni;
    private double fakCos;
    private double fakPre;
    private double fakTotVen;
    private double fakTotCos;

    public int getFakId() {
        return fakId;
    }

    public void setFakId(int fakId) {
        this.fakId = fakId;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getFakNat() {
        return fakNat;
    }

    public void setFakNat(String fakNat) {
        this.fakNat = fakNat;
    }

    public int getFakUni() {
        return fakUni;
    }

    public void setFakUni(int fakUni) {
        this.fakUni = fakUni;
    }

    public double getFakCos() {
        return fakCos;
    }

    public void setFakCos(double fakCos) {
        this.fakCos = fakCos;
    }

    public double getFakPre() {
        return fakPre;
    }

    public void setFakPre(double fakPre) {
        this.fakPre = fakPre;
    }

    public double getFakTotVen() {
        return fakTotVen;
    }

    public void setFakTotVen(double fakTotVen) {
        this.fakTotVen = fakTotVen;
    }

    public double getFakTotCos() {
        return fakTotCos;
    }

    public void setFakTotCos(double fakTotCos) {
        this.fakTotCos = fakTotCos;
    }
}
