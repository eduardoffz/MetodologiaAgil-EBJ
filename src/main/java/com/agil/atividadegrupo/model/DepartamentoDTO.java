/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agil.atividadegrupo.model;

/**
 *
 * @author Aluno
 */
public class DepartamentoDTO {
     private int id_departamento;
     private String nome;
      private int andar;

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(int id_departamento, String nome, int andar) {
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.andar = andar;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
      
}
