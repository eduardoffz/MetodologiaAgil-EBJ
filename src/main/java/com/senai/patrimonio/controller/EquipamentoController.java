package com.senai.patrimonio.controller;

import com.senai.patrimonio.dto.ContagemPorDepartamentoDTO;
import com.senai.patrimonio.dto.EquipamentoResponseDTO;
import com.senai.patrimonio.model.Equipamento;
import com.senai.patrimonio.service.EquipamentoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EquipamentoController {

    private EquipamentoService equipamentoService = new EquipamentoService();

    // EXERCÍCIO 1 - POST /api/equipamentos
 
    @PostMapping("/equipamentos")
    public ResponseEntity<String> cadastrar(@RequestBody Equipamento equipamento) {
        try {
            equipamentoService.cadastrarEquipamento(equipamento);
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body("Equipamento cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            // Regra de negócio: departamento não existe
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // EXERCÍCIO 2 - GET /api/equipamentos
  
    @GetMapping("/equipamentos")
    public ResponseEntity<List<EquipamentoResponseDTO>> listarTodos() {
        List<EquipamentoResponseDTO> lista = equipamentoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    // EXERCÍCIO 3 - PUT /api/equipamentos/{id}
   
    
    

    
    
    @PutMapping("/equipamentos/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id,
                                             @RequestBody Equipamento equipamento) {
        try {
            equipamentoService.atualizarEquipamento(id, equipamento);
            return ResponseEntity.ok("Equipamento atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // EXERCÍCIO 4 - DELETE /api/equipamentos/{id}
   
    @DeleteMapping("/equipamentos/{id}")
    public ResponseEntity<String> deletar(@PathVariable int id) {
        try {
            equipamentoService.deletarEquipamento(id);
            return ResponseEntity.ok("Equipamento removido do sistema com sucesso!");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // EXERCÍCIO 5 - GET /api/departamentos/{idDepartamento}/equipamentos teste
   
    @GetMapping("/departamentos/{idDepartamento}/equipamentos")
    public ResponseEntity<List<Equipamento>> listarPorDepartamento(
            @PathVariable int idDepartamento) {

        
        
        
        
        
        
        
        List<Equipamento> lista = equipamentoService.listarPorDepartamento(idDepartamento);
        return ResponseEntity.ok(lista);
    }


    
    
    
    
    
    
    
    
    
    
    @GetMapping("/equipamentos/busca")
    public ResponseEntity<?> buscarPorCodigo(@RequestParam String codigo) {
        try {
            Equipamento eq = equipamentoService.buscarPorCodigo(codigo);
            return ResponseEntity.ok(eq);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    
  
    @GetMapping("/relatorios/contagem-por-departamento")
    public ResponseEntity<List<ContagemPorDepartamentoDTO>> contagemPorDepartamento() {
        List<ContagemPorDepartamentoDTO> resultado = equipamentoService.contagemPorDepartamento();
        return ResponseEntity.ok(resultado);
    }
}
