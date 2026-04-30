package com.senai.patrimonio.repository;

import com.senai.patrimonio.model.Departamento;
import java.sql.*;

/**
 * REPOSITORY - DepartamentoRepository
 *
 
public class DepartamentoRepository {

    /**
     * Exercício 1 - Regra de Negócio: verificar se idDepartamento existe.
     *
     * @param id ID do departamento
     * @return Departamento encontrado, ou null se não existir
     */
    public Departamento buscarPorId(int id) {
        String sql = "SELECT id, nome, andar FROM departamento WHERE id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Departamento dep = new Departamento();
                dep.setId(rs.getInt("id"));
                dep.setNome(rs.getString("nome"));
                dep.setAndar(rs.getInt("andar"));
                return dep;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar departamento: " + e.getMessage());
        }

        return null; // Departamento não encontrado
    }
}
