package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Estado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

    @RunWith(SpringRunner.class)
    @SpringBootTest
    public class EstadoServiceTest {

        @Autowired
        private EstadoService estadoService;

        @Test
        public void esperaEstadoCriado() {
            Estado estado = estadoService.criar("Paraná");
            Assert.assertNotNull(estado);
            System.out.println(estado.getId());
        }

        @Test
        public void esperaaAcharEstado() {
            Estado estado = new Estado();
            estado = estadoService.findByNome("Paraná");
            Assert.assertNotNull(estado);
            System.out.println(estado.getId());
        }
        @Test
        public void deletarEstado() {
            estadoService.deletar("Paraná");
            Estado estado = new Estado();
            estado = estadoService.findByNome("Paraná");
        }


    }

