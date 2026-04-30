/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.repository;

import com.btech.gerenciamento.model.EquipamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class EquipamentoDAO {
    
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
