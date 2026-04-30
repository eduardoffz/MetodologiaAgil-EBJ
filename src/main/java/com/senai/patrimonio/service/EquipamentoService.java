package com.senai.patrimonio.service;

import com.senai.patrimonio.dto.ContagemPorDepartamentoDTO;
import com.senai.patrimonio.dto.EquipamentoResponseDTO;
import com.senai.patrimonio.model.Departamento;
import com.senai.patrimonio.model.Equipamento;
import com.senai.patrimonio.repository.DepartamentoRepository;
import com.senai.patrimonio.repository.EquipamentoRepository;

import java.util.List;


public class EquipamentoService {

    // Instâncias dos repositories necessários
    private EquipamentoRepository equipamentoRepository = new EquipamentoRepository();
    private DepartamentoRepository departamentoRepository = new DepartamentoRepository();


    // EXERCÍCIO 1 - CREATE com validação de departamento

    
   
    public boolean cadastrarEquipamento(Equipamento equipamento) {
        // regr: Verificar se o idDepartamento existe 
        Departamento dep = departamentoRepository.buscarPorId(equipamento.getIdDepartamento());

        if (dep == null) {
            // Departamento inválido retorna o err
            throw new IllegalArgumentException(
                "Departamento inválido: id " + equipamento.getIdDepartamento() + " não encontrado."
            );
        }

        // Departamento válido
        return equipamentoRepository.inserir(equipamento);
    }


    // EXERCÍCIO 2 - READ: Listar todos com JOIN
    
    
    

    public List<EquipamentoResponseDTO> listarTodos() {
        return equipamentoRepository.listarTodosComDepartamento();
    }


    // EXERCÍCIO 3 - UPDATE: Transferência de setor

    
    public boolean atualizarEquipamento(int id, Equipamento equipamento) {
        // Valida o novo departamento antes de atualizar
        Departamento dep = departamentoRepository.buscarPorId(equipamento.getIdDepartamento());
        if (dep == null) {
            throw new IllegalArgumentException(
                "Departamento inválido: id " + equipamento.getIdDepartamento() + " não encontrado."
            );
        }

        boolean atualizado = equipamentoRepository.atualizar(id, equipamento);
        if (!atualizado) {
            throw new RuntimeException("Equipamento com id " + id + " não encontrado.");
        }
        return true;
    }

    // EXERCÍCIO 4 - DELETE: Baixa de patrimônio

    
    
    public boolean deletarEquipamento(int id) {
        boolean deletado = equipamentoRepository.deletar(id);
        if (!deletado) {
            throw new RuntimeException("Equipamento com id " + id + " não encontrado.");
        }
        return true;
    }

    // EXERCÍCIO 5 - Auditoria por departamento
  
    public List<Equipamento> listarPorDepartamento(int idDepartamento) {
        return equipamentoRepository.listarPorDepartamento(idDepartamento);
    }

    // EXERCÍCIO 6 - Busca por código patrimônio (Query Param)
  
    
    
    
    public Equipamento buscarPorCodigo(String codigo) {
        Equipamento eq = equipamentoRepository.buscarPorCodigo(codigo);
        if (eq == null) {
            throw new RuntimeException("Equipamento com código '" + codigo + "' não encontrado.");
        }
        return eq;
    }


    // EXERCÍCIO 7 - Dashboard: Contagem por departamento
   
    public List<ContagemPorDepartamentoDTO> contagemPorDepartamento() {
        return equipamentoRepository.contagemPorDepartamento();
    }
}
