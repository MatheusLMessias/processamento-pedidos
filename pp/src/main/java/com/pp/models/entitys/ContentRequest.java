package com.pp.models.entitys;

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
    private Request request;
}