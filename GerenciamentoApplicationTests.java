/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.controller;

import com.btech.gerenciamento.model.EquipamentoDTO;
import com.btech.gerenciamento.model.DepartamentoDTO;
import com.btech.gerenciamento.service.EquipamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
//Exec 3
@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoAPIController {
    
    @Autowired
    private EquipamentoService equipamentoService;
    
    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody EquipamentoDTO equipamento){
        
        equipamento.setId(id);
        equipamentoService.editarEquipamento(equipamento);
       return "Equipamento atualizado com sucesso!"; 
    }
    //fim ex3
    @GetMapping
    public List<EquipamentoDTO> listarTodos() {
        return equipamentoService.lerTodos();
    }
    
    @GetMapping("/departamento")
    public List<DepartamentoDTO> lerDepartamento(){
        return equipamentoService.lerDepartamento();
    }
}
