package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.PedidoDTO;
import br.com.desafio.totalshake.form.PedidoForm;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoControllerTest {

    @InjectMocks
    PedidoController pedidoController;

    @InjectMocks
    PedidoService pedidoService;

    @Test
    public void testAddPedido()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        PedidoForm pedidoForm = new  PedidoForm();
        ResponseEntity<PedidoDTO> responseEntity = pedidoController.cadastrar(pedidoForm);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }


}