package com.db1.cidades_api.adaptar;

import com.db1.cidades_api.dto.EstadoRequestDTO;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.dto.EstadoResponseDTO;

public class EstadoAdapter {

    public static EstadoResponseDTO transformarEntidadeEmDto(Estado estado){
        EstadoResponseDTO estadoResponseDTO = new EstadoResponseDTO();
        estadoResponseDTO.setNome(estado.getNome());
        estadoResponseDTO.setCidades(estado.getCidades());
        return estadoResponseDTO;
    }


}
