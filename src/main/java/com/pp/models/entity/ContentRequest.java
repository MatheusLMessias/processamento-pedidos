package com.pp.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "content_request")
@Getter
@Setter
public class ContentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private Integer quantity;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "codeRequest")
    @JsonBackReference
    private Request request;

    public ContentRequest(String product, int quantity, double value) {
        this.product = product;
        this.quantity = quantity;
        this.value = value;
    }

    public ContentRequest() {
    }
}
