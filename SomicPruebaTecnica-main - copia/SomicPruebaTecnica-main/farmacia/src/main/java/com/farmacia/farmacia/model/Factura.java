package com.farmacia.farmacia.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facId;

    private String facNum;
    private Date facFec;
    private Date facVen;

    @ManyToOne
    @JoinColumn(name = "FacNit")
    private Nit nit;

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public String getFacNum() {
        return facNum;
    }

    public void setFacNum(String facNum) {
        this.facNum = facNum;
    }

    public Date getFacFec() {
        return facFec;
    }

    public void setFacFec(Date facFec) {
        this.facFec = facFec;
    }

    public Date getFacVen() {
        return facVen;
    }

    public void setFacVen(Date facVen) {
        this.facVen = facVen;
    }

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
        this.nit = nit;
    }
}
