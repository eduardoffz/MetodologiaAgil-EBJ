/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.service;

import com.btech.gerenciamento.model.DepartamentoDTO;
import com.btech.gerenciamento.model.EquipamentoDTO;
import com.btech.gerenciamento.repository.EquipamentoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class EquipamentoService {
    
    @Autowired
    private EquipamentoDAO repository;
    
    
    //Exerc 3
    public void editarEquipamento(EquipamentoDTO equipamento){
        repository.editar(equipamento);
    }
     //fim ex3
    
    
    public List<EquipamentoDTO> lerTodos() {
        return repository.lerTodos();
    }
    
    public List<DepartamentoDTO> lerDepartamento(){
        return repository.lerDepartamento();
    }
    
    
}
