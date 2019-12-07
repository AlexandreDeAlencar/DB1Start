package com.db1.cidades_api.controller;

import com.db1.cidades_api.adapter.ClienteAdapter;
import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.requestdto.ClienteRequestDTO;
import com.db1.cidades_api.responsedto.ClienteResponseDTO;
import com.db1.cidades_api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("clientes")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponseDTO> buscarTodosClientes(){
        List<Cliente> clientes = clienteService.buscarTodos();
        List<ClienteResponseDTO> listaDeRetorno = new ArrayList<>();
        clientes.forEach(cliente -> {
                    ClienteResponseDTO meuClienteResponseDto = ClienteAdapter.transformarEntidadeEmDto(cliente);
                    listaDeRetorno.add(meuClienteResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @GetMapping("/nome")
    public List<ClienteResponseDTO> buscarClientePorNome(@RequestBody ClienteRequestDTO clienteRequestDTO){
        List<Cliente> clientes = clienteService.buscarTodos();
        clientes = clienteService.buscarTodosPorNome(clienteRequestDTO.getNome());
        List<ClienteResponseDTO> listaDeRetorno = new ArrayList<>();
        clientes.forEach(cliente -> {
                    ClienteResponseDTO meuClienteResponseDto = ClienteAdapter.transformarEntidadeEmDto(cliente);
                    listaDeRetorno.add(meuClienteResponseDto);
                }
        );
        return listaDeRetorno;
    }

    @PostMapping
    public void criarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        clienteService.criar(clienteRequestDTO.getNome(), clienteRequestDTO.getCpf(), clienteRequestDTO.getTelefone());
    }


    @DeleteMapping
    public void deletarCliente(@RequestBody ClienteRequestDTO clienteRequestDTO){
        List<Cliente> clientes;
        clientes = clienteService.buscarTodosPorNome(clienteRequestDTO.getNome());
        if (clientes.size()>0){
            for (int i = 0;  i < clientes.size(); i++){
                clienteService.deletarPorId(clientes.get(i).getId());
            }
        } else clienteService.deletarPorNome(clienteRequestDTO.getNome());

    }

    @PutMapping(path = "{id}")
    public void atualizarCliente(@PathVariable long id, @RequestBody ClienteRequestDTO clienteRequestDTO){
        clienteService.atualizar(id ,  clienteRequestDTO.getNome(), clienteRequestDTO.getCpf(), clienteRequestDTO.getTelefone());
    }
}


