/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agil.atividadegrupo.model;

/**
 *
 * @author Aluno
 */
public class EquipamentoDTO {
    private int id;
    private String codigo_patrimonio;
    private String tipo;
    private String marca;
    private int id_departamento;
    
    public EquipamentoDTO(){
        
    }
    public EquipamentoDTO(int id, String codigo_patrimonio, String tipo, String marca, int id_departamento) {
        this.id = id;
        this.codigo_patrimonio = codigo_patrimonio;
        this.tipo = tipo;
        this.marca = marca;
        this.id_departamento = id_departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_patrimonio() {
        return codigo_patrimonio;
    }

    public void setCodigo_patrimonio(String codigo_patrimonio) {
        this.codigo_patrimonio = codigo_patrimonio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
    
}

