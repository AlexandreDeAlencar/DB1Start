package com.db1.cidades_api.adapter;

import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.responsedto.EstadoResponseDTO;

public class EstadoAdapter {

    public static EstadoResponseDTO transformarEntidadeEmDto(Estado estado){
        EstadoResponseDTO estadoResponseDTO = new EstadoResponseDTO();
        estadoResponseDTO.setNome(estado.getNome());
        estadoResponseDTO.setCidades(estado.getCidades());
        return estadoResponseDTO;
    }
}
