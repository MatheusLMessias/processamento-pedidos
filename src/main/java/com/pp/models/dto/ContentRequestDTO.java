package com.pp.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentRequestDTO {
    private String product;
    private int quantity;
    private double value;

    public ContentRequestDTO(String product, int quantity, double value) {
        this.product = product;
        this.quantity = quantity;
        this.value = value;
    }
}
