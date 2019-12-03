package com.db1.cidades_api.controller;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.domain.entity.Conta;
import com.db1.cidades_api.dto.ContaRequestDTO;
import com.db1.cidades_api.dto.ContaRequestDTO;
import com.db1.cidades_api.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("contas")
@RestController
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> buscarTodasContas(){
        return contaService.buscarTodos();
    }

    @GetMapping(path = "{id}")
    public Conta  buscarContaPorId(@PathVariable Long id){
        return contaService.buscarPorId(id);
    }

    @GetMapping(path = "{ids}")
    public List<Conta> buscarContaPorListaIds(@PathVariable List<Long> ids){
        return contaService.buscarTodosPorId(ids);
    }

    @PostMapping
    public void criarConta(@RequestBody ContaRequestDTO contaRequestDTO){
        contaService.criar(contaRequestDTO.getSaldo(), contaRequestDTO.getAgencia(), contaRequestDTO.getCliente());
    }

    @DeleteMapping(path = "{nome}")
    public void deletarTodasAsContas(@PathVariable String nome){
        contaService.deletarTodos();
    }

    @PutMapping(path = "{id}")
    public void atualizarConta(@PathVariable long id, @RequestBody ContaRequestDTO contaRequestDTO){
        contaService.atualizar(id , contaRequestDTO.getSaldo(), contaRequestDTO.getAgencia(), contaRequestDTO.getCliente());
    }
}
