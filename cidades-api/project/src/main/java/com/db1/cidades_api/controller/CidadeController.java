package com.db1.cidades_api.controller;

import com.db1.cidades_api.adapter.CidadeAdapter;
import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.requestdto.CidadeRequestDTO;
import com.db1.cidades_api.responsedto.CidadeResponseDTO;
import com.db1.cidades_api.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("cidades")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public List<CidadeResponseDTO> buscarTodosCidades(){
        List<Cidade> cidades = cidadeService.buscarTodos();
        List<CidadeResponseDTO> listaDeRetorno = new ArrayList<>();
        cidades.forEach(cidade -> {
                    CidadeResponseDTO meuCidadeResponseDto = CidadeAdapter.transformarEntidadeEmDto(cidade);
                    listaDeRetorno.add(meuCidadeResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @GetMapping("/nome")
    public List<CidadeResponseDTO> buscarCidadePorNome(@RequestBody CidadeRequestDTO cidadeRequestDTO){
        List<Cidade> cidades = cidadeService.buscarTodos();
        cidades = cidadeService.buscarTodosPorNome(cidadeRequestDTO.getNome());
        List<CidadeResponseDTO> listaDeRetorno = new ArrayList<>();
        cidades.forEach(cidade -> {
                    CidadeResponseDTO meuCidadeResponseDto = CidadeAdapter.transformarEntidadeEmDto(cidade);
                    listaDeRetorno.add(meuCidadeResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @PostMapping
    public void criarCidade(@RequestBody CidadeRequestDTO cidadeRequestDTO){
        cidadeService.criar(cidadeRequestDTO.getNome(), cidadeRequestDTO.getUf());
    }


    @DeleteMapping
    public void deletarCidade(@RequestBody CidadeRequestDTO cidadeRequestDTO){
        List<Cidade> cidades;
        cidades = cidadeService.buscarTodosPorNome(cidadeRequestDTO.getNome());
        if (cidades.size()>0){
            for (int i = 0;  i < cidades.size(); i++){
                cidadeService.deletarPorId(cidades.get(i).getId());
            }
        } else cidadeService.deletarPorNome(cidadeRequestDTO.getNome());

    }

    @PutMapping(path = "{id}")
    public void atualizarCidade(@PathVariable long id, @RequestBody CidadeRequestDTO cidadeRequestDTO){
        cidadeService.atualizar(id ,  cidadeRequestDTO.getNome(), cidadeRequestDTO.getUf());
    }
}

