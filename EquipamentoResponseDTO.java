package com.senai.patrimonio.dto;

/**
 * DTO - EquipamentoResponseDTO
 *
 * Exercício 2: O Relatório Geral de Patrimônio (READ com JOIN)
 *

 */
public class EquipamentoResponseDTO {

    private int id;
    private String codigoPatrimonio;
    private String tipo;
    private String marca;
    private String nomeDepartamento; // Vem do JOIN
    private int andar;               // Vem do JOIN

    // Construtor vazio
    public EquipamentoResponseDTO() {}

    public EquipamentoResponseDTO(int id, String codigoPatrimonio, String tipo,
                                   String marca, String nomeDepartamento, int andar) {
        this.id = id;
        this.codigoPatrimonio = codigoPatrimonio;
        this.tipo = tipo;
        this.marca = marca;
        this.nomeDepartamento = nomeDepartamento;
        this.andar = andar;
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

    public String getNomeDepartamento() { return nomeDepartamento; }
    public void setNomeDepartamento(String nomeDepartamento) { this.nomeDepartamento = nomeDepartamento; }

    public int getAndar() { return andar; }
    public void setAndar(int andar) { this.andar = andar; }
}
