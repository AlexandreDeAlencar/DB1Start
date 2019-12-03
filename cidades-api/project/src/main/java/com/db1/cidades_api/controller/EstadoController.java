package com.db1.cidades_api.controller;

import com.db1.cidades_api.adaptar.EstadoAdapter;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.dto.EstadoRequestDTO;
import com.db1.cidades_api.dto.EstadoResponseDTO;
import com.db1.cidades_api.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("estados")
@RestController
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<EstadoResponseDTO> buscarTodosEstados(){
       List<Estado> estados = estadoService.buscarTodos();
       List<EstadoResponseDTO> listaDeRetorno = new ArrayList<>();

            estados.forEach(estado -> {
            EstadoResponseDTO meuEstadoResponseDto = EstadoAdapter.transformarEntidadeEmDto(estado);
           listaDeRetorno.add(meuEstadoResponseDto);
            }
        );

        return listaDeRetorno;
    }

    @GetMapping("/nome")
    public EstadoResponseDTO buscarEstadoPorNome(@RequestBody EstadoRequestDTO estadoRequestDTO){
        return EstadoAdapter.transformarEntidadeEmDto(estadoService.buscarPorNome(estadoRequestDTO.getNome()));
    }

    @PostMapping
    public void criarEstado(@RequestBody EstadoRequestDTO estadoRequestDTO){
        estadoService.criar(estadoRequestDTO.getNome());
    }

    @DeleteMapping(path = "{nome}")
    public void deletarEstado(@PathVariable String nome){
        estadoService.deletarPorNome(nome);
    }

    @PutMapping(path = "{id}")
    public void atualizarEstado(@PathVariable long id, @RequestBody EstadoRequestDTO estadoRequestDTO){
        estadoService.atualizar(id , estadoRequestDTO.getNome());
    }
}
