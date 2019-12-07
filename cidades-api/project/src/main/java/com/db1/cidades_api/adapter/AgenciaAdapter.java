package com.db1.cidades_api.adapter;
import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.responsedto.AgenciaResponseDTO;

public class AgenciaAdapter {

    public static AgenciaResponseDTO transformarEntidadeEmDto(Agencia agencia) {
        AgenciaResponseDTO agenciaResponseDTO = new AgenciaResponseDTO();
        agenciaResponseDTO.setNumero(agencia.getNumero());
        agenciaResponseDTO.setCidade(agencia.getCidade());
        agenciaResponseDTO.setContas(agencia.getContas());
        return agenciaResponseDTO;
    }
}
