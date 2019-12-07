package com.db1.cidades_api.adapter;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.responsedto.CidadeResponseDTO;

public class CidadeAdapter {

    public static CidadeResponseDTO transformarEntidadeEmDto(Cidade cidade) {
        CidadeResponseDTO cidadeResponseDTO = new CidadeResponseDTO();
        cidadeResponseDTO.setNome(cidade.getNome());
        cidadeResponseDTO.setUf(cidade.getUf());
        cidadeResponseDTO.setAgencias(cidade.getAgencias());
        return cidadeResponseDTO;
    }
}
