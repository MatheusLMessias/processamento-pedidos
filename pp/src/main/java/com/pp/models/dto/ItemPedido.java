package com.pp.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedido {
    private String produto;
    private int quantidade;
    private double preco;

    public ItemPedido(String produto, int quantidade, double preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
