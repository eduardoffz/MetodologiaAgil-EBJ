/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.repository;

import com.btech.gerenciamento.model.DepartamentoDTO;
import com.btech.gerenciamento.model.EquipamentoDTO;
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
        
    //Ex 3
    public void editar(EquipamentoDTO equipamento){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("UPDATE equipamento SET tipo = ?, marca = ?, id_departamento=? WHERE id=?");
            
            stmt.setString(1, equipamento.getTipo());
            stmt.setString(2, equipamento.getMarca());
            stmt.setInt(3, equipamento.getId_departamento());
             stmt.setInt(4, equipamento.getId());
            
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
     //fim ex3
   
    
}
