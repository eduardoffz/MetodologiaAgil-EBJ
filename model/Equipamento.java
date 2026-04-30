package com.senai.patrimonio.model;


public class Equipamento {

    private int id;
    private String codigoPatrimonio;
    private String tipo;
    private String marca;
    private int idDepartamento;

    // Construtor vazio
    public Equipamento() {}

    public Equipamento(String codigoPatrimonio, String tipo, String marca, int idDepartamento) {
        this.codigoPatrimonio = codigoPatrimonio;
        this.tipo = tipo;
        this.marca = marca;
        this.idDepartamento = idDepartamento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigoPatrimonio() { return codigoPatrimonio; }
    public void setCodigoPatrimonio(String codigoPatrimonio) { this.codigoPatrimonio = codigoPatrimonio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(int idDepartamento) { this.idDepartamento = idDepartamento; }

    @Override
    public String toString() {
        return "Equipamento{id=" + id +
               ", codigoPatrimonio='" + codigoPatrimonio + "'" +
               ", tipo='" + tipo + "'" +
               ", marca='" + marca + "'" +
               ", idDepartamento=" + idDepartamento + "}";
    }
}
