/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agil.atividadegrupo.controller;

import com.agil.atividadegrupo.model.DepartamentoDTO;
import com.agil.atividadegrupo.model.EquipamentoDTO;
import com.agil.atividadegrupo.service.EquipamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoAPIController {
    @Autowired
    private EquipamentoService funcionarioService;

    @GetMapping
    public List<EquipamentoDTO> listarTodos() {
        return funcionarioService.lerTodos();
    }
    @GetMapping("/departamento")
    public List<DepartamentoDTO> lerDepartamento(){
        return funcionarioService.lerDepartamento();
    }
}
