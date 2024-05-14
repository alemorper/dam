package com.dam.fitmaster;

public class Comida {
    private String dia;
    private String desayuno;
    private String almuerzo;
    private String merienda;
    private String cena;

    public Comida(String dia, String desayuno, String almuerzo, String merienda, String cena) {
        this.dia = dia;
        this.desayuno = desayuno;
        this.almuerzo = almuerzo;
        this.merienda = merienda;
        this.cena = cena;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(String desayuno) {
        this.desayuno = desayuno;
    }

    public String getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(String almuerzo) {
        this.almuerzo = almuerzo;
    }

    public String getMerienda() {
        return merienda;
    }

    public void setMerienda(String merienda) {
        this.merienda = merienda;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }
}
