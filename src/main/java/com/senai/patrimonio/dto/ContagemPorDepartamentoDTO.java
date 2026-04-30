package com.senai.patrimonio.dto;

/**
 *
 *
 * * }
 */
public class ContagemPorDepartamentoDTO {

    private String departamento;
    private int totalEquipamentos;

    // Construtor vazio
    public ContagemPorDepartamentoDTO() {}

    public ContagemPorDepartamentoDTO(String departamento, int totalEquipamentos) {
        this.departamento = departamento;
        this.totalEquipamentos = totalEquipamentos;
    }

    // Getters e Setters
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public int getTotalEquipamentos() { return totalEquipamentos; }
    public void setTotalEquipamentos(int totalEquipamentos) { this.totalEquipamentos = totalEquipamentos; }
}
