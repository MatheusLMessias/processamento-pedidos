package com.pp.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Pedido {
    private int codigoPedido;
    private int codigoCliente;
    private List<ItemPedido> itens;
}
