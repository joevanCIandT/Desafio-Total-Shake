package br.com.desafio.totalshake.model;

import javax.persistence.Entity;

public enum Status {
    REALIZADO,
    CANCELADO,
    PAGO,
    NAO_AUTORIZADO,
    CONFIRMADO,
    PRONTO,
    SAIU_PARA_ENTREGA,
    ENTREGUE;


}
