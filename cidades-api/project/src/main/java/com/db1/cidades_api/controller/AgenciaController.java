package com.db1.agencias_api.controller;

import com.db1.cidades_api.adapter.AgenciaAdapter;
import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.requestdto.AgenciaRequestDTO;
import com.db1.cidades_api.responsedto.AgenciaResponseDTO;
import com.db1.cidades_api.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("agencias")
@RestController
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public List<AgenciaResponseDTO> buscarTodosAgencias() {
        List<Agencia> agencias = agenciaService.buscarTodos();
        List<AgenciaResponseDTO> listaDeRetorno = new ArrayList<>();
        agencias.forEach(agencia -> {
                    AgenciaResponseDTO meuAgenciaResponseDto = AgenciaAdapter.transformarEntidadeEmDto(agencia);
                    listaDeRetorno.add(meuAgenciaResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @GetMapping("/numero")
    public List<AgenciaResponseDTO> buscarAgenciaPorNumero(@RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        List<Agencia> agencias = agenciaService.buscarTodos();
        agencias = agenciaService.buscarTodosPorNumero(agenciaRequestDTO.getNumero());
        List<AgenciaResponseDTO> listaDeRetorno = new ArrayList<>();
        agencias.forEach(agencia -> {
                    AgenciaResponseDTO meuAgenciaResponseDto = AgenciaAdapter.transformarEntidadeEmDto(agencia);
                    listaDeRetorno.add(meuAgenciaResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @PostMapping
    public void criarAgencia(@RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        agenciaService.criar(agenciaRequestDTO.getNumero(), agenciaRequestDTO.getCidade());
    }


    @DeleteMapping
    public void deletarAgencia(@RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        List<Agencia> agencias;
        agencias = agenciaService.buscarTodosPorNumero(agenciaRequestDTO.getNumero());
        if (agencias.size() > 0) {
            for (int i = 0; i < agencias.size(); i++) {
                agenciaService.deletarPorId(agencias.get(i).getId());
            }
        } else agenciaService.deletarPorNumero(agenciaRequestDTO.getNumero());

    }

    @PutMapping(path = "{id}")
    public void atualizarAgencia(@PathVariable long id, @RequestBody AgenciaRequestDTO agenciaRequestDTO) {
        agenciaService.atualizar(id, agenciaRequestDTO.getNumero(), agenciaRequestDTO.getCidade());
    }
}
