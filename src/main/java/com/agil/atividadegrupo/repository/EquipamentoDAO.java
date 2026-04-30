/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agil.atividadegrupo.repository;
import com.agil.atividadegrupo.model.DepartamentoDTO;
import com.agil.atividadegrupo.model.EquipamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class EquipamentoDAO {
    public List<EquipamentoDTO > lerTodos() {
        List<EquipamentoDTO > dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM equipamento");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                EquipamentoDTO equipamento = new EquipamentoDTO ();
                equipamento.setId(rs.getInt("id"));
                equipamento.setCodigo_patrimonio(rs.getString("codigo_patrimonio"));
                equipamento.setTipo(rs.getString("tipo"));
                equipamento.setMarca(rs.getString("marca"));
                equipamento.setId_departamento(rs.getInt("id_departamento"));
                dados.add(equipamento);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return dados;
    }
        public List<DepartamentoDTO> lerDepartamento() {
        List<DepartamentoDTO> dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("""
                        SELECT nome,andar FROM departamento
                        Inner join
                        bd_patrimonio.equipamento""");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                DepartamentoDTO departamento = new DepartamentoDTO();
                departamento.setNome(rs.getString("nome"));
                departamento.setAndar(rs.getInt("andar"));
                dados.add(departamento);
            }
        } catch(SQLException e ) {
            e.printStackTrace();
        }
        return dados;
    }    
}
