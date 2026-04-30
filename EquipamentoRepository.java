package com.senai.patrimonio.repository;

import com.senai.patrimonio.dto.ContagemPorDepartamentoDTO;
import com.senai.patrimonio.dto.EquipamentoResponseDTO;
import com.senai.patrimonio.model.Equipamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EquipamentoRepository {

    // =========================================================
    // EXERCÍCIO 1 - CREATE: Cadastrar novo equipamento
    // POST /api/equipamentos
    // =========================================================

    /**
     * Insere um novo equipamento na tabela.
     * Chamado APÓS a validação do departamento no Service.
     *
     * @param equipamento Objeto com os dados a serem inseridos
     * @return true se inseriu com sucesso, false caso contrário
     */
    public boolean inserir(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (codigo_patrimonio, tipo, marca, id_departamento) " +
                     "VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getCodigoPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getMarca());
            stmt.setInt(4, equipamento.getIdDepartamento());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir equipamento: " + e.getMessage());
            return false;
        }
    }

    // =========================================================
    // EXERCÍCIO 2 - READ com JOIN: Relatório geral de patrimônio
    // GET /api/equipamentos
    // =========================================================

    /**
     * Lista todos os equipamentos com nome e andar do departamento.
     * Usa INNER JOIN para trazer dados da tabela departamento.
     * Retorna DTO (sem o id_departamento cru).
     *
     * @return Lista de EquipamentoResponseDTO
     */
    public List<EquipamentoResponseDTO> listarTodosComDepartamento() {
        List<EquipamentoResponseDTO> lista = new ArrayList<>();

        // INNER JOIN: combina equipamento com departamento
        String sql = "SELECT e.id, e.codigo_patrimonio, e.tipo, e.marca, " +
                     "       d.nome AS nome_departamento, d.andar " +
                     "FROM equipamento e " +
                     "INNER JOIN departamento d ON e.id_departamento = d.id";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                EquipamentoResponseDTO dto = new EquipamentoResponseDTO();
                dto.setId(rs.getInt("id"));
                dto.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
                dto.setTipo(rs.getString("tipo"));
                dto.setMarca(rs.getString("marca"));
                dto.setNomeDepartamento(rs.getString("nome_departamento"));
                dto.setAndar(rs.getInt("andar"));
                lista.add(dto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar equipamentos: " + e.getMessage());
        }

        return lista;
    }

    // =========================================================
    // EXERCÍCIO 3 - UPDATE: Transferência de setor
    // PUT /api/equipamentos/{id}
    // =========================================================

  
    public boolean atualizar(int id, Equipamento equipamento) {
        String sql = "UPDATE equipamento " +
                     "SET codigo_patrimonio = ?, tipo = ?, marca = ?, id_departamento = ? " +
                     "WHERE id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getCodigoPatrimonio());
            stmt.setString(2, equipamento.getTipo());
            stmt.setString(3, equipamento.getMarca());
            stmt.setInt(4, equipamento.getIdDepartamento());
            stmt.setInt(5, id);

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // false = nenhum equipamento com esse id

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar equipamento: " + e.getMessage());
            return false;
        }
    }

    // EXERCÍCIO 4 - DELETE: Baixa de patrimônio
  
    public boolean deletar(int id) {
        // DELETE FROM equipamento WHERE id = ?
        String sql = "DELETE FROM equipamento WHERE id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar equipamento: " + e.getMessage());
            return false;
        }
    }

    // EXERCÍCIO 5 - Auditoria: Equipamentos por departamento
   
    public List<Equipamento> listarPorDepartamento(int idDepartamento) {
        List<Equipamento> lista = new ArrayList<>();

        String sql = "SELECT id, codigo_patrimonio, tipo, marca, id_departamento " +
                     "FROM equipamento " +
                     "WHERE id_departamento = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDepartamento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Equipamento eq = new Equipamento();
                eq.setId(rs.getInt("id"));
                eq.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
                eq.setTipo(rs.getString("tipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setIdDepartamento(rs.getInt("id_departamento"));
                lista.add(eq);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar por departamento: " + e.getMessage());
        }

        return lista;
    }

    // EXERCÍCIO 6 - Busca por etiqueta (Query Param)
    
    public Equipamento buscarPorCodigo(String codigoPatrimonio) {
        // SELECT * FROM equipamento WHERE codigo_patrimonio = ?
        String sql = "SELECT id, codigo_patrimonio, tipo, marca, id_departamento " +
                     "FROM equipamento " +
                     "WHERE codigo_patrimonio = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigoPatrimonio);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Equipamento eq = new Equipamento();
                eq.setId(rs.getInt("id"));
                eq.setCodigoPatrimonio(rs.getString("codigo_patrimonio"));
                eq.setTipo(rs.getString("tipo"));
                eq.setMarca(rs.getString("marca"));
                eq.setIdDepartamento(rs.getInt("id_departamento"));
                return eq;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar por código: " + e.getMessage());
        }

        return null; // 404 Not Found
    }

    // EXERCÍCIO 7 - Dashboard: Contagem por departamento (GROUP BY) teste2

    /**
     * Retorna a quantidade de equipamentos por departamento.
     *
     */
    public List<ContagemPorDepartamentoDTO> contagemPorDepartamento() {
        List<ContagemPorDepartamentoDTO> lista = new ArrayList<>();

        // COUNT e GROUP BY: agrupa equipamentos por departamento
        
        
        
        String sql = "SELECT d.nome AS departamento, COUNT(e.id) AS total_equipamentos " +
                     "FROM departamento d " +
                     "LEFT JOIN equipamento e ON e.id_departamento = d.id " +
                     "GROUP BY d.id, d.nome " +
                     "ORDER BY total_equipamentos DESC";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ContagemPorDepartamentoDTO dto = new ContagemPorDepartamentoDTO();
                dto.setDepartamento(rs.getString("departamento"));
                dto.setTotalEquipamentos(rs.getInt("total_equipamentos"));
                lista.add(dto);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao contar por departamento: " + e.getMessage());
        }

        return lista;
    }
}
