/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agil.atividadegrupo.service;

import com.agil.atividadegrupo.model.DepartamentoDTO;
import com.agil.atividadegrupo.model.EquipamentoDTO;
import com.agil.atividadegrupo.repository.EquipamentoDAO;
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

    public List<EquipamentoDTO> lerTodos() {
        return repository.lerTodos();
    }
    public List<DepartamentoDTO> lerDepartamento(){
        return repository.lerDepartamento();
    }
}
