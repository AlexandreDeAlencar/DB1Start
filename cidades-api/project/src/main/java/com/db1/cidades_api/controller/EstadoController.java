package com.db1.cidades_api.controller;

import com.db1.cidades_api.adapter.EstadoAdapter;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.requestdto.EstadoRequestDTO;
import com.db1.cidades_api.responsedto.EstadoResponseDTO;
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
    public List<EstadoResponseDTO> buscarEstadoPorNome(@RequestBody EstadoRequestDTO estadoRequestDTO){
        List<Estado> estados = estadoService.buscarTodos();
        estados = estadoService.buscarTodosPorNome(estadoRequestDTO.getNome());
        List<EstadoResponseDTO> listaDeRetorno = new ArrayList<>();
        estados.forEach(estado -> {
                    EstadoResponseDTO meuEstadoResponseDto = EstadoAdapter.transformarEntidadeEmDto(estado);
                    listaDeRetorno.add(meuEstadoResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @PostMapping
    public void criarEstado(@RequestBody EstadoRequestDTO estadoRequestDTO){
        estadoService.criar(estadoRequestDTO.getNome());
    }


    @DeleteMapping
    public void deletarEstado(@RequestBody EstadoRequestDTO estadoRequestDTO){
        List<Estado> estados;
        estados = estadoService.buscarTodosPorNome(estadoRequestDTO.getNome());
        if (estados.size()>0){
          for (int i = 0;  i < estados.size(); i++){
              estadoService.deletarPorId(estados.get(i).getId());
          }
        } else estadoService.deletarPorNome(estadoRequestDTO.getNome());

    }

    @PutMapping(path = "{id}")
    public void atualizarEstado(@PathVariable long id, @RequestBody EstadoRequestDTO estadoRequestDTO){
        estadoService.atualizar(id ,  estadoRequestDTO);
    }
}
