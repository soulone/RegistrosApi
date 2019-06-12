package com.soulone.registrosapi.models;

public class Solicitud {
    Integer id;
    String email;
    String tipo;
    String motico;

    public Solicitud() {
    }

    public Solicitud(Integer id, String email, String tipo, String motico) {
        this.id = id;
        this.email = email;
        this.tipo = tipo;
        this.motico = motico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotico() {
        return motico;
    }

    public void setMotico(String motico) {
        this.motico = motico;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", tipo='" + tipo + '\'' +
                ", motico='" + motico + '\'' +
                '}';
    }
}
